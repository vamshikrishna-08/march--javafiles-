package com.employee;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.employee.EmployeeDAO;
import com.employee.Employee;

@SuppressWarnings({ "unused", "serial" })
public class AddEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee emp = new Employee();

        emp.setEmp_name(name);
        emp.setDepartment(department);
        emp.setSalary(salary);

        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);

        response.sendRedirect("ListEmployeeServlet");
    }
}


