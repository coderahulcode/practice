
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Student Login</title>
    </head>
    <body>
        <%
            String username=""; 
            int id = (Integer)session.getAttribute("id");
            String jobtype = request.getParameter("jobtype");
            String extra = request.getParameter("extra");
            int loc = Integer.parseInt(request.getParameter("location"));
            int range = Integer.parseInt(request.getParameter("range"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from other_information");
            rs.moveToInsertRow();
            rs.updateString("prefered_job_type",jobtype);
            rs.updateString("extra",extra);
            rs.updateInt("prefered_job_location",loc);
            rs.updateInt("user_id",id);
            rs.updateInt("expected_salary_range", range);
            rs.insertRow();
            Statement stmt1= con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from personal_information where user_id="+id);
            if(rs1.next())
            {
                username=rs1.getString("username");
            }
            session.setAttribute("studentname",username);
            response.sendRedirect("StudentHome.jsp?msg=Profile Complete");
        %>
    </body>
</html>