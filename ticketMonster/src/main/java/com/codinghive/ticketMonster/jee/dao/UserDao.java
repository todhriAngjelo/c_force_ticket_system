package com.codinghive.ticketMonster.jee.dao;

import com.codinghive.ticketMonster.jee.model.Ticket;
import com.codinghive.ticketMonster.jee.model.User;
import java.util.List;
//import com.google.gson.Gson;
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
    
    
    public String logIn(String u_name, String u_pw){
     
        User user = em.find(User.class, u_name);
        
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(user);
     
        LOGGER.info("User: " + user);
        if (user.getU_Pw().equals(u_pw)){
            return Integer.toString(1);
        }else{
            return Integer.toString(0);
        }
    }   
    
    public int idAssignment(){
        List<User> users = em.createNamedQuery("User.getAll").getResultList();
        int max = -1;
        for (int i = 0 ; i < users.size(); i ++){
            if (users.get(i).getU_id()>max){
                max = users.get(i).getU_id();
            }
        }
        return max+1;
    }
    
    public int register(String u_name, String u_pw, String f_name){
        //1.check if userName is used
        if (em.find(User.class, u_name)!=null){
            return 0;
        }
        //2.assign id to the user
        //3.create user and add to the DB
        int userId = idAssignment();
        User user = new User(u_name, userId, u_pw, f_name);
        addTicket(user);
        //4.return 1 integer
        return 1;
    }
    
    
     public void addTicket(User user) {
        //communication with database is on
        em.getTransaction().begin();
        //add ticket
        em.persist(user);
        //communication with database is off
        em.getTransaction().commit();
        LOGGER.info("Created Ticket:" + user);
    }
}        

