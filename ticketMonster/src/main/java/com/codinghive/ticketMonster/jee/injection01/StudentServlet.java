package com.codinghive.ticketMonster.jee.injection01;


import com.codinghive.ticketMonster.jee.dao.StudentDaoLocal;
import com.codinghive.ticketMonster.jee.model.Student;

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

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @Inject
    private StudentDaoLocal studentDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException, ParseException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId = 0;
        if (studentIdStr != null && !studentIdStr.equals("")) {
            studentId = Integer.parseInt(studentIdStr);
        }
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String yearLevelStr = request.getParameter("yearLevel");
        String startDateStr = request.getParameter("startDate");
        String gradeStr = request.getParameter("grade");

        int yearLevel = 0;
        if (yearLevelStr != null && !yearLevelStr.equals("")) {
            yearLevel = Integer.parseInt(yearLevelStr);
        }
        BigDecimal grade = null;
        if (gradeStr != null && !gradeStr.equals("")) {
        	grade = new BigDecimal(gradeStr);
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
        Date convertedDate = null;
        if (startDateStr != null && !startDateStr.equals("")) {
        	convertedDate = dateFormat.parse(startDateStr); 
        }

        Student student = new Student(studentId, firstname, lastname, yearLevel, grade, convertedDate);

        if ("Add".equalsIgnoreCase(action)) {
            studentDao.addStudent(student);
        }
        else if ("Edit".equalsIgnoreCase(action)) {
            studentDao.editStudent(student);
        }
        else if ("Delete".equalsIgnoreCase(action)) {
            studentDao.deleteStudent(studentId);
        }
        else if ("Search".equalsIgnoreCase(action)) {
            student = studentDao.getStudent(studentId);
        }

        request.setAttribute("student", student);
        request.setAttribute("allStudents", studentDao.getAllStudents());
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
