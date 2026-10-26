<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<html>
<body>
  <h2>Employee Details</h2>
  <a href="emp_add.jsp">Add New Employee</a><br><br>
  <table border="1" cellpadding="6">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Department</th>
      <th>Salary</th>
      <th>Action</th>
    </tr>
<%
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM emp_records");
  while (rs.next()) {
    int id = rs.getInt("id");
%>
    <tr>
      <td><%= id %></td>
      <td><%= rs.getString("name") %></td>
      <td><%= rs.getString("department") %></td>
      <td><%= rs.getDouble("salary") %></td>
      <td>
        <a href="emp_edit.jsp?id=<%= id %>">Edit</a> |
        <a href="emp_delete.jsp?id=<%= id %>">Delete</a>
      </td>
    </tr>
<%
  }
  con.close();
%>
  </table>
</body>
</html>