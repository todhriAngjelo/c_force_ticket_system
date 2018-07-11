
package com.codinghive.ticketMonster.jee.rest;

import com.codinghive.ticketMonster.jee.model.Ticket;
import com.codinghive.ticketMonster.jee.rest.ejb.TicketBL;
import com.google.gson.Gson;
import org.slf4j.Logger;
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
import javax.ws.rs.core.Response;
import org.slf4j.LoggerFactory;

@Path("/ticketRest")
public class TicketService {

    @Inject
    private TicketBL ticketBL;  
    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketService.class);
   
    
    @GET
    @Produces("application/json")
    @Path("/getAllTickets")
    //https://www.tutorialspoint.com/restful/restful_first_application.htm
    ///////////////////////////
    public String getAllTickets() {
        //necessary for appropriate json formating
        String returnString = "[";
        //Gson object initiation so i can call json methods
        Gson gson = new Gson();
        //list with tickets that i will store my ticket objects and toJson() transform them
        List<Ticket> ticketList = ticketBL.getAllTicketList();
        //loop for number of tickets found in database
        for (int i = 0; i < ticketList.size(); i++) {
            // 2. Java object to JSON, and assign to a String
            String jsonInString = gson.toJson(ticketList.get(i));
            //necessary for appropriate json formating
            if (i != ticketList.size() - 1) {
                returnString = returnString.concat(jsonInString + ",");
            } else {
                returnString = returnString.concat(jsonInString);
            }
        }
        //necessary for appropriate json formating
        returnString = returnString.concat("]");
        LOGGER.info("Printing DATABASE Json:" + returnString);  
        return returnString;
    }
    
    
    @GET
    @Produces("application/json")
    @Path("/getAllAvailableTickets")
    //////////////////////////////////
    public String getAllAvailableTickets() {
        List<Ticket> ticketList = ticketBL.getAllAvailableTicketsList();
        String returnString = "[";
        Gson gson = new Gson();
        for (int i = 0; i < ticketList.size(); i++) {
            // 2. Java object to JSON, and assign to a String
            String jsonInString = gson.toJson(ticketList.get(i));
            //necessary for appropriate json formating
            if (i != ticketList.size() - 1) {
                returnString = returnString.concat(jsonInString + ",");
            } else {
                returnString = returnString.concat(jsonInString);
            }
        }
        //necessary for appropriate json formating
        returnString = returnString.concat("]");
        LOGGER.info("Printing DATABASE Json:" + returnString);
        return returnString;
    }
      
    @POST
    @Produces("application/json")
    @Path("/cancelReservation/{id:[0-9][0-9]*}")
    /////////////////////////////////////////////////
    public String cancelTicket(@PathParam("id") int id){
        ticketBL.cancelTicket(id);
        return getAllTickets();
    }
   
    @POST
    @Produces("application/json")
    @Path("/reserveTicket/{ticket_id:[0-9][0-9]*}")
    /////////////////////////////////////////////////////////
    public String reserveTicket(@PathParam("ticket_id") int id) {
        ticketBL.reserveTicket(id);
        return getAllTickets();
    }
    
    /////////////
    //https://stackoverflow.com/questions/28983048/how-to-consume-json-parameter-in-java-restful-service
    @POST
    @Consumes("application/json")
    @Path("/addTicket")
    public Response addTicket(InputStream incomingData) {
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
        ticketBL.addTicketFromJson(crunchifyBuilder.toString());
        // return HTTP response 200 in case of success
        return Response.status(200).entity(crunchifyBuilder.toString()).build();
    }       
}

