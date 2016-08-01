<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Change Password</title>
        <script>
            function change()
            {
                var p1 = document.getElementById("pass1").value;
                var p2 = document.getElementById("pass2").value;
                var p3 = document.getElementById("oldpass").value;
                if(p1===p2)
                {
                    if(p1===p3)
                    {
                        document.getElementById("lable1").style.display = "block";
                    }
                    else
                    {
                        return true;
                    }
                }
                else
                {
                    alert("not matched");
                    document.getElementById("lable2").style.display = "block";
                }
                return false;
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
            String username = (String) session.getAttribute("username");
        %>
        <h1>Change password</h1>
        <form action="ChangePassword2.jsp" method="post" onsubmit="return change()">
            <table border="1">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name = "username" value="<%=username%>" readonly /></td>
                </tr>
                <tr>
                    <td>Old Password</td>
                    <td><input type="password" name="oldpassword" required id="oldpass" /></td>
                </tr>
                <tr>
                    <td>New Password</td>
                    <td><input type="password" name="newpassword" required id="pass1"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="lable1" style=" display: none ;color: red "><label>*Same Old/ New Password</label> </div>
                    </td>
                </tr>
                <tr>
                    <td>Confirm New Password</td>
                    <td><input type="password" required="" id="pass2" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div id="lable2" style=" display: none ;color: red "><label>*Passwords Not Matching</label> </div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Change" /></td>
                </tr>
            </table>
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
