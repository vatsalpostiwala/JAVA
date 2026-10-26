package E23;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetNavigation {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sit_java", "root", "12345");
            
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            if (rs.first()) {
                System.out.println("First Record: " + rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3));
            }

            if (rs.last()) {
                System.out.println("Last Record: " + rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3));
            }

            if (rs.previous()) {
                System.out.println("Previous from Last: " + rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3));
            }

            if (rs.absolute(2)) {
                System.out.println("Absolute 2nd Record: " + rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getDouble(3));
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}