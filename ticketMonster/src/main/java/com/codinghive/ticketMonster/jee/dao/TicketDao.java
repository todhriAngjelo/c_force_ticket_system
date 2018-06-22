/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.LoggerFactory;

@Stateless(name="TicketDAO")
public class TicketDao implements TicketDaoLocal{
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);

    protected static final String STUDENT_PU = "mariaDB-eclipselink";

    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;
       
   
    @Override
    public void addTicket(Ticket ticket) {  
    	em.getTransaction().begin();
		
        em.persist(ticket);
        
        
        em.getTransaction().commit();

        LOGGER.info("Created Ticket:" + ticket);
    }
    
    

    @Override
    public Ticket getTicket(int userId) {
        return em.find(Ticket.class, userId);
    }

    @Override
    public List<Ticket> getAllTicket() {
        return em.createNamedQuery("Ticket.getAll").getResultList();
    }

    @Override
    public int getAllLazy() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        	return 0;

    }

    public List<Ticket> search() {
        Query query = em.createQuery("Select e FROM Ticket ");
    	List<Ticket> result = query.getResultList();   
        return result;
 }

    @Override
    public Object searchSingle() {
Query query = em.createQuery("Select e FROM Users e WHERE e.userId = :id");
    	query.setParameter("id", 1);
    	Ticket result = (Ticket)query.getSingleResult();
    	 
    	// Query for a single data element.
//    	Query query = em.createQuery("Select MAX(e.grade) FROM Student e");
//    	BigDecimal result = (BigDecimal)query.getSingleResult();
    	
//    	Query query = em.createQuery("Select e FROM Student e JOIN e.projectList u WHERE u.name = :name");
//    	query.setParameter("name", "student_example");
//    	Student result = (Student)query.getSingleResult();
    	


    	
    	return result;    }
    
}
