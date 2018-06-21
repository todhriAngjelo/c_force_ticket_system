/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.model;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Users.getAll", query = "SELECT e FROM Users e") })
/**
 *
 * @author Alkis_Sakarikos
 */
public class Users implements Serializable {
    
    
	@Id
    @Column
    private int userId;

  

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
    
    public Users(int userId) {
        this.userId = userId;
    }
    
    public Users() {
    }
    
     @Override
    public String toString() {
        return "Users{" + "userId=" + userId + '}';
    }
}
