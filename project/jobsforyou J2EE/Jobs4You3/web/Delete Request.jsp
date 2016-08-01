<%-- 
    Document   : Approve Request
    Created on : 08-Apr-2014, 11:27:29
    Author     : Mahajan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
           <%
            
           
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Driver loaded successfully");
           Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema","root","rahul");
           System.out.println("connection build");
           Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           System.out.println("statement created");
           int id = Integer.parseInt(request.getParameter("id"));
           ResultSet rs=stmt.executeQuery("select * from company where id ="+id);
           System.out.println("result set created");
           if (rs.next())
           {
               rs.deleteRow();
               response.sendRedirect("AdminHome.jsp");
           }
           %>
           
        
        
        
    </body>
</html>
