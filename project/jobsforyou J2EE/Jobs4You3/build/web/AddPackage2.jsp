<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Package</title>
    </head>
    <body>
        <%
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
            String packagename = request.getParameter("packagename");
            String description = request.getParameter("desc");
            int number = Integer.parseInt(request.getParameter("number"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from package");
            rs.moveToInsertRow();
            rs.updateString("name", packagename);
            rs.updateInt("no_of_colleges", number);
            rs.updateString("description", description);
            rs.insertRow();
            response.sendRedirect("AdminHome.jsp?msg=Package Added Successfully !");
        %>
    </body>
</html>
