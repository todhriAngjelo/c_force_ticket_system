
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
    private String t_rating;
    
    @Column
    private String t_overview;
    
    @Column
    private String t_urlImage;

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
    
    public String getT_overview() {
        return t_overview;
    }
     
    public String getT_rating() {
        return t_rating;
    }
      
    public String getT_urlImage() {
        return t_urlImage;
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
    public void getT_overview(String t_overview) {
        this.t_overview = t_overview;
    }
     
    public void getT_rating(String t_rating) {
        this.t_rating = t_rating;
    }
      
    public void getT_urlImage(String t_urlImage) {
        this.t_urlImage = t_urlImage;
    }
    
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

    public Ticket(String t_title, double t_price, int user_Id, int t_booked, String t_overview, String t_rating , String t_urlImage) {
        this.t_title = t_title;
        this.t_rating = t_rating;
        this.t_overview = t_overview;
        this.t_urlImage = t_urlImage;
        this.t_price = t_price;
        this.user_Id = user_Id;
        this.t_booked = t_booked;
    }

    public Ticket() {
    }

//   END  Constructor ------------------------
    @Override
    public String toString() {
        return "Ticket {" + "t_id=" + t_id + ", t_title='" + t_title + '\'' + ", t_price='" + t_price + '\''
                + ", user_Id=" + user_Id + ", t_booked=" + t_booked + ", t_rating=" + t_rating + ", t_overview=" + t_overview + ", t_urlImage=" + t_urlImage +'}';
    }

}
