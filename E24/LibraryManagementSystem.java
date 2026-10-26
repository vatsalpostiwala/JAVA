package E24;

import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LibraryManagementSystem extends JFrame {
    JTextField bookIdField, titleField, authorField, categoryField;
    JButton addButton, viewButton;
    JTable table;
    DefaultTableModel tableModel;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel(" Book ID:"));
        bookIdField = new JTextField();
        inputPanel.add(bookIdField);

        inputPanel.add(new JLabel(" Book Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel(" Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel(" Category:"));
        categoryField = new JTextField();
        inputPanel.add(categoryField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Book");
        viewButton = new JButton("View Books");
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new String[]{"Book ID", "Title", "Author", "Category"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        connect();

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String bookId = bookIdField.getText();
                    String title = titleField.getText();
                    String author = authorField.getText();
                    String category = categoryField.getText();

                    pst = con.prepareStatement("INSERT INTO library_books(book_id, title, author, category) VALUES(?,?,?,?)");
                    pst.setInt(1, Integer.parseInt(bookId));
                    pst.setString(2, title);
                    pst.setString(3, author);
                    pst.setString(4, category);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Book Added Successfully!");
                    
                    bookIdField.setText("");
                    titleField.setText("");
                    authorField.setText("");
                    categoryField.setText("");
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("SELECT * FROM library_books");
                    rs = pst.executeQuery();
                    
                    tableModel.setRowCount(0);
                    
                    while (rs.next()) {
                        Object[] rowData = new Object[4];
                        rowData[0] = rs.getString("book_id");
                        rowData[1] = rs.getString("title");
                        rowData[2] = rs.getString("author");
                        rowData[3] = rs.getString("category");
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
                new LibraryManagementSystem().setVisible(true);
            }
        });
    }
}