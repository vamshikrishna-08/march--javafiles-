package com.model;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;

@SuppressWarnings({ "unused", "serial" })
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            Book b = new Book();
            b.setBook_id(Integer.parseInt(req.getParameter("id")));
            b.setTitle(req.getParameter("title"));
            b.setAuthor(req.getParameter("author"));
            b.setCategory(req.getParameter("category"));
            b.setQuantity(Integer.parseInt(req.getParameter("quantity")));

            new BookDao().update(b);
            res.sendRedirect("view");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
