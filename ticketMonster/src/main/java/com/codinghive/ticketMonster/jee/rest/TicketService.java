/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.rest;

import com.codinghive.ticketMonster.jee.dao.TicketDao;
import com.codinghive.ticketMonster.jee.model.Ticket;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

    
@Path("/allticket")
public class TicketService {
        
    @Inject
    private TicketDao ticketDao;

    @GET
    @Produces("application/json")
    public String getAllTicketsJson() {

        String ticketObj = ticketDao.getJsonsFromDB();

        String result = ticketObj;

        return  result ;
  }
    
    @PUT
    @Produces("application/json")
    @Path("/reserveTicket/{id:[0-9][0-9]*}")
    public String reserveTicket(@PathParam("id") int id)
    {
        ticketDao.reserveTicket(id);
        return ticketDao.getJsonsFromDB();


    }
   
 
        
      	
}