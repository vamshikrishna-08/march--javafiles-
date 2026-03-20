package com.inventory;

import java.io.IOException;
import javax.servlet.http.*;
import com.inventory.ProductDAO;
import com.inventory.Product;

@SuppressWarnings({ "serial", "unused" })
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Product p = new Product();
        p.setId(Integer.parseInt(request.getParameter("id")));
        p.setName(request.getParameter("name"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        p.setCategory(request.getParameter("category"));

        ProductDAO.updateProduct(p);
        response.sendRedirect("displayProducts");
    }
}