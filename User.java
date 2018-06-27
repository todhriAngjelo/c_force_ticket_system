/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nikos_Geo
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_Id;
    private String user_Name;
    protected int [] user_Tickets;
    private String user_Email;
    private String user_Password;
    private boolean user_Admin;

    public User(Long user_Id, String user_Name, int[] user_Tickets, String user_Email, String user_Password, boolean user_Admin) {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.user_Tickets = user_Tickets;
        this.user_Email = user_Email;
        this.user_Password = user_Password;
        this.user_Admin = user_Admin;
    }

    public Long getUser_Id() {
        return user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public int[] getUser_Tickets() {
        return user_Tickets;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public String getUser_Password() {
        return user_Password;
    }

    public boolean isUser_Admin() {
        return user_Admin;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public void setUser_Tickets(int[] user_Tickets) {
        this.user_Tickets = user_Tickets;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public void setUser_Admin(boolean user_Admin) {
        this.user_Admin = user_Admin;
    }

   

    /*@Override
    public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
    }*/

    /* @Override
    public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof User)) {
    return false;
    }
    User other = (User) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
    return false;
    }
    return true;
    }*/

    @Override
    public String toString() {
        return "User.User[ id=" + user_Id + " ]";
    }
    // String Representation:
    
}
