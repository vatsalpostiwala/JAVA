package E24;

import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookIssueTracker extends JFrame {
    JTextField bookIdField, studentNameField, issueDateField, returnDateField;
    JButton insertButton, viewButton;
    JTable table;
    DefaultTableModel tableModel;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public BookIssueTracker() {
        setTitle("Book Issue Tracking System");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel(" Book ID:"));
        bookIdField = new JTextField();
        inputPanel.add(bookIdField);

        inputPanel.add(new JLabel(" Student Name:"));
        studentNameField = new JTextField();
        inputPanel.add(studentNameField);

        inputPanel.add(new JLabel(" Issue Date (DD-MM-YYYY):"));
        issueDateField = new JTextField();
        inputPanel.add(issueDateField);

        inputPanel.add(new JLabel(" Return Date (DD-MM-YYYY):"));
        returnDateField = new JTextField();
        inputPanel.add(returnDateField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        insertButton = new JButton("Issue Book");
        viewButton = new JButton("View Records");
        buttonPanel.add(insertButton);
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new String[]{"Book ID", "Student Name", "Issue Date", "Return Date"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        connect();

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String bookId = bookIdField.getText();
                    String studentName = studentNameField.getText();
                    String issueDate = issueDateField.getText();
                    String returnDate = returnDateField.getText();

                    pst = con.prepareStatement("INSERT INTO book_issues(book_id, student_name, issue_date, return_date) VALUES(?,?,?,?)");
                    pst.setInt(1, Integer.parseInt(bookId));
                    pst.setString(2, studentName);
                    pst.setString(3, issueDate);
                    pst.setString(4, returnDate);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book Issued Successfully!");
                    
                    bookIdField.setText("");
                    studentNameField.setText("");
                    issueDateField.setText("");
                    returnDateField.setText("");
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("SELECT * FROM book_issues");
                    rs = pst.executeQuery();
                    
                    tableModel.setRowCount(0);
                    
                    while (rs.next()) {
                        Object[] rowData = new Object[4];
                        rowData[0] = rs.getString("book_id");
                        rowData[1] = rs.getString("student_name");
                        rowData[2] = rs.getString("issue_date");
                        rowData[3] = rs.getString("return_date");
                        tableModel.addRow(rowData);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sit_java", "root", "12345");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookIssueTracker().setVisible(true);
            }
        });
    }
}