<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Requested Detail</title>

    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main">
        <table border="0">

            <%

                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded successfully");
                Connection con = DriverManager.getConnection("jdbc:mysql://192.168.137.204:3306/myschema", "root", "system");
                System.out.println("connection build");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                System.out.println("statement created");
                int id = Integer.parseInt(request.getParameter("id"));
                ResultSet rs = stmt.executeQuery("select * from company where id="+id);
                System.out.println("result set created");
                while (rs.next()) {
                    String emailid = rs.getString("emailid");
                    String imageurl = rs.getString("imageurl");
                    String name = rs.getString("name");
                    String workphone = rs.getString("workphone");
                    int type = rs.getInt("type");
                    String location = rs.getString("location");
                    String description = rs.getString("description");
                    String turnover = rs.getString("turnover");
                    String address = rs.getString("address");
                   // boolean status = rs.getBoolean("status");
%>
            <tbody>

                <tr>
                    <td><img src="<%=imageurl%>" width="100" height="100"/></td>
                    <td><%=name%></td>

                </tr>
                <tr>

                    <td>Email Id </td>
                    <td><%= emailid%> </td>
                </tr>
                <tr>
                    <td>Package type</td>
                    <td> <%= type%> </td>
                </tr>
                <tr>
                    <td>WorkPhone</td>
                    <td><%= workphone%> </td>
                </tr>



                <tr>
                    <td>TurnOver</td>
                    <td><%= turnover%></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><%= address%></td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td><%= location%></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><%= description%></td>
                </tr>

            </tbody>
        </table>
        <%
            }
        %>



</div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
