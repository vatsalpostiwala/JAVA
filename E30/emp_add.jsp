<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<%
  if ("POST".equals(request.getMethod())) {
    PreparedStatement ps = con.prepareStatement("INSERT INTO emp_records(name, department, salary) VALUES(?, ?, ?)");
    ps.setString(1, request.getParameter("name"));
    ps.setString(2, request.getParameter("department"));
    ps.setDouble(3, Double.parseDouble(request.getParameter("salary")));
    ps.executeUpdate();
    con.close();
    response.sendRedirect("emp_index.jsp");
    return;
  }
%>
<html>
<body>
  <h2>Add Employee</h2>
  <form method="post">
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Salary: <input type="text" name="salary"><br><br>
    <input type="submit" value="Save">
  </form>
  <a href="emp_index.jsp">Back</a>
</body>
</html>