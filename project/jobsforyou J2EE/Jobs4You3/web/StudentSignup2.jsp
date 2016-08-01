
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Student Signup</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String number = request.getParameter("number");
            String password = request.getParameter("password");
            boolean entry = false;
            int id = 0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from student where username='" + username + "'");
            if (!(rs.next()))
            {
                rs.moveToInsertRow();
                rs.updateString("username", username);
                rs.updateString("password", password);
                rs.insertRow();
                entry = true;
            } else
            {
                response.sendRedirect("StudentSignup.jsp?msg=Username Already Exists");
            }
            if (entry)
            {
                Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2 = stmt2.executeQuery("select id from student where username='" + username + "'");
                if (rs2.next())
                {
                    id = rs2.getInt("id");
                }
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from personal_information");
                rs1.moveToInsertRow();
                rs1.updateInt("user_id", id);
                rs1.updateString("username", username);
                rs1.updateString("email", email);
                rs1.updateString("mobile_no", number);
                session.setAttribute("email", email);
                session.setAttribute("no", number);
                rs1.insertRow();
                session.setAttribute("id", id);
                response.sendRedirect("UploadPhoto.jsp");
            }
        %>
    </body>
</html>
