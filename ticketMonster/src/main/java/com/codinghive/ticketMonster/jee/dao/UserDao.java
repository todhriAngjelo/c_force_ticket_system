package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Stateless(name = "UseDao")
public class UserDao {
    
    //LOGGER object for console info logging
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
    protected static final String STUDENT_PU = "mariaDB-eclipselink";
    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;
    
    //method that allows user to login with checking if given inputs exist in our database ( throught end point - check ticketService.java on jee.rest package )
    ////////////////////////////////////////////
    public String logIn(String u_name, String u_pw){
        //find entry with u_name = this.u_name 
        //probably not so safe
        User user = em.find(User.class, u_name);
        //logger
        LOGGER.info("User: " + user);
        //returns integer 1 if user.get_pw equals to this.pw or 0 if not
        if (user.getU_Pw().equals(u_pw)){
            return Integer.toString(1);
        }else{
            return Integer.toString(0);
        }
    }   
    
    //register function that allows rest end point to create a new entry at our database with the given entries on the UI(rest end point)
    //////////////////////////////////////////////////////////
    public boolean register(String u_Name, String u_pw, String f_name){
        //1.check if userName is used
        if (em.createQuery(
        "SELECT u FROM User u WHERE u.u_Name = :u_Name", User.class).
        setParameter("u_Name", u_Name).getResultList().size() != 0){
            return false;
        }
        //2.assign id to the user
        //3.create user and add to the DB
        User user = new User(u_Name, u_pw, f_name);
        addUser(user);
        //4.return 1 integer
        return true;
    }
    
    //add user to the database using entity manager ( JPA ) 
    /////////////////////////////////
     public void addUser(User user) {
        //communication with database is on
        em.getTransaction().begin();
        //add ticket
        em.persist(user);
        //communication with database is off
        em.getTransaction().commit();
        LOGGER.info("Created Ticket:" + user);
    }
     
    //return user object by Id = this.id
    //returns nulll if object by Id = this.id not found
    ///////////////////////////////
    public User getUserById(int U_ID) {
        //returns ticket entity by id  = this.id
        User user = em.createQuery(
        "SELECT u FROM User u WHERE u.u_id = :U_ID", User.class).
        setParameter("U_ID", U_ID).getSingleResult();
        return user;
    }
}        
//"SELECT u from Ticket u WHERE u.t_booked=0", Ticket.class).getResultList();