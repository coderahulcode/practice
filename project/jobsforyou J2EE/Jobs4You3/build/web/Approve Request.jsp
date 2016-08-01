<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approve Request</title>
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
           while (rs.next())
           {
               rs.updateBoolean("Status",true);
               rs.updateRow();
               response.sendRedirect("AdminHome.jsp?msg=Company Approved Successfully");
           }
           %>
           
        
        
    </body>
</html>
