<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Signup</title>
    </head>
    <body>
        <%
            String password="";
            char letter=' ';
            for(int i=0;i<5;i++)
            {
                if(i<3)
                {
                    letter = (char)(65+(90-65)*(Math.random()));
                }
                else
                {
                    letter = (char)(48+(57-48)*(Math.random()));
                }
                password += letter+"";
            }
            String companyname = request.getParameter("companyname");
            String email = request.getParameter("email");
            String type = request.getParameter("option");
            String username = request.getParameter("username");
            String number = request.getParameter("number");
            String location = request.getParameter("location");
            String address = request.getParameter("address");
            String turnover = request.getParameter("turnover");
            String description = request.getParameter("description");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company where username='"+username+"'");
            ResultSet rs1 = stmt1.executeQuery("select id from package where name='"+type+"'");
            if (rs1.next()&&!(rs.next()))
            {
                int id = rs1.getInt("id");
                rs.moveToInsertRow();
                rs.updateString("name", companyname);
                rs.updateString("emailid",email);
                rs.updateInt("type",id);
                rs.updateString("password", password);
                rs.updateString("username", username);
                rs.updateString("workphone", number);
                rs.updateString("location", location);
                rs.updateString("address", address);
                rs.updateString("turnover", turnover);
                rs.updateString("description", description);
                rs.insertRow();
                session.setAttribute("recruiter", username);
                response.sendRedirect("CompanySignup3.jsp");
            }
            else
            {
                response.sendRedirect("CompanySignup.jsp?msg=username already exists");
            }
        %>
    </body>
</html>
