package pratice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/praticee")
public class praticee extends HttpServlet {

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
     
     {
                   String name = "vamshi";
                   
                   request.setAttribute("label",name);
                   RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
                   rd.forward(request , response);
     }
}