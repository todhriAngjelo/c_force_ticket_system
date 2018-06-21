/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinghive.ticketMonster.jee.injection01;

import com.codinghive.ticketMonster.jee.dao.TicketDaoLocal;
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
    private TicketDaoLocal ticketDao;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException, ParseException {
        
        String action = request.getParameter("action");
        String ticketIdStr = request.getParameter("ticketId");
        int ticketId = 0;
        if (ticketIdStr != null && !ticketIdStr.equals("")) {
            ticketId = Integer.parseInt(ticketIdStr);
        }
        String t_title = request.getParameter("t_title");
        String t_price = request.getParameter("t_price");
        
        String user_IdStr = request.getParameter("user_Id");
        int user_Id = 0;
        if (user_IdStr != null && !user_IdStr.equals("")) {
            user_Id = Integer.parseInt(user_IdStr);
        }
        
        Ticket ticket = new Ticket(ticketId, t_title, t_price, user_Id);
        
        if ("Add".equalsIgnoreCase(action)) {
           ticketDao.addTicket(ticket);
        }
        
         request.setAttribute("ticket", ticket);
        request.setAttribute("allTicket", ticketDao.getAllTicket());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    
    
    
    
    
   
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
