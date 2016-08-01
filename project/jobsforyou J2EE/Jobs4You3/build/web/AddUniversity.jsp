<%-- 
    Document   : AddUniversity
    Created on : May 8, 2014, 1:08:11 PM
    Author     : Harpreet
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        
       
        <%
            String university=request.getParameter("university");
            System.out.println(":::::::::::::::::::::::::::::::::::::"+university);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from university");
            rs.moveToInsertRow();
            rs.updateString("university",university);
            rs.insertRow();
            response.sendRedirect("AdminHome.jsp?msg=University Added Successfully !");
        %>
    </body>
</html>
