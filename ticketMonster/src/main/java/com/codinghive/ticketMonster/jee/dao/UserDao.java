package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.User;
import java.util.List;
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
    
    //method that gives to the new registering user automatically an id ( based on the max existing id + 1 )
    ////////////////////////
    public int idAssignment(){
        //get all entries - probably not that safe
        List<User> users = em.createNamedQuery("User.getAll").getResultList();
        //initiating max in negative - probably admin user is inserted manually with id 0
        int max = -1;
        //finding max and returning max + 1
        for (int i = 0 ; i < users.size(); i ++){
            if (users.get(i).getU_id()>max){
                max = users.get(i).getU_id();
            }
        }
        return max+1;
    }
    
    //register function that allows rest end point to create a new entry at our database with the given entries on the UI(rest end point)
    //////////////////////////////////////////////////////////
    public int register(String u_name, String u_pw, String f_name){
        //1.check if userName is used
        if (em.find(User.class, u_name)!=null){
            return 0;
        }
        //2.assign id to the user
        //3.create user and add to the DB
        int userId = idAssignment();
        User user = new User(u_name, userId, u_pw, f_name);
        addUser(user);
        //4.return 1 integer
        return 1;
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
}        

