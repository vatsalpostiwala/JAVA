<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db.jsp" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  PreparedStatement ps = con.prepareStatement("DELETE FROM crud_items WHERE id=?");
  ps.setInt(1, id);
  ps.executeUpdate();
  con.close();
  response.sendRedirect("index.jsp");
%>