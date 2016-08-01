<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Manage Package</title>
    </head>
    <body>
        <%
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
            String type = (String) request.getParameter("button");
            String name = (String) request.getParameter("packagename");
            int number = (Integer.parseInt(request.getParameter("number")));
            String desc = (String) request.getParameter("desc");
            int id = (Integer.parseInt(request.getParameter("id")));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from package where id=" + id);
            if (rs.next())
            {
                if (type.equals("Edit"))
                {
                    rs.updateString("name", name);
                    rs.updateInt("no_of_colleges", number);
                    rs.updateString("description", desc);
                    rs.updateRow();
                response.sendRedirect("StudentHome.jsp?msg=Package Edited Successfully !");
            } 
            else if (type.equals("Delete"))
            {
                rs.deleteRow();
            }
       
            }

        %>
    </body>
</html>
