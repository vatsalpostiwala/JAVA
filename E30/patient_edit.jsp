<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  if ("POST".equals(request.getMethod())) {
    PreparedStatement up = con.prepareStatement("UPDATE patient_records SET name=?, age=?, disease=?, status=? WHERE patient_id=?");
    up.setString(1, request.getParameter("name"));
    up.setInt(2, Integer.parseInt(request.getParameter("age")));
    up.setString(3, request.getParameter("disease"));
    up.setString(4, request.getParameter("status"));
    up.setInt(5, id);
    up.executeUpdate();
    con.close();
    response.sendRedirect("patient_index.jsp");
    return;
  }
  PreparedStatement ps = con.prepareStatement("SELECT * FROM patient_records WHERE patient_id=?");
  ps.setInt(1, id);
  ResultSet rs = ps.executeQuery();
  rs.next();
%>
<html>
<body>
  <h2>Update Patient</h2>
  <form method="post" action="patient_edit.jsp?id=<%= id %>">
    Name: <input type="text" name="name" value="<%= rs.getString("name") %>"><br><br>
    Age: <input type="text" name="age" value="<%= rs.getInt("age") %>"><br><br>
    Disease: <input type="text" name="disease" value="<%= rs.getString("disease") %>"><br><br>
    Status: <input type="text" name="status" value="<%= rs.getString("status") %>"><br><br>
    <input type="submit" value="Update">
  </form>
  <a href="patient_index.jsp">Back</a>
</body>
</html>