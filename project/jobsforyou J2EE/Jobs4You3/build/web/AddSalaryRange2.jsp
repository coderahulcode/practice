<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <%
            String category = request.getParameter("salary");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from salary_range");
            rs.moveToInsertRow();
            rs.updateString("salary_range", category);
            rs.insertRow();
            response.sendRedirect("AdminHome.jsp?msg=Salary Range Added Successfully !");
            %>
    </body>
</html>
