/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.rest.ejb;

import com.codinghive.ticketMonster.jee.dao.TicketDao;
import com.codinghive.ticketMonster.jee.model.Ticket;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Todhri Angjelo
 */
public class TicketBL {
    
    
    @Inject
    private TicketDao ticketDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);
    
    
    //function that adds a Ticket to the DB which ticket is created by manipulating a json formated string - function called by Rest End point
    /////////////////////////////////////////////////
    public void addTicketFromJson(String jsonStringData) {
        //Create Json Object from JsonStringData
        final JSONObject obj = new JSONObject(jsonStringData);
        //Create ticket object from JsonObject
        Ticket ticket = new Ticket(obj.getString("t_title"), obj.getInt("t_price"), obj.getInt("user_id"), obj.getInt("t_booked"));
        //Add Ticket Object to DB
        ticketDao.addTicket(ticket);
        LOGGER.info("Created and added ticket to database from REST endpoint");
    }
    
    
    //function that communicates with database in order to reserve a ticket ( change t_booked flag from 0 to 1 ) - function called by Rest End point
    ////////////////////////////////
    public boolean reserveTicket(int id) {
        Ticket ticket = ticketDao.getTicketById(id);
        // if ticket id not found entity manager will return null to the ticket object
        if ( ticket == null){
            LOGGER.info("Ticket with id: " + id + " doesn't exist.");
            return false;
        }
        //get ticket bookedFlag ( 0 or 1 ) into int variable
        int bookedFlag = ticket.getT_booked();
        //return 0 if ticket already booked
        if (bookedFlag != 0) {
            LOGGER.info("Ticket: " + ticket + " is already reserved.");
            return false;
        } else {
            //communication with database is on
            ticket.setT_booked(1);
            //communication with database is of
            ticketDao.dbUpdate(ticket);
            return true;
        }
    }
    
     public boolean  cancelTicket(int id) {
        Ticket ticket = ticketDao.getTicketById(id);
        // if ticket id not found entity manager will return null to the ticket object at line 37
        if ( ticket == null){
            LOGGER.info("Ticket with id:" + ticket.getUser_Id() + " doesn't exist.");
            return false;
        }
        //get ticket bookedFlag ( 0 or 1 ) into int variable
        int bookedFlag = ticket.getT_booked();
        //return 0 if ticket already booked
        if (bookedFlag != 1) {
            LOGGER.info("Ticket:" + ticket + "is already available. Wrong Id must be provided.");
            return false;
        } else {
            ticket.setT_booked(0);
            LOGGER.info("Ticket:" + ticket + "is now canceled from the user by ID: " + ticket.getT_id());
            ticketDao.dbUpdate(ticket);
            return true;
        }
    }
    
    
    //Commnication with dao in order to take the List<Ticket>
    //////////////////////////////  
    public List<Ticket> getAllTicketList() {
        List<Ticket> ticketList = ticketDao.getAllTicketList();    
        return ticketList;
    }
    
    public List<Ticket> getAllAvailableTicketsList(){
        List<Ticket> ticketList = ticketDao.getAvailableTickets();    
        return ticketList;
    }
}
