package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import com.google.gson.Gson;
import org.slf4j.Logger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.LoggerFactory;

@Stateless(name = "TicketDAO")
public class TicketDao {

    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);
    protected static final String STUDENT_PU = "mariaDB-eclipselink";
    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;

    ////////////////////////////////////////
    //add ticket to the user ticketArray
//    public void addTicketToUserArray(Ticket ticket, User user) {
//        em.getTransaction().begin();
//        em.persist(ticket);
//        em.getTransaction().commit();
//
//        user.addTicketToArray(ticket);
//        LOGGER.info("Created Ticket:" + ticket + "and added it to the ticketArrayList of the user with id: " + user.getU_id());
//    }

    ////////////////////////////////////////
    public void addTicket(Ticket ticket) {
        em.getTransaction().begin();

        em.persist(ticket);

        em.getTransaction().commit();

        LOGGER.info("Created Ticket:" + ticket);
    }

    ////////////////////////////////////////
    public int reserveTicket(int id) {
        Ticket ticket = search(id);
        int bookedFlag = ticket.getT_booked();
        if (bookedFlag != 0) {
            LOGGER.info("Ticket:" + ticket + "is already reserved.");
            return 0;
        } else {
            em.getTransaction().begin();
            ticket.setT_booked(1);
            LOGGER.info("Ticket:" + ticket + "is reserved now for user by ID: " + ticket.getTicketId());
            em.getTransaction().commit();
            return 1;
        }
    }

    ////////////////////////////////////////    
    public String getJsonsFromDB() {
        //necessary for appropriate json formating
        String returnString = "[";
        //Gson object initiation so i can call json methods
        Gson gson = new Gson();
        //list with tickets that i will store my ticket objects and toJson() transform them
        List<Ticket> ticketObj = getAllTicket();
        //loop for number of tickets found in database
        for (int i = 0; i < ticketObj.size(); i++) {
            // 2. Java object to JSON, and assign to a String
            String jsonInString = gson.toJson(ticketObj.get(i));
            //necessary for appropriate json formating
            if (i != ticketObj.size() - 1) {
                returnString = returnString.concat(jsonInString + ",");
            } else {
                returnString = returnString.concat(jsonInString);
            }
            LOGGER.info("Printing jsonString:" + jsonInString);
        }
        //necessary for appropriate json formating
        returnString = returnString.concat("]");
        LOGGER.info("Printing unitedAllTogether:" + returnString);
        return returnString;
    }

    ////////////////////////////////////////            
    public List<Ticket> getAllTicket() {
        return em.createNamedQuery("Ticket.getAll").getResultList();
    }

    ////////////////////////////////////////
    public Ticket search(int id) {
        return em.find(Ticket.class, id);
    }
}
