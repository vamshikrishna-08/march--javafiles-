package com.inventory;


import java.io.IOException;
import javax.servlet.http.*;
import com.inventory.ProductDAO;

@SuppressWarnings({ "serial", "unused" })
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO.deleteProduct(id);

        response.sendRedirect("displayProducts");
    }
}
