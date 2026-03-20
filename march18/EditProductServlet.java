package com.inventory;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.inventory.ProductDAO;

@SuppressWarnings({ "serial", "unused" })
public class EditProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", ProductDAO.getProductById(id));

        RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
        rd.forward(request, response);
    }
}
