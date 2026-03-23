package com.model;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.model.*;

@SuppressWarnings({ "serial", "unused" })
public class SearchBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            req.setAttribute("list", new BookDao().search(title));
            req.getRequestDispatcher("viewBooks.jsp").forward(req, res);
        } catch (Exception e) { e.printStackTrace(); }
    }
}
