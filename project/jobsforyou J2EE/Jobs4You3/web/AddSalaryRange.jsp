<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Salary Range</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <form action="AddSalaryRange2.jsp">
            <table>
                <tr>
                    <td>Salary Range</td>
                    <td><input type="text" name="salary" required  /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add"/></td>
                </tr>
            </table>
        </form>
                </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
