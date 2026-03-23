package com.model;

import java.sql.*;
import java.util.*;
public class BookDao {
    private String url = "jdbc:mysql://localhost:3306/library_db";
    private String user = "root";
    private String pass = "Vamshi@123";
    private Connection getCon() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }
    public void add(Book b) throws Exception {
        Connection c = getCon();
        PreparedStatement ps = c.prepareStatement(
            "INSERT INTO books(title,author,category,quantity) VALUES(?,?,?,?)");
        ps.setString(1, b.getTitle());
        ps.setString(2, b.getAuthor());
        ps.setString(3, b.getCategory());
        ps.setInt(4, b.getQuantity());
        ps.executeUpdate();
        c.close();
    }
    public List<Book> getAll() throws Exception {
        List<Book> list = new ArrayList<>();
        Connection c = getCon();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM books");
        while(rs.next()){
            Book b = new Book();
            b.setBook_id(rs.getInt(1));
            b.setTitle(rs.getString(2));
            b.setAuthor(rs.getString(3));
            b.setCategory(rs.getString(4));
            b.setQuantity(rs.getInt(5));
            list.add(b);
        }
        c.close();
        return list;
    }
    public void delete(int id) throws Exception {
        Connection c = getCon();
        PreparedStatement ps = c.prepareStatement("DELETE FROM books WHERE book_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        c.close();
    }
    public void update(Book b) throws Exception {
        Connection c = getCon();
        PreparedStatement ps = c.prepareStatement(
            "UPDATE books SET title=?,author=?,category=?,quantity=? WHERE book_id=?");
        ps.setString(1, b.getTitle());
        ps.setString(2, b.getAuthor());
        ps.setString(3, b.getCategory());
        ps.setInt(4, b.getQuantity());
        ps.setInt(5, b.getBook_id());
        ps.executeUpdate();
        c.close();
    }
    public List<Book> search(String title) throws Exception {
        List<Book> list = new ArrayList<>();
        Connection c = getCon();
        PreparedStatement ps = c.prepareStatement(
            "SELECT * FROM books WHERE title LIKE ?");
        ps.setString(1, "%" + title + "%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Book b = new Book();
            b.setBook_id(rs.getInt(1));
            b.setTitle(rs.getString(2));
            b.setAuthor(rs.getString(3));
            b.setCategory(rs.getString(4));
            b.setQuantity(rs.getInt(5));
            list.add(b);
        }
        c.close();
        return list;
    }
}