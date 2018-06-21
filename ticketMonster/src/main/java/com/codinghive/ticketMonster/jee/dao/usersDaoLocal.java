/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.dao;
import com.codinghive.ticketMonster.jee.model.Users;

import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Alkis_Sakarikos
 */
@Local
public interface usersDaoLocal {
    void addUsers(Users users);
    
    Users getUsers(int userId);

    List<Users> getAllUsers();

    int getAllLazy();

    List<Users> search();
    
    Object searchSingle();
}
