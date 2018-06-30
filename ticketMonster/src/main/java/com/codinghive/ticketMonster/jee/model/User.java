package com.codinghive.ticketMonster.jee.model;

import java.util.ArrayList;

public class User {

    private String u_Name;
    private int u_Id;
    private String u_Password;
    private boolean u_Admin;
    private ArrayList<Ticket> u_Tickets;

    public User(String u_Name, int u_Id, String u_Password, boolean u_Admin, ArrayList<Ticket> u_Tickets) {
        this.u_Name = u_Name;
        this.u_Id = u_Id;
        this.u_Password = u_Password;
        this.u_Admin = u_Admin;
        this.u_Tickets = u_Tickets;
    }

    //
    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    //
    public int getU_id() {
        return u_Id;
    }

    public void setU_id(int u_id) {
        this.u_Id = u_id;
    }

    //
    public String getU_Password() {
        return u_Password;
    }

    public void setU_Password(String u_Password) {
        this.u_Password = u_Password;
    }

    //
    public boolean isU_Admin() {
        return u_Admin;
    }

    public void setU_Admin(boolean u_Admin) {
        this.u_Admin = u_Admin;
    }

    public void addTicketToArray(Ticket ticket) {
        u_Tickets.add(ticket);
    }
}
