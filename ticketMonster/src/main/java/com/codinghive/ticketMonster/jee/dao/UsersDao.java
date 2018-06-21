/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;
import com.codinghive.ticketMonster.jee.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alkis_Sakarikos
 */
@Stateless(name="UserDAO")

public class UsersDao implements usersDaoLocal{
     private static final Logger LOGGER = LoggerFactory.getLogger(StudentDao.class);

    protected static final String STUDENT_PU = "mariaDB-eclipselink";

    @PersistenceContext(unitName = STUDENT_PU)
    private EntityManager em;

    /**
     *
     * @param users
     */
    @Override
    public void addUsers(Users users) {
    	em.getTransaction().begin();
		
        em.persist(users);
        
        
        em.getTransaction().commit();

        LOGGER.info("Created Users:" + users);
    }

    @Override
    public Users getUsers(int userId) {
        return em.find(Users.class, userId);
    }

    @Override
    public List<Users> getAllUsers() {
        return em.createNamedQuery("Users.getAll").getResultList();
    }

    @Override
    public int getAllLazy() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        	return 0;

    }

    public List<Users> search() {
Query query = em.createQuery("Select e FROM Users ");
    	List<Users> result = query.getResultList();   
        return result;
 }

    @Override
    public Object searchSingle() {
Query query = em.createQuery("Select e FROM Users e WHERE e.userId = :id");
    	query.setParameter("id", 1);
    	Users result = (Users)query.getSingleResult();
    	 
    	// Query for a single data element.
//    	Query query = em.createQuery("Select MAX(e.grade) FROM Student e");
//    	BigDecimal result = (BigDecimal)query.getSingleResult();
    	
//    	Query query = em.createQuery("Select e FROM Student e JOIN e.projectList u WHERE u.name = :name");
//    	query.setParameter("name", "student_example");
//    	Student result = (Student)query.getSingleResult();
    	


    	
    	return result;    }
}
