<%@ page language="java" import="java.lang.*" info="package E29" %>
<html>
<body>
<%
  String name = request.getParameter("name");
  String roll = request.getParameter("roll");
  String branch = request.getParameter("branch");
%>
  <h2>Student Information</h2>
  <p>Name   : <%= name %></p>
  <p>Roll No: <%= roll %></p>
  <p>Branch : <%= branch %></p>
  <a href="student.html">Back</a>
</body>
</html>