import java.sql.*;  // Import all JDBC classes (Connection, Statement, etc.)

// Define the main class
public class Jdbc_Demo {

    public static void main(String[] args) {
        Connection con = null;      // Used to establish a connection with the database
        Statement st = null;        // Used to execute SQL statements

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/college";  // JDBC URL of the MySQL database
        String user = "root";        // MySQL username
        String password = "tiger";   // MySQL password

        try {
            // Step 1: Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded and registered successfully.");

            // Step 2: Establish a connection to the database
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to the database established.");

            // Step 3: Create a Statement object to send SQL queries
            st = con.createStatement();
            System.out.println("Statement (platform) created to execute SQL queries.");

        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions related to class loading and SQL
            e.printStackTrace();
        }
    }
}
