package com.employee;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.employee.EmployeeDAO;

@SuppressWarnings({ "serial", "unused" })
public class DeleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployee(id);

        response.sendRedirect("ListEmployeeServlet");
    }
}