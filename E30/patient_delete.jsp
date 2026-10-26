<%@ page import="java.lang.*, java.sql.*" %>
<%@ include file="db_conn.jsp" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  PreparedStatement ps = con.prepareStatement("DELETE FROM patient_records WHERE patient_id=?");
  ps.setInt(1, id);
  ps.executeUpdate();
  con.close();
  response.sendRedirect("patient_index.jsp");
%>