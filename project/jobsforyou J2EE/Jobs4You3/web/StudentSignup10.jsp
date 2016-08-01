
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Student Login</title>
    </head>
    <body>
        <%
            String msg = request.getParameter("msg");
            if (msg != null)
            {
                int id = (Integer) session.getAttribute("id");
                java.sql.Date s=new java.sql.Date(2000, 1, 1);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from work_experience");
                rs.moveToInsertRow();
                rs.updateString("company", "");
                rs.updateString("role", "");
                rs.updateInt("user_id", id);
                rs.updateDate("from_date",s);
                rs.updateDate("end_date", s);
                rs.updateFloat("package", 0);
                rs.insertRow();
                response.sendRedirect("StudentSignup11.jsp");
            }
            else
            {
            int id = (Integer) session.getAttribute("id");
            String company = request.getParameter("company");
            String role = request.getParameter("role");
            Date from = Date.valueOf(request.getParameter("from"));
            Date end = Date.valueOf(request.getParameter("end"));
            float salary = Float.parseFloat(request.getParameter("package"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from work_experience");
            rs.moveToInsertRow();
            rs.updateString("company","N/A");
            rs.updateString("role", role);
            rs.updateInt("user_id", id);
            rs.updateDate("from_date", from);
            rs.updateDate("end_date", end);
            rs.updateFloat("package", 0);
            rs.insertRow();
            response.sendRedirect("StudentSignup11.jsp");
            }
        %>
    </body>
</html>