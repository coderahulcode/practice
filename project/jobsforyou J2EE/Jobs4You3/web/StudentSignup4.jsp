
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Student Signup</title>
    </head>
    <body>
        <%
            String firstname = request.getParameter("firstname");
            String middlename = request.getParameter("middlename");
            String lastname = request.getParameter("lastname");
            String secemail = request.getParameter("secemail");
            String homeno = request.getParameter("homeno");
            String gender = request.getParameter("gender");
            String nationality = request.getParameter("nationality");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            int state = Integer.parseInt(request.getParameter("state"));
            int pin = Integer.parseInt(request.getParameter("pin"));
            int id = (Integer)session.getAttribute("id");
            int addressid=0;
            boolean flag = false;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from user_address");
            rs1.moveToInsertRow();
            rs1.updateString("country", country);
            rs1.updateString("city", city);
            rs1.updateString("street", street);
            rs1.updateInt("state",state);
            rs1.updateInt("userid",id);
            rs1.updateInt("pin",pin);
            rs1.insertRow();
            flag = true;
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt2.executeQuery("select id from user_address where userid="+id);
            if(rs2.next())
            {
                addressid = rs2.getInt("id");
            }
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from personal_information where user_id='" + id + "'");
            if (rs.next()&& flag) 
            {
                rs.updateString("first_name", firstname);
                rs.updateString("middle_name", middlename);
                rs.updateString("last_name", lastname);
                rs.updateString("secondary_email", secemail);
                rs.updateString("home_phone", homeno);
                rs.updateString("gender", gender);
                rs.updateString("nationality", nationality);
                rs.updateInt("address", addressid);
                rs.updateRow();
                session.setAttribute("email", null);
                session.setAttribute("no", null);
                response.sendRedirect("StudentSignup5.jsp");
            }
        %>
    </body>
</html>
