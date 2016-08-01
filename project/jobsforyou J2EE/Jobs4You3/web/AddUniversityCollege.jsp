<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add University or College</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <form action="AddUniversity.jsp" method="post">
        <table border="1">
                <tr>
                    <td> University name </td>
                    <td> <input type="text" name ="university"/> </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="ADD University"/></td>
                </tr>
            </table>
            </form>
        <form action="AddCollege.jsp" method="post">
            <table border="1">
                <tr>
                    <td> College Name </td>
                    <td>  <input type="text" name ="college" /> </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="ADD College"/></td>
                </tr>
            </table>
        </form>
                </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
