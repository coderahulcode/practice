<%-- 
    Document   : AddCollege2
    Created on : May 9, 2014, 9:33:56 AM
    Author     : Harpreet
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add College</title>
    </head>
    <body>
        <%
            int university_id=Integer.parseInt(request.getParameter("university"));
            String college_name=request.getParameter("college_name");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from college where university_id="+university_id+" and college_name='"+college_name+"'");
            if(!rs.next())
            {
                rs.moveToInsertRow();
                rs.updateInt("university_id", university_id);
                rs.updateString("college_name",college_name );
                rs.insertRow();
                response.sendRedirect("AdminHome.jsp?msg=College Added Successfully !");
            }
        %>
    </body>
</html>
