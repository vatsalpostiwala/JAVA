<%@ page language="java" import="java.lang.*" info="package E29" %>
<html>
<body>
  <h2>Basic JSP Demonstration</h2>
  <%! 
    int PNR = 509; 
    String getMessage() {
      return "Welcome to JSP Programming";
    }
  %>
  <%
    String user = "Vatsal";
  %>
  <p>Message: <%= getMessage() %></p>
  <p>Hello: <%= user %></p>
  <p>PNR: <%= PNR %></p>
</body>
</html>