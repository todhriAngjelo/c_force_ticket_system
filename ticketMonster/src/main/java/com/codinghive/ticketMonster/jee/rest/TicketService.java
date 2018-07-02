/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.rest;

import com.codinghive.ticketMonster.jee.dao.TicketDao;
import org.slf4j.Logger;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.slf4j.LoggerFactory;

@Path("/allticket")
public class TicketService {

    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);
    
    @Inject
    private TicketDao ticketDao;
    
    /////////////
    //https://www.tutorialspoint.com/restful/restful_first_application.htm
    @GET
    @Produces("application/json")
    public String getAllTicketsJson() {
        String ticketObj = ticketDao.getJsonsFromDB();
        String result = ticketObj;
        return result;
    }
    /////////////
    @POST
    @Produces("application/json")
    @Path("/reserveTicket/{id:[0-9][0-9]*}")
    public String reserveTicket(@PathParam("id") int id) {
        ticketDao.reserveTicket(id);
        return ticketDao.getJsonsFromDB();
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

        ticketDao.addTicketFromJson(crunchifyBuilder.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(crunchifyBuilder.toString()).build();
    }        
}

