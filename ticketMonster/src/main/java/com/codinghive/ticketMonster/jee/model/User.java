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
@NamedQuery(name = "User.getAll", query = "SELECT e FROM User e")})
public class User implements Serializable {

    
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int u_Id;  
    @Column
    private String u_Name;
    @Column
    private String u_Pw;
    @Column
    private String u_Fname;
    @Column
    private boolean u_Admin;
    
//    //implementation of hashmap in order to be able to find the ticket or remove the ticket
//    @OneToMany(fetch = EAGER, cascade = ALL)
//    @JoinColumn
//    private HashMap<Integer,Ticket> listOfTickets;
//


    //GETTERS START HERE
    public String getU_Name() {
        return u_Name;
    }
    
    public int getU_Id() {
        return u_Id;
    }
    
    public String getU_Pw() {
        return u_Pw;
    }

    private String getU_Fname(){
        return u_Fname;
    }
    
    public boolean getU_Admin() {
       return u_Admin;
    }
    //GETTERS END HERE

    
    //SETTERS START HERE
    public void setU_Id(int u_Id) {
        this.u_Id = u_Id;
    }
    
    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public void setU_Pw(String u_Pw) {
        this.u_Pw = u_Pw;
    }
     
    public void setU_Fname(String u_Fname) {
        this.u_Fname = u_Fname;
    }
    
    public void setU_Admin(boolean u_Admin) {
        this.u_Admin = u_Admin;
    }
    //SETTERS END HERE

    

//    
//    //insertion of Ticket object into the User's listOfTickets with Key u_Id ( HashMap - listOfTickets )
//    public void addTicketToArray(Integer u_Id, Ticket ticket) {
//        listOfTickets.put(u_Id, ticket);
//    }
//    
//    //returning ticket with u_Id from User's listOfTickets and returning the Ticket Object
//    public Ticket removeTicketFromArray(Integer u_Id, Ticket ticket) {
//        return listOfTickets.remove(u_Id);
//    }
//    
    
    public User(String u_Name, String u_Pw, String u_Fname) {
        this.u_Name = u_Name;
        this.u_Pw = u_Pw;
        this.u_Fname = u_Fname;
//        this.u_Email = u_Email;
    }
    
    public User() {
    }
    
    
    @Override
    public String toString() {
        return "User{ " + "u_Id = " + u_Id + ", u_name = " + u_Name + ", u_Fname = " + u_Fname + '}';
    }


}


