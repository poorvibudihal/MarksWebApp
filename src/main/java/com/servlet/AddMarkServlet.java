package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.MarkDAO;
import com.model.StudentMark;
import java.sql.Date;

@WebServlet("/add")  
public class AddMarkServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			    response.getWriter().println("Use POST method to add data");
			}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        StudentMark s = new StudentMark();

        s.setStudentID(Integer.parseInt(request.getParameter("id")));
        s.setStudentName(request.getParameter("name"));
        s.setSubject(request.getParameter("subject"));
        s.setMarks(Integer.parseInt(request.getParameter("marks")));
        s.setExamDate(Date.valueOf(request.getParameter("date")));

        MarkDAO dao = new MarkDAO();
        dao.addMark(s);

        response.sendRedirect("view");
    }
}