import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class App {
    static final String APP_URL = "jdbc:mysql://localhost:3306/mysql";
    static final String USER = "root";
    static final String PASS = "Vamshi@123";
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(APP_URL,USER,PASS);
        Statement stmt = conn.createStatement())
        {
          String sql = "CREATE DATABASE ADA ";
          stmt.executeUpdate(sql);
          System.out.println("DATABASE created successfully");
        } catch (SQLException e)
        {
            System.err.println("Database error :  " + e.getMessage());
        }
    }
}
