import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _1_Jdbc_Insert {
    public static void main(String[] args) {
        // JDBC Step 1: Declare required JDBC objects
        Connection con = null;   // To manage DB connection
        Statement st = null;     // To execute SQL statements

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/college"; // college is the database name
        String user = "root";       // MySQL username
        String password = "tiger";  // MySQL password

        // SQL INSERT statements to insert student records
        String query = "INSERT INTO student VALUES(0, 'RAVIKIRAN', 9019225781, 'ravikiransh@gmail.com', 'CSE', 'SHAHAPUR', '1234', SYSDATE())";
        String query1 = "INSERT INTO student VALUES(0, 'KIRAN', 9972219494, 'kiransh@gmail.com', 'CSE', 'HASSAN', '1234', SYSDATE())";
        String query3 = "INSERT INTO student VALUES(0, 'Neha', 9972219413, 'neha@gmail.com', 'CSE', 'Vijayanagr', '1334', SYSDATE())";

        try {
            // Step 1: Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // Step 2: Establish connection to the database
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to database established successfully.");

            // Step 3: Create a statement object for executing SQL queries
            st = con.createStatement();
            System.out.println("Statement (SQL execution platform) created.");

            // Step 4: Execute SQL insert query
            // You can execute one at a time, or use batch processing (for multiple inserts)
            int res = st.executeUpdate(query3);  // Change to query or query1 as needed
            System.out.println("Record inserted successfully. Rows affected: " + res);

        } catch (ClassNotFoundException | SQLException e) {
            // Step 5: Handle any exceptions related to class loading or SQL operations
            e.printStackTrace();
        } finally {
            // Step 6: Clean up and close resources (good practice)
            try {
                if (st != null) st.close();
                if (con != null) con.close();
                System.out.println("Resources released and connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
