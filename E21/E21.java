package E21;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class E21 {

    static final String DB_URL = "jdbc:mysql://localhost:3306/sit_java";
    static final String USER = "root";
    static final String PASS = "12345";

    public static void main(String[] args) {
        Connection conn = null;

        try {


            System.out.println("Attempting to connect to sit_java database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            if (conn != null) {
                System.out.println("Success! The database connection was established.");
            }
            
        } catch(SQLException se) {
            System.out.println("Connection failed!");
            se.printStackTrace();
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                    System.out.println("Connection closed.");
                }
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }
}