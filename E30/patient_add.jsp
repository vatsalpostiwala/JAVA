<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<%
  if ("POST".equals(request.getMethod())) {
    PreparedStatement ps = con.prepareStatement("INSERT INTO patient_records(name, age, disease, status) VALUES(?, ?, ?, ?)");
    ps.setString(1, request.getParameter("name"));
    ps.setInt(2, Integer.parseInt(request.getParameter("age")));
    ps.setString(3, request.getParameter("disease"));
    ps.setString(4, request.getParameter("status"));
    ps.executeUpdate();
    con.close();
    response.sendRedirect("patient_index.jsp");
    return;
  }
%>
<html>
<body>
  <h2>Add Patient</h2>
  <form method="post">
    Name: <input type="text" name="name"><br><br>
    Age: <input type="text" name="age"><br><br>
    Disease: <input type="text" name="disease"><br><br>
    Status: <select name="status">
      <option>Under Treatment</option>
      <option>Recovered</option>
    </select><br><br>
    <input type="submit" value="Save">
  </form>
  <a href="patient_index.jsp">Back</a>
</body>
</html>