package com.codinghive.ticketMonster.jee.rest;
import com.codinghive.ticketMonster.jee.model.Ticket;
import com.codinghive.ticketMonster.jee.rest.ejb.TicketBL;
import com.codinghive.ticketMonster.jee.rest.ejb.UserBL;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/userRest")
public class UserService {
    
    @Inject
    private UserBL userBL;
    @Inject
    private TicketBL ticketBL;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    
    @POST
    @Consumes("application/json")
    @Path("/register")
    //register rest resvice which registers user if he doesnt exist already
    ///////////////////////////////////////////////
    public Response regsiter(InputStream incomingData) {
        StringBuilder crunchifyBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            LOGGER.info("Error Parsing: - ");
        }
        LOGGER.info("Data Received: " + crunchifyBuilder.toString());
        // template code above ↑↑↑ (ALT + 24 / 26)
        // business logic
        String jsonString = crunchifyBuilder.toString();
        final JSONObject obj = new JSONObject(jsonString);

        if (userBL.register(obj.getString("u_name"), obj.getString("u_pw"), obj.getString("u_fname"))==true){
            // return HTTP response 200 in case of success
            return Response.status(200).entity(crunchifyBuilder.toString()).build();
        }else{
            return Response.status(500).entity(crunchifyBuilder.toString()).build();
        }  
    }   
    
    
    @POST
    @Produces("application/json") 
    @Path("/login/")
    //Probably not BEST PRACTICE but there was no time for better implementation
    //login rest service which logins user ( returns userId if user found or 0 if not ) if user with username u_name is found and his pw matches u_pw
    //https://vrsbrazil.wordpress.com/2013/08/07/passing-parameters-to-a-restful-web-service/
    ////////////////
    public String logIn(@QueryParam("u_name") String u_name, @QueryParam("u_pw") String u_pw) {
        Integer logedInUserId = userBL.logIn(u_name,u_pw);
        if (logedInUserId != 0){ // convention we followed for user not existing
            //returns String because Produces couldnt allow me to return integer
            return logedInUserId.toString();
        }else{
            //returns String because Produces couldnt allow me to return integer
            return "0";
        }
    }
    
    @GET
    @Produces("application/json")
    @Path("/getUserName/{id:[0-9][0-9]*}")
    public String getUserName(@PathParam("id") int id){
        //dont ask why - Front end demanded it - angular is weird
        String jsonReturnString = "[";
        if ( userBL.getUserFromId(id) == null ) {
            LOGGER.info("User by id: " + id + " not found.");
            return null;
        }else{
            Gson gson = new Gson();
            String gsonString = gson.toJson(userBL.getUserFromId(id));
            jsonReturnString = jsonReturnString.concat(gsonString);
            jsonReturnString = jsonReturnString.concat("]");
            //dont ask why - Front end demanded it - angular is weird
            return jsonReturnString;
        }   
    }
    
    @GET
    @Produces("application/json")
    @Path("/getReservationsOfUsers/{u_Id:[0-9][0-9]*}")
    public String getReservationsOfUserById(@PathParam("u_Id") int u_Id){
        String jsonReturnString = "[";
        List<Ticket> ticketList = ticketBL.getReservationsOfUserById(u_Id);     
        Gson gson = new Gson();
        for (int i = 0; i < ticketList.size(); i++) {
            // 2. Java object to JSON, and assign to a String
            String jsonInString = gson.toJson(ticketList.get(i));
            //necessary for appropriate json formating
            if (i != ticketList.size() - 1) {
                jsonReturnString = jsonReturnString.concat(jsonInString + ",");
            } else {
                jsonReturnString = jsonReturnString.concat(jsonInString);
            }
        }
        //necessary for appropriate json formating
        jsonReturnString = jsonReturnString.concat("]");
        LOGGER.info("Printing DATABASE Json:" + jsonReturnString);
        return jsonReturnString;
    }
    
    
    
    
    
    
       
}
