package com.codinghive.ticketMonster.jee.rest.ejb;
import com.codinghive.ticketMonster.jee.dao.UserDao;
import com.codinghive.ticketMonster.jee.model.Ticket;
import com.codinghive.ticketMonster.jee.model.User;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserBL {
    
    @Inject
    private UserDao userDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
       
    
    //register function that allows rest end point to create a new entry at our database with the given entries on the UI
    ///////////////////////////////////////////////////////////////
    public boolean register(String u_Name, String u_pw, String f_name){
        List<User> userList = userDao.getUserFromUsername(u_Name);
        //1.check if userName is used
        if (userList.size() != 0){           
            return false;
        }
        //2.create user and add to the DB
        User user = new User(u_Name, u_pw, f_name);
        userDao.addUser(user);
        //3.return true
        return true;
    }
    
    //login function that brings user entity and checks pw and username fields if match with logIn function parameters
    //////////////////////////////////////////////
    public Integer logIn(String u_name, String u_pw){
       //find entry with u_name = this.u_name
       //probably not so safe
       //getting user with index 0 because getUserFromUsername returns List
       User user = userDao.getUserFromUsername(u_name).get(0);
       //print at console
       LOGGER.info("User: " + user);
       //returns integer 1 if user.get_pw equals to this.pw or 0 if not
       if (user.getU_Pw().equals(u_pw)){
           return user.getU_Id();
       }else{
           return 0;
        }
    }
   
    //return user object by Id = this.id
    //returns null if object by Id = this.id not found
    ///////////////////////////////
    public User getUserFromId(int u_Id) {
        return userDao.getUserFromId(u_Id);             
    }     
    
    //return user object by u_Name = this.u_Name
    //returns null if object by u_Name = this.u_Name not found
    ///////////////////////////////
    public User getUserFromUname(String u_Name){
        return userDao.getUserFromUsername(u_Name).get(0);             
    }

    public List<User> getAllUsers() {
        List<User> userList = userDao.getAllUserList();    
        return userList;
    }
}
