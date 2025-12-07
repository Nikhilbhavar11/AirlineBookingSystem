import java.sql.*;

public class New {

    public static void main(String[] args) {
        // MySQL connection details
        String url = "jdbc:mysql://localhost:3306/airline_system";
        String user = "root"; // Replace with your MySQL username
        String password = "nikhil11"; // Replace with your MySQL password

        // SQL query
        String query = "SELECT * FROM flights";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Display the results
            System.out.println("Flight Data:");
            System.out.println(" Flight Name       | Source        | Destination");
            System.out.println("--------------------------------------------------------");

            while (rs.next()) {
                String flightName = rs.getString("flight_name");
                String source = rs.getString("source");
                String destination = rs.getString("destination");

                System.out.printf(" %-17s | %-13s | %s%n", flightName, source, destination);
            }

            // Close connections
            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        }
    }
}
