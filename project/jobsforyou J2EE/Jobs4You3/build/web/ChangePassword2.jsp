
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Change Password</title>
    </head>
    <body>
        <%
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
            String username = (String) session.getAttribute("username");
            String oldpassword = (String) request.getParameter("oldpassword");
            String newpassword = (String) request.getParameter("newpassword");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from admin where username='" + username + "' and password='" + oldpassword + "'");
            if (rs.next()) 
            {
                rs.updateString("password", newpassword);
                rs.updateRow();
                response.sendRedirect("AdminHome.jsp?msg=Password Changed Successfully !");
            }
            else
            {
                response.sendRedirect("ChangePassword.jsp?msg=Wrong Password Entered");
            }
        %>
    </body>
</html>
