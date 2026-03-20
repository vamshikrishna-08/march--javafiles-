package com.inventory;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.inventory.ProductDAO;

@SuppressWarnings({ "serial", "unused" })
public class DisplayProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("productList", ProductDAO.getAllProducts());
        RequestDispatcher rd = request.getRequestDispatcher("displayProducts.jsp");
        rd.forward(request, response);
    }
}
	
