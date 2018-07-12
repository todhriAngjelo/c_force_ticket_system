/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.servlet;

import com.codinghive.ticketMonster.jee.dao.TicketDao;
import com.codinghive.ticketMonster.jee.model.Ticket;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

@WebServlet(name = "TicketServlet", urlPatterns = {"/TicketServlet"})

public class TicketServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Inject
    private TicketDao ticketDao;
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TicketServlet.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {

        //action
        String action = request.getParameter("action"); 
        
        //ticked Id 
        String t_idStr = request.getParameter("t_id"); 
        int t_id = 0;
        if (t_idStr != null && !t_idStr.equals("")) {
            t_id = Integer.parseInt(t_idStr);           
        }
        
        
        //ticket Title
        String t_title = request.getParameter("t_title");       
          
        //ticket Price
        String t_priceStr = request.getParameter("t_price");       
        double t_price = 0;
        if (t_priceStr != null && !t_priceStr.equals("")) {
            t_price = Double.parseDouble(t_priceStr);          
        }
        
        //user Id
        String user_IdStr = request.getParameter("user_Id");    //dexete dedomena  
        int user_Id = 0;                                        //dexete dedomena  
        if (user_IdStr != null && !user_IdStr.equals("")) {     //dexete dedomena  
            user_Id = Integer.parseInt(user_IdStr);
        }

        //ticket Booked
        String t_bookedStr = request.getParameter("t_booked");    //dexete dedomena  
        int t_booked = 0;                                        //dexete dedomena  
        if (t_bookedStr != null && !t_bookedStr.equals("")) {     //dexete dedomena  
            t_booked = Integer.parseInt(t_bookedStr);
        }
        String t_overview=null, t_rating=null, t_urlString =null;
        Ticket ticket = new Ticket(t_title, t_price, user_Id, t_booked, t_overview, t_rating, t_urlString); //pernaei stoixeia se ena Ticket object

        if ("Add".equalsIgnoreCase(action)) { // an epilexthei ADD sti forma
            ticketDao.addTicket(ticket);         // kalei tin addTicket sto TicketDao.java
            request.setAttribute("ticket", ticket);
            request.setAttribute("allTicket", ticketDao.getAllTicketList());
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if ("Show".equalsIgnoreCase(action)) {// an epilexthei Show sti forma
            request.setAttribute("ticket", ticket);
            request.setAttribute("allTicket", ticketDao.getAllTicketList());
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } else if ("Search".equalsIgnoreCase(action)) {// an epilexthei Search sti forma

            // auto fill ticket form with the searchedId ticket info
            request.setAttribute("ticket", ticketDao.getTicketById(t_id));
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TicketServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TicketServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(TicketServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(TicketServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
