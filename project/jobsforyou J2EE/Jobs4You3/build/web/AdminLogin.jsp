<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Administrator login</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main">
        <%
            if(session.getAttribute("username")!=null)
            {
                response.sendRedirect("AdminHome.jsp");
            }
        %>
        <center>
            <h2>ADMIN LOGIN</h2>
                <div class="tabletexture" style=" border: solid 4px #4c4c4c; box-shadow: 10px 0px 5px #cccccc; border-radius: 10px; width: 400px;margin-top: 100px;background-color: #f1f1f1;height: 250px;">
                    <center>
        <form action="AdminLogin2.jsp" method="post" style="margin-top: 50px">
            <table>
            <tr>
                <td>Username</td>
                <td><input class="textboxnew"  type="text" name="username" required/><td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input class="textboxnew" type="password" name="password" required/><td>
            </tr>
            <tr>
                
                <td colspan="2"><center><input type="submit" value="Login"class="button"/></center></td>
            </tr>
            </table>
        </form>
                         <%
            String msg = request.getParameter("msg");
            if (msg != null) 
            {
        %>

        <h1 style="color: red">*<%=msg%></h1>
        <%
            }
        %>
                </div>
       
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>

</html>