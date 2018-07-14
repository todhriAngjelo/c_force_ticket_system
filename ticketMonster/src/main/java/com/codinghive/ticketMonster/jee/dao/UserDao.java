package com.codinghive.ticketMonster.jee.dao;
import com.codinghive.ticketMonster.jee.model.Ticket;
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
    
    // find and get user from db with userName u_Name
    //////////////////////////////////////////////////
    public List<User> getUserFromUsername(String u_Name){
        return em.createQuery(
        "SELECT u FROM User u WHERE u.u_Name = :u_Name", User.class).
        setParameter("u_Name", u_Name).getResultList();
    } 
    
    //add user to the database using entity manager ( JPA ) 
    /////////////////////////////////
     public void addUser(User user) {
        //communication with database is on
        em.getTransaction().begin();
        em.persist(user);
        //communication with database is off
        em.getTransaction().commit();
        LOGGER.info("Created Ticket:" + user);
    }
       
    
    //function that updates a registry into the db
    /////////////////////////////////
    public void dbUpdate(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        LOGGER.info("merge User into db");       
    } 
    
    
    //return user object by Id = this.id
    //returns null if object by Id = this.id not found
    ///////////////////////////////
    public User getUserFromId(int u_Id) {
        //returns ticket entity by id  = this.id
        return em.createQuery(
        "SELECT u FROM User u WHERE u.u_Id = :u_Id", User.class).
        setParameter("u_Id", u_Id).getSingleResult();
    }
    

    public List<User> getAllUserList() {
        return em.createNamedQuery("User.getAll").getResultList();
    }

}        
