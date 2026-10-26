package E22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E22 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sit_java";
        String username = "root";
        String password = "12345"; 

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            
            String insertQuery = "INSERT INTO students (id, name) VALUES (?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setInt(1, 101);
                insertStmt.setString(2, "Aarav");
                insertStmt.executeUpdate();
            }

            String selectQuery = "SELECT id, name FROM students WHERE id = ?";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                selectStmt.setInt(1, 101);
                
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    while (resultSet.next()) {
                        int studentId = resultSet.getInt("id");
                        String studentName = resultSet.getString("name");
                        
                        System.out.println(studentId + " - " + studentName);
                    }
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}