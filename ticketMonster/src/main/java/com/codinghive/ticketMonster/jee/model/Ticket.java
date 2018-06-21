/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Ticket.getAll", query = "SELECT e FROM Ticket e") })
public class Ticket implements Serializable {
    
    
	@Id
    @Column
    private int ticketId;
        
    @Column
    private String t_title;
        
    @Column
    private String t_price;
        
    @Column
    private int user_Id; 
    
    
    

  
    //    Getters ------------------------

    public int getTicketId() {
        return ticketId;
    }

    public String getT_title() {
        return t_title;
    }

    public String getT_price() {
        return t_price;
    }

    public int getUser_Id() {
        return user_Id;
    }
    
   //    END Getters ------------------------

    
    
   //    Setters ------------------------
    
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public void setT_price(String t_price) {
        this.t_price = t_price;
    }


    public void setUser_Id(int user_Id) {    
        this.user_Id = user_Id;
    }

//   END  Setters ------------------------


//   Constructor ------------------------

    public Ticket(int ticketId, String t_title, String t_price, int user_Id) {
        this.ticketId = ticketId;
        this.t_title = t_title;
        this.t_price = t_price;
        this.user_Id = user_Id;
    }
    
    //Ticket t = new Ticket(1,"asfafas","21",1);
    
    public Ticket() {
    }
    
//   END  Constructor ------------------------
    
    

    @Override
    public String toString() {
        return "Users{" + "ticketId=" + ticketId + ", t_title='" + t_title + '\'' + ", t_price='" + t_price + '\''
                + ", yearLevel=" + user_Id + '}';
    }
    
}
