<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Manage Package</title>
        <script>
            function go()
            {
                return confirm("Are you sure you want to delete this package ?");
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <%
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
            int id = (Integer.parseInt(request.getParameter("id")));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from package where id=" + id);
            if (rs.next())
            {
                String name = rs.getString("name");
                int no_of_colleges = rs.getInt("no_of_colleges");
                String description = rs.getString("description");
        %>   
        <form action="ManagePackage3.jsp?id=<%=id%>" method="post">
            <table border="1">
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="packagename" value="<%=name%>"></td>
                </tr>
                <tr>
                    <td>No. of Colleges</td>
                    <td><input type="text" name="number" value="<%=no_of_colleges%>"></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><textarea name="desc"><%=description%></textarea></td>
                </tr>
                <tr>
                    <td><input type="submit" name="button" value="Edit"/></td>
                    <td><input type="submit" name="button" value="Delete" onclick=" return go()"/></td>
                </tr>
            </table>

        </form>
        <%
            }
        %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
