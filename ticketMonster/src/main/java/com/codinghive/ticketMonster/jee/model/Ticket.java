package com.codinghive.ticketMonster.jee.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "Ticket.getAll", query = "SELECT e FROM Ticket e")})
public class Ticket implements Serializable {

    // Create Columns
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int t_id;

    @Column
    private String t_title;

    @Column
    private double t_price;

    @Column
    private int user_Id;

    @Column
    private int t_booked;

    //    Getters ------------------------
    public int getT_id() {
        return t_id;
    }

    public String getT_title() {
        return t_title;
    }

    public double getT_price() {
        return t_price;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public int getT_booked() {
        return t_booked;
    }
    //    END Getters ------------------------

    //    Setters ------------------------  
    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public void setT_price(double t_price) {
        this.t_price = t_price;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public void setT_booked(int t_booked) {
        this.t_booked = t_booked;
    }
//   END  Setters ------------------------

//   Constructors ------------------------
    public Ticket(int t_booked) {
        this.t_booked = t_booked;
    }

    public Ticket(String t_title, double t_price, int user_Id, int t_booked) {
        this.t_title = t_title;
        this.t_price = t_price;
        this.user_Id = user_Id;
        this.t_booked = t_booked;
    }

    public Ticket() {
    }

//   END  Constructor ------------------------
    @Override
    public String toString() {
        return "Users{" + "t_id=" + t_id + ", t_title='" + t_title + '\'' + ", t_price='" + t_price + '\''
                + ", user_Id=" + user_Id + ", t_booked=" + t_booked + '}';
    }

}
