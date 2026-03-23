package com.model;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.BookDao;

@SuppressWarnings({ "serial", "unused" })
public class ViewBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            req.setAttribute("list", new BookDao().getAll());
            req.getRequestDispatcher("viewBooks.jsp").forward(req, res);
        } catch (Exception e) { e.printStackTrace(); }
    }
}