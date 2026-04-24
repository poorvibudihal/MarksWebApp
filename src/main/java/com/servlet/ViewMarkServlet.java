package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;   // ✅ IMPORT THIS
import java.util.*;
import com.dao.MarkDAO;
import com.model.StudentMark;

@WebServlet("/view")   // ✅ ADD HERE (above class)
public class ViewMarkServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        MarkDAO dao = new MarkDAO();
        List<StudentMark> list = dao.getAllMarks();

        request.setAttribute("data", list);
        RequestDispatcher rd = request.getRequestDispatcher("markdisplay.jsp");
        rd.forward(request, response);
    }
}