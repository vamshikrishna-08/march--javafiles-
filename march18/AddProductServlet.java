package com.inventory;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Product p = new Product();
        p.setName(request.getParameter("name"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        p.setCategory(request.getParameter("category"));

        ProductDAO.insertProduct(p);
        response.sendRedirect("displayProducts");
    }
}