package com.model;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.BookDao;
import com.model.Book;

@SuppressWarnings({ "serial", "unused" })
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            Book b = new Book();
            b.setTitle(req.getParameter("title"));
            b.setAuthor(req.getParameter("author"));
            b.setCategory(req.getParameter("category"));
            b.setQuantity(Integer.parseInt(req.getParameter("quantity")));

            new BookDao().add(b);
            res.sendRedirect("view");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
