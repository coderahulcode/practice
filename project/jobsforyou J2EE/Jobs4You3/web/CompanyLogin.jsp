<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Recruiter login</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main" class="recruiter">
        
        
        <center>
            <h1> RECRUITER LOGIN  </h1>
                <div class="tabletexture" style=" border: solid 4px #4c4c4c; box-shadow: 10px 0px 5px #cccccc; border-radius: 10px; width: 400px;margin-top: 100px;background-color: #f1f1f1;height: 250px;">
                    <center>
        <form action="CompanyLogin2.jsp" method="post" style="margin-top: 50px";>
            <table >
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
            <tr>
                
                <td colspan="2"><center>
                    <a href="CompanySignup.jsp"> Not a user ? Register Here...</a></center>
                </td>
            </tr>
            </table>
        </form>
                         </center>
        <%
            String msg = request.getParameter("msg");
            if (msg != null) 
            {
        %>

        <h1 style="color: red">*<%=msg%></h1>
        <%
            }
        %>
                </div></center>
            
        </div>
                <%@include file="Footer.jsp" %>
        </div>
    </body>

</html>