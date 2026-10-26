<%@ page language="java" import="java.lang.*" info="package E29" %>
<%
  String name = request.getParameter("name");
  String email = request.getParameter("email");
  String phone = request.getParameter("phone");
  String pwd = request.getParameter("pwd");
  if (name == null) {
    response.sendRedirect("register.html");
    return;
  }
%>
<html>
<body>
  <h2>Registration Successful</h2>
  <p>Name    : <%= name %></p>
  <p>Email   : <%= email %></p>
  <p>Phone   : <%= phone %></p>
  <p>Password: <%= pwd.replaceAll(".", "*") %></p>
  <a href="register.html">Back</a>
</body>
</html>