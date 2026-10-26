package E22;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalLoginApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sit_java";
        String dbUser = "root";
        String dbPassword = "12345";

        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {

            System.out.print("Enter Staff Login ID: ");
            String loginId = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            String query = "SELECT role FROM hospital_staff WHERE login_id = ? AND password = ?";
            
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, loginId);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        String role = rs.getString("role");
                        System.out.println("Authentication Successful.");
                        System.out.println("Access Granted: Welcome, " + role + ". You have been securely logged into the hospital portal.");
                    } else {
                        System.out.println("Authentication Failed: Invalid Login ID or password. Access Denied.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}