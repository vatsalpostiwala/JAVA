<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  if ("POST".equals(request.getMethod())) {
    PreparedStatement up = con.prepareStatement("UPDATE emp_records SET name=?, department=?, salary=? WHERE id=?");
    up.setString(1, request.getParameter("name"));
    up.setString(2, request.getParameter("department"));
    up.setDouble(3, Double.parseDouble(request.getParameter("salary")));
    up.setInt(4, id);
    up.executeUpdate();
    con.close();
    response.sendRedirect("emp_index.jsp");
    return;
  }
  PreparedStatement ps = con.prepareStatement("SELECT * FROM emp_records WHERE id=?");
  ps.setInt(1, id);
  ResultSet rs = ps.executeQuery();
  rs.next();
%>
<html>
<body>
  <h2>Update Employee</h2>
  <form method="post" action="emp_edit.jsp?id=<%= id %>">
    Name: <input type="text" name="name" value="<%= rs.getString("name") %>"><br><br>
    Department: <input type="text" name="department" value="<%= rs.getString("department") %>"><br><br>
    Salary: <input type="text" name="salary" value="<%= rs.getDouble("salary") %>"><br><br>
    <input type="submit" value="Update">
  </form>
  <a href="emp_index.jsp">Back</a>
</body>
</html>