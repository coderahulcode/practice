<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Company Signup</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main" class="recruiter">
        <form action ="CompanySignup4.jsp" enctype="multipart/form-data" method="post">
            <center>
                <table border="1" style="margin-top: 10px">
                <tr>
                    <td>
                        <h2>Upload Company Logo</h2>
                    </td>
                    <td>
                        <input type="file" name="imageurl"/> 
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" name="Upload"/> 
                    </td>
                </tr>
            </table>
            </center>
        </form>
                </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
