package E21;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentDatabaseConnection {
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        Connection conn = null;

        try {

            System.out.println("Checking connection status...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            if (conn != null) {
                System.out.println("Connection Status: ACTIVE");
                // Custom message required by the exercise
                System.out.println("Student database is connected successfully.");
            }
            
        } catch(SQLException se) {
            System.out.println("Connection Status: INACTIVE (Failed to connect)");
            se.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
