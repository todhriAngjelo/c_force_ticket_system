/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.rest;

import com.codinghive.ticketMonster.jee.dao.TicketDao;
import com.codinghive.ticketMonster.jee.model.Ticket;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

    
@Path("/allticket")
public class TicketService {
        
    @Inject
    private TicketDao ticketDao;

    @GET
    @Produces("application/xml")
    public String getAllTicketsJson() {

        String ticketObj = ticketDao.getJsonsFromDB();

        String result = ticketObj;

        return "<allticket>" + "<ctofoutput>" + result + "</ctofoutput>" + "</allticket>";
  }
    
   @POST
   @Consumes("application/xml")
   public String create(Ticket ticket)
   {
        ticketDao.addTicket(ticket);
        
        String ticketObj = ticketDao.getJsonsFromDB();

        String result = ticketObj;
        return "<allticket>" + "<ctofoutput>" + result + "</ctofoutput>" + "</allticket>";
   }
   
 
        
      	
}