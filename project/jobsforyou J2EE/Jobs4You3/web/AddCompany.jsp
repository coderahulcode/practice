<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Add Company</title>
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
        %>
        <form action="AddCompany2.jsp" method="post">
            <table border="1">
                <tr>
                    <td> Company Name </td>
                    <td> <input type="text" name="companyname" required/> </td>
                </tr>
                <tr>
                    <td> Address</td>
                    <td><input type="text" name="address" required/></td>
                </tr>
                <tr>
                    <td> Contact No.</td>
                    <td><input type="text" name="number" required/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="desc" required  /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Company"/></td>
                </tr>
            </table>
        </form>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
