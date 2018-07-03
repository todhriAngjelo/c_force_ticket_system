package com.codinghive.ticketMonster.jee.rest;

import com.codinghive.ticketMonster.jee.dao.UserDao;
import com.codinghive.ticketMonster.jee.model.Ticket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/user")
public class UserService {
    
    @Inject
    private UserDao userDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    
    ////////////////////////
    @GET
    @Produces("application/json")
    //https://vrsbrazil.wordpress.com/2013/08/07/passing-parameters-to-a-restful-web-service/
    @Path("/login/")
    public String logIn(@QueryParam("u_name") String u_name, @QueryParam("u_pw") String u_pw) {
        return userDao.logIn(u_name,u_pw);
    }
    
    ////////////////////////
    @POST
    @Consumes("application/json")
    @Path("/register")
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
        // template code above ↑↑↑ (ALT + 24 / 26 )
        // business logic
        String jsonString = crunchifyBuilder.toString();
        final JSONObject obj = new JSONObject(jsonString);
        
        if (userDao.register(obj.getString("u_name"), obj.getString("u_fname"), obj.getString("u_pw"))==1){
            // return HTTP response 200 in case of success
            return Response.status(200).entity(crunchifyBuilder.toString()).build();
        }else{
            return Response.status(500).entity(crunchifyBuilder.toString()).build();
        }  
    }      
}
