package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<h2>Servlet Started</h2>");
    
	String username = request.getParameter("username");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	try {
		Connection con = DBConnection.getConnection();
	    if(con == null) {
	    	out.println("Dtabase Conection Fialed!");
	    	return ;
	    }
		String sql = "INSERT INTO users(username, email, password) VALUES (?,?,?)";	
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, username);
	ps.setString(2, email);
    ps.setString(3, password);
    int result = ps.executeUpdate();
    if( result > 0) {
    	out.println("Registration Sucess");
    	response.sendRedirect("login.jsp");
    }else {
    	out.println("Insert Fialed!");
    }
	}catch(Exception e) {
		e.printStackTrace();
		out.println("ERROR : " + e.getMessage());
	}
	}
}
