/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import java.util.List;

/**
 *
 * @author Kleanthis Sakarikos
 */
public interface TicketDaoLocal {
    void addTicket(Ticket ticket);
    
    
    List<Ticket> getAllTicket();

    
//    Ticket getTicket(int ticketId);

    
//    int getAllLazy();

//    List<Ticket> search();
    
//    Object searchSingle();

    public void addTickToArrayList(Ticket ticket);

}
