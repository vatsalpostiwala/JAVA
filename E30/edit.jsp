<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db.jsp" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  if ("POST".equals(request.getMethod())) {
    PreparedStatement up = con.prepareStatement("UPDATE crud_items SET item_name=?, category=?, price=? WHERE id=?");
    up.setString(1, request.getParameter("item_name"));
    up.setString(2, request.getParameter("category"));
    up.setDouble(3, Double.parseDouble(request.getParameter("price")));
    up.setInt(4, id);
    up.executeUpdate();
    con.close();
    response.sendRedirect("index.jsp");
    return;
  }
  PreparedStatement ps = con.prepareStatement("SELECT * FROM crud_items WHERE id=?");
  ps.setInt(1, id);
  ResultSet rs = ps.executeQuery();
  rs.next();
%>
<html>
<body>
  <h2>Update Item</h2>
  <form method="post" action="edit.jsp?id=<%= id %>">
    Item Name: <input type="text" name="item_name" value="<%= rs.getString("item_name") %>"><br><br>
    Category: <input type="text" name="category" value="<%= rs.getString("category") %>"><br><br>
    Price: <input type="text" name="price" value="<%= rs.getDouble("price") %>"><br><br>
    <input type="submit" value="Update">
  </form>
  <a href="index.jsp">Back</a>
</body>
</html>