<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db.jsp" %>
<%
  if ("POST".equals(request.getMethod())) {
    PreparedStatement ps = con.prepareStatement("INSERT INTO crud_items(item_name, category, price) VALUES(?, ?, ?)");
    ps.setString(1, request.getParameter("item_name"));
    ps.setString(2, request.getParameter("category"));
    ps.setDouble(3, Double.parseDouble(request.getParameter("price")));
    ps.executeUpdate();
    con.close();
    response.sendRedirect("index.jsp");
    return;
  }
%>
<html>
<body>
  <h2>Add Item</h2>
  <form method="post">
    Item Name: <input type="text" name="item_name"><br><br>
    Category: <input type="text" name="category"><br><br>
    Price: <input type="text" name="price"><br><br>
    <input type="submit" value="Save">
  </form>
  <a href="index.jsp">Back</a>
</body>
</html>