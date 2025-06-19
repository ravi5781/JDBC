import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _2_Jdbc_update {
    public static void main(String[] args) {
        // Step 1: Declare JDBC objects
        Connection con = null;    // Used to connect to the database
        Statement st = null;      // Used to execute SQL statements

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/college"; // JDBC URL for the 'college' database
        String user = "root";       // MySQL username
        String password = "tiger";  // MySQL password

        // SQL UPDATE query to modify the email of the student with id = 1
        String update = "UPDATE student SET mail='ravikiran018@gmail.com' WHERE id=1";

        try {
            // Step 2: Load and register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Step 3: Establish the database connection
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");

            // Step 4: Create a Statement object for sending SQL queries
            st = con.createStatement();
            System.out.println("Statement (SQL platform) created.");

            // Step 5: Execute the UPDATE query
            int res = st.executeUpdate(update); // Returns the number of affected rows
            System.out.println("Update completed. Rows affected: " + res);

        } catch (ClassNotFoundException | SQLException e) {
            // Step 6: Handle exceptions related to JDBC driver or SQL
            e.printStackTrace();
        } finally {
            // Step 7: Clean up resources
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("Resources closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
