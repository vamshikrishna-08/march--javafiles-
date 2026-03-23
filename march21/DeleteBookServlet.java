package com.model;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.BookDao;

@SuppressWarnings({ "serial", "unused" })
public class DeleteBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            new BookDao().delete(id);
            res.sendRedirect("view");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
