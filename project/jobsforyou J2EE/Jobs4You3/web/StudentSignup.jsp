<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Student Signup</title>
        <script>
            function login()
            {
                var pass = document.getElementById("pass").value;
                var confpass = document.getElementById("confpass").value;
                if(pass===confpass)
                {
                    return true;
                }
                else
                {
                    document.getElementById("lable1").style.display = "block";
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main" class="studentlogin">
        <form action="StudentSignup2.jsp" method="post" onsubmit="return login()">
            <center> <table border="1">
                <tr>
                    <td> Username </td>
                    <td> <input type="text" name="username" required/> </td>
                </tr>
                <tr>
                    <td> Email ID </td>
                    <td> <input type="email" name="email" required/> </td>
                </tr>
                <tr>
                    <td> Contact No. </td>
                    <td> <input type="text" name="number" value="" required/> </td>
                </tr>
                <tr>
                    <td> Password </td>
                    <td> <input type="password" name="password" id="pass"  required/> </td>
                </tr>
                <tr>
                    <td> Confirm Password </td>
                    <td> <input type="password" id="confpass" required/> </td>
                </tr>
                 <tr>
                    <td colspan="2">
                        <div id="lable1" style=" display: none ;color: red "><label>*Passwords Not Matching</label> </div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Signup"/></td>
                </tr>
                </table></center>
        </form>
        <%
            String msg = (String) request.getParameter("msg");
            if(msg!=null)
            {
                %>
                    <div style="color: red "><label>*<%=msg%></label> </div>
                <%
            }
        %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
