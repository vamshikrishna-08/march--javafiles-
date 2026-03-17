package pratice;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class ADD extends HttpServlet {

     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
     
     {
    	 int i = Integer.parseInt(req.getParameter("num1"));
    	 int j = Integer.parseInt(req.getParameter("num2"));
    	 
    	 int k = i+j;
    	 
    	 PrintWriter out = res.getWriter();
    	 out.println("<html><body bgcolor = 'cyan'>");
    	 out.println("output is :"+ k);
    	 out.println("</body></html>");
    	 
    
//    	 Cookie cookie = new Cookie("k", k + "");
//    	 res.addCookie(cookie);
//    	 res.sendRedirect("sq");
    	 
    	 
//    	 HttpSession session = req.getSession();
//    	 session.setAttribute("k",k);
//    	 res.sendRedirect("sq");
    	 
    	 
//    	 res.sendRedirect("sq?k="+k);
    	 
    	 
//    	req.setAttribute("k", k);
//    	RequestDispatcher rd = req.getRequestDispatcher("sq");
//    	rd.forward(req, res);
//    
    	 
//    	 PrintWriter  out = res.getWriter();   //adding two numbers
//    	 out.println("result is : " + k);
     }   	     
}