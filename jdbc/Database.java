import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Database {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "Vamshi@123";

        try (
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement()){
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS collegeDB");
            System.out.println("Database created successfully!");
            stmt.executeUpdate("USE collegeDB");
            String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "course VARCHAR(50))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully!");
            stmt.executeUpdate("INSERT INTO students VALUES (1,'Rahul','BCA')");
            stmt.executeUpdate("INSERT INTO students VALUES (2,'Anjali','BBA')");
            stmt.executeUpdate("INSERT INTO students VALUES (3,'Ravi','BTech')");
            stmt.executeUpdate("INSERT INTO students VALUES (4,'Priya','MCA')");
            stmt.executeUpdate("INSERT INTO students VALUES (5,'Kiran','MBA')");
            System.out.println("Multiple records inserted!");
            con.close();
        } catch (Exception e) {
            System.err.println("Database error : " + e.getMessage());
        }
    }
}