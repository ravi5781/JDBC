import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_delete {

    public static void main(String[] args) {
        // Step 1: Declare JDBC variables
        Connection con = null;   // For establishing connection to database
        Statement st = null;     // For executing SQL queries

        // Step 2: Define database connection details
        String url = "jdbc:mysql://localhost:3306/college"; // Database name: college
        String user = "root";         // Database username
        String password = "tiger";    // Database password

        // Step 3: SQL query to delete a student record where id = 5
        String delete = "DELETE FROM student WHERE id = 5";

        try {
            // Step 4: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Step 5: Establish connection to the database
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");

            // Step 6: Create a statement object
            st = con.createStatement();

            // Step 7: Execute the DELETE query
            int res = st.executeUpdate(delete); // Returns number of rows affected

            // Step 8: Check result and provide feedback
            if (res > 0) {
                System.out.println("Data deleted successfully.");
                System.out.println("Rows affected: " + res);
            } else {
                System.out.println("No matching record found. Deletion unsuccessful.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            // Step 9: Handle any exceptions
            e.printStackTrace();
        } finally {
            // Step 10: Close resources to avoid memory leaks
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
