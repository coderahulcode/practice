<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Company Login</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company where username='" + username + "' and password='" + password + "'");
            if (rs.next())
            {
                session.setAttribute("recruiter", username);
                session.setAttribute("id", rs.getInt("id"));
                response.sendRedirect("CompanyHome.jsp");
            } 
            else
            {
                response.sendRedirect("CompanyLogin.jsp?msg=invalid username/password");
            }
        %>
    </body>
</html>
