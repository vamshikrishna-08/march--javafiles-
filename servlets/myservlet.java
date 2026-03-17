package pratice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myservlet extends HttpServlet {

		protected void doGet (HttpServletRequest request , HttpServletResponse response) throws IOException{
			
         PrintWriter out = response.getWriter();
          out.print("hi ");
          
          ServletConfig cg = getServletConfig();
          String str = cg.getInitParameter("name");
          
          
          
          
//          ServletContext ctx  = getServletContext();
//          String str = ctx.getInitParameter("name");
          
          out.println(str);
		
	}
}
