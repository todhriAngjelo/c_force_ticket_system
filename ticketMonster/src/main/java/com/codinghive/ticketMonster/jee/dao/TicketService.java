/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;

@Path("/allticket")
public class TicketService {
       @Inject
    private TicketDaoLocal ticketDao;
    
		@GET
	@Produces("application/xml")
	public String convertCtoF() {
 
		
                  String ticketObj = ticketDao.getJsonsFromDB();

        //list with tickets that i will store my ticket objects and toJson() transform them
        
        //loop for number of tickets found in database
        
                
                
		String result = ticketObj;
          
		
                return "<allticket>" + "<ctofoutput>" + result + "</ctofoutput>" + "</allticket>";
      }
        
      	
}