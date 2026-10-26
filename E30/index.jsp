<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db.jsp" %>
<html>
<body>
  <h2>Item CRUD Operations</h2>
  <a href="add.jsp">Add New Item</a><br><br>
  <table border="1" cellpadding="6">
    <tr>
      <th>ID</th>
      <th>Item Name</th>
      <th>Category</th>
      <th>Price</th>
      <th>Action</th>
    </tr>
<%
  Statement st = con.createStatement();
  ResultSet rs = st.executeQuery("SELECT * FROM crud_items");
  while (rs.next()) {
    int id = rs.getInt("id");
%>
    <tr>
      <td><%= id %></td>
      <td><%= rs.getString("item_name") %></td>
      <td><%= rs.getString("category") %></td>
      <td><%= rs.getDouble("price") %></td>
      <td>
        <a href="edit.jsp?id=<%= id %>">Edit</a> |
        <a href="delete.jsp?id=<%= id %>">Delete</a>
      </td>
    </tr>
<%
  }
  con.close();
%>
  </table>
</body>
</html>