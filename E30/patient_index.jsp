<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<html>
<body>
  <h2>Patient Details</h2>
  <a href="patient_add.jsp">Add New Patient</a><br><br>
  <table border="1" cellpadding="6">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Age</th>
      <th>Disease</th>
      <th>Status</th>
      <th>Action</th>
    </tr>
<%
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM patient_records");
  while (rs.next()) {
    int id = rs.getInt("patient_id");
%>
    <tr>
      <td><%= id %></td>
      <td><%= rs.getString("name") %></td>
      <td><%= rs.getInt("age") %></td>
      <td><%= rs.getString("disease") %></td>
      <td><%= rs.getString("status") %></td>
      <td>
        <a href="patient_edit.jsp?id=<%= id %>">Edit</a> |
        <a href="patient_delete.jsp?id=<%= id %>">Delete</a>
      </td>
    </tr>
<%
  }
  con.close();
%>
  </table>
</body>
</html>