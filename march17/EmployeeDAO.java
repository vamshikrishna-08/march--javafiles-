package com.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.employee.Employee;
import com.employee.DBConnection;

@SuppressWarnings("unused")
public class EmployeeDAO {

    Connection con = DBConnection.getConnection();

    public void addEmployee(Employee emp) {

        try {

            String query = "INSERT INTO employees(emp_name,department,salary) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, emp.getEmp_name());
            ps.setString(2, emp.getDepartment());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {

        List<Employee> list = new ArrayList<>();

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while (rs.next()) {

                Employee emp = new Employee();

                emp.setEmp_id(rs.getInt("emp_id"));
                emp.setEmp_name(rs.getString("emp_name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void deleteEmployee(int id) {

        try {

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM employees WHERE emp_id=?");

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}