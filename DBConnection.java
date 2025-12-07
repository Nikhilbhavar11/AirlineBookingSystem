import java.sql.*;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        try {
            // Correct URL with timezone and SSL disabled
            String url = "jdbc:mysql://localhost:3306/airline_system?useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "nikhil11";

            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Try connecting
            return DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            throw new SQLException("Driver not found.");
        } catch (SQLException e) {
            System.out.println("Database connection error!");
            e.printStackTrace();
            throw e;
        }
    }
}

