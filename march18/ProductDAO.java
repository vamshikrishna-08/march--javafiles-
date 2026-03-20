package com.inventory;

import java.sql.*;
import java.util.*;

public class ProductDAO {
    private static int executeUpdate(String sql, Object... params) {
        int status = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static int insertProduct(Product p) {
        return executeUpdate(
            "INSERT INTO products(product_name, price, quantity, category) VALUES(?,?,?,?)",
            p.getName(), p.getPrice(), p.getQuantity(), p.getCategory()
        );
    }
    public static int updateProduct(Product p) {
        return executeUpdate(
            "UPDATE products SET product_name=?, price=?, quantity=?, category=? WHERE product_id=?",
            p.getName(), p.getPrice(), p.getQuantity(), p.getCategory(), p.getId()
        );
    }
    public static int deleteProduct(int id) {
        return executeUpdate(
            "DELETE FROM products WHERE product_id=?",
            id
        );
    }
    public static List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM products");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategory(rs.getString("category"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Product getProductById(int id) {
        Product p = null;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE product_id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Product();
                p.setId(rs.getInt("product_id"));
                p.setName(rs.getString("product_name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setCategory(rs.getString("category"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}