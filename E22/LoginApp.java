package E22;

import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sit_java";
        String dbUser = "root";
        String dbPassword = "12345";

        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {

            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Login Successful! Welcome, " + username + ".");
                    } else {
                        System.out.println("Login Failed! Invalid username or password.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}