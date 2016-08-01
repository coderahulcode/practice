<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Manage packages</title>
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
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            System.out.println("connection build");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("statement created");
            ResultSet rs = stmt.executeQuery("select * from package");
            System.out.println("result set created");
        %>
        <table border="1">
            <tr>
                <th>
                    Name
                </th> 
                <th>
                    No.of Colleges
                </th> 
                <th colspan="2">
                    Description
                </th> 
            </tr>
            <%
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int no_of_colleges = rs.getInt("no_of_colleges");
                    String description = rs.getString("description");
            %>
            <tr>
                <td>
                    <%=name%>
                </td>
                <td>
                    <%=no_of_colleges%>
                </td>
                <td>
                    <%=description%>
                </td>
                <td>
                    <a href="ManagePackage2.jsp?id=<%=id%>"> Edit/Delete </a>
                </td>
            </tr>
            <%

                }
            %>
        </table>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
