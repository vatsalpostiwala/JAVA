package E24;

import java.lang.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DatabaseApp extends JFrame {
    JTextField idField, nameField, ageField, gradeField;
    JButton insertButton, viewButton;
    JTable table;
    DefaultTableModel tableModel;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public DatabaseApp() {
        setTitle("Student Database Manager");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        
        inputPanel.add(new JLabel(" ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel(" Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel(" Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel(" Grade:"));
        gradeField = new JTextField();
        inputPanel.add(gradeField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        insertButton = new JButton("Insert Record");
        viewButton = new JButton("View Database");
        buttonPanel.add(insertButton);
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Grade"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.SOUTH);

        connect();

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = idField.getText();
                    String name = nameField.getText();
                    String age = ageField.getText();
                    String grade = gradeField.getText();

                    pst = con.prepareStatement("INSERT INTO students(id, name, age, grade) VALUES(?,?,?,?)");
                    pst.setInt(1, Integer.parseInt(id));
                    pst.setString(2, name);
                    pst.setInt(3, Integer.parseInt(age));
                    pst.setString(4, grade);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Record Added Successfully!");
                    
                    idField.setText("");
                    nameField.setText("");
                    ageField.setText("");
                    gradeField.setText("");
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    pst = con.prepareStatement("SELECT * FROM students");
                    rs = pst.executeQuery();
                    
                    tableModel.setRowCount(0);
                    
                    while (rs.next()) {
                        // Using basic Object array instead of Vector
                        Object[] rowData = new Object[4];
                        rowData[0] = rs.getString("id");
                        rowData[1] = rs.getString("name");
                        rowData[2] = rs.getString("age");
                        rowData[3] = rs.getString("grade");
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
            // Make sure your username and password here are correct
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sit_java", "root", "12345");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Failed: " + ex.getMessage());
        }
    }

    // The main method is correctly defined here
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DatabaseApp().setVisible(true);
            }
        });
    }
}