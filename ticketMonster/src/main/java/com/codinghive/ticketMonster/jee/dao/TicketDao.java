/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.slf4j.Logger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.LoggerFactory;


@Stateless(name="TicketDAO")
public class TicketDao implements TicketDaoLocal{
    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketDao.class);

    protected static final String STUDENT_PU = "mariaDB-eclipselink";

    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;
       
    //initialisation of ticketArrayList used in addTickToArrayList();
    ArrayList<Ticket> ticketArrayList = new ArrayList<Ticket>();
   
    @Override //name says it its self.
    //edw ginonte add ta ticket mesw entity manager
    public void addTicket(Ticket ticket) {  
    	em.getTransaction().begin();
		
        em.persist(ticket);
        
        
        em.getTransaction().commit();

        LOGGER.info("Created Ticket:" + ticket);
    }
    //method gia na ginonte delete ta ticket mesw entity manager
    //public void addTicket(Ticket ticket) {  
    //	em.getTransaction().begin();
		
    //    em.persist(ticket);
        
        
    //    em.getTransaction().commit();

    //    LOGGER.info("Deleted Ticket:" + ticket);
   // }  
    
    
    @Override
    public String getJsonsFromDB(){
        //necessary for appropriate json formating
        String returnString = "[";
        //Gson object initiation so i can call json methods
        Gson gson = new Gson();
        //list with tickets that i will store my ticket objects and toJson() transform them
        List<Ticket> ticketObj = getAllTicket();
        //loop for number of tickets found in database
        for (int i=0; i < ticketObj.size(); i++){
            // 2. Java object to JSON, and assign to a String
            String jsonInString = gson.toJson(ticketObj.get(i)); 
            //necessary for appropriate json formating
            if (i!=ticketObj.size()-1){
                returnString = returnString.concat(jsonInString+",");
            }else{
                returnString = returnString.concat(jsonInString);
            }
            LOGGER.info("Printing jsonString:" + jsonInString);
         }
        //necessary for appropriate json formating
        returnString = returnString.concat("]");
        LOGGER.info("Printing unitedAllTogether:" + returnString); 
        return returnString;
    }
    
    //getAllTickets into a list   
    @Override
    public List<Ticket> getAllTicket() {
        return em.createNamedQuery("Ticket.getAll").getResultList();
    }
    //creating array List for Tickets
    @Override
    public void addTickToArrayList(Ticket ticket) {
        ticketArrayList.add(ticket);
        LOGGER.info("Added Ticket" + ticket + "to array:");  
    }
}
//-------------------------------------------
//    @Override
//    public Object searchSingle() {
//Query query = em.createQuery("Select e FROM Users e WHERE e.userId = :id");
//    	query.setParameter("id", 1);
//    	Ticket result = (Ticket)query.getSingleResult();
//    	 
//    	// Query for a single data element.
////    	Query query = em.createQuery("Select MAX(e.grade) FROM Student e");
////    	BigDecimal result = (BigDecimal)query.getSingleResult();
//    	
////    	Query query = em.createQuery("Select e FROM Student e JOIN e.projectList u WHERE u.name = :name");
////    	query.setParameter("name", "student_example");
////    	Student result = (Student)query.getSingleResult();
//    	
//
//
//    	
//    	return result;    }




//-------------------------------------------
//    public List<Ticket> search() {
//        Query query = em.createQuery("Select e FROM Ticket ");
//    	List<Ticket> result = query.getResultList();   
//        return result;
// }




//-------------------------------------------
//    @Override
//    public int getAllLazy() {
//       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        	return 0;
//
//    }



//-------------------------------------------
//    @Override
//    public Ticket getTicket(int userId) {
//        return em.find(Ticket.class, userId);
//    }