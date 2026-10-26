package E21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionStatus {
    static final String DB_URL = "jdbc:mysql://localhost:3306/sit_java";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            
            System.out.println("Status: Attempting to establish database connection...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            if (conn != null) {
                System.out.println("Status: Connection Established Successfully!");
            }
            
        } catch(SQLException se) {
            System.out.println("Status: Connection Failed!");
            se.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                    System.out.println("Status: Connection Closed.");
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
