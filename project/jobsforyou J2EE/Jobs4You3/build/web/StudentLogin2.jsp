<%-- 
    Document   : StudentLogin2
    Created on : 17 Apr, 2014, 12:02:40 PM
    Author     : Mahajan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Login</title>
    </head>
    <body> 
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from student where username='" + username + "' and password='" + password + "'");
            if (rs.next())
            {
                int id=rs.getInt("id");
                session.setAttribute("studentname", username);
                session.setAttribute("id", id);
                response.sendRedirect("StudentHome.jsp");
            } else
            {
                response.sendRedirect("StudentLogin.jsp?msg=invalid username/password");
            }
        %>
    </body>
</html>
