package com.codinghive.ticketMonster.jee.injection01;


import com.codinghive.ticketMonster.jee.dao.StudentDaoLocal;
import com.codinghive.ticketMonster.jee.model.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PlaygroundServlet", urlPatterns = {"/PlaygroundServlet"})
public class PlaygroundServlet extends HttpServlet {

    @Inject
    private StudentDaoLocal studentDao;
    
    Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException, ParseException {
    	
        String action = request.getParameter("action");

        if ("GETALL".equalsIgnoreCase(action)) {
            request.setAttribute("result", gson.toJson(studentDao.getAllStudents()));
        }
        
        if ("GETALL_LAZY".equalsIgnoreCase(action)) {
            request.setAttribute("result", studentDao.getAllLazy());
        }
        
        if ("SEARCH".equalsIgnoreCase(action)) {
            request.setAttribute("result", gson.toJson(studentDao.search()));
        }
        
        if ("SEARCH_SINGLE".equalsIgnoreCase(action)) {
            request.setAttribute("result", gson.toJson(studentDao.searchSingle()));
        }

        request.getRequestDispatcher("playground.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException(e);
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
