
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Student Login</title>
    </head>
    <body>
        <%
            String skill = request.getParameter("skill");
            int level = Integer.parseInt(request.getParameter("level"));
            int experience = Integer.parseInt(request.getParameter("experience"));
            int id = (Integer)session.getAttribute("id");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from skills");
            rs.moveToInsertRow();
            rs.updateString("skill",skill);
            rs.updateInt("skill_level",level);
            rs.updateInt("user_id",id);
            rs.updateInt("experience",experience);
            rs.insertRow();
            response.sendRedirect("StudentSignup9.jsp");
        %>
    </body>
</html>
