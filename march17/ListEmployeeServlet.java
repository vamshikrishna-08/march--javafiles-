package com.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.employee.EmployeeDAO;
import com.employee.Employee;

@SuppressWarnings({ "serial", "unused" })
public class ListEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployeeDAO dao = new EmployeeDAO();

        List<Employee> list = dao.getAllEmployees();

        request.setAttribute("employeeList", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListEmployee.jsp");

        dispatcher.forward(request, response);
    }
}