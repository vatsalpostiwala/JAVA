<%@ page import="java.lang.*, java.sql.*" %>
<%
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sit_java", "root", "12345");
%>