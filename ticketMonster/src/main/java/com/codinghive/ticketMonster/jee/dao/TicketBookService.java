/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


//@Path("/reserve")
@Path("/reserve/{id}")

public class TicketBookService {
           
    @Inject  
    private TicketDaoLocal ticketDao;

    @POST
    @Produces("application/json")
    public Ticket TicketBookService1(@PathParam("id") int id, 
                               Ticket TicketBookService1) {
        Ticket customer = new Ticket(id,1);
        ticketDao.addTicket(customer); 

        return customer;
    }   
}
