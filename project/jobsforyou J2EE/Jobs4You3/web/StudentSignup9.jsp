<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
    <center> <title>Work Experience</title></center>
        
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main" class="studentlogin">
        
        <h1> Work Experience </h1>
        <form action="StudentSignup10.jsp" method="post">
                       <center> <table border="1">

                <tr>
                    <td> Company </td>
                    <td> <input type="text" name="company" /> </td>
                </tr>
                <tr>
                    <td> Role in Company</td>
                    <td><input type="text" name="role" required placeholder="Type fresher if no Exp."/> </td>
                </tr>
                <tr>
                    <td> From Date </td>
                    <td><input type="date" name="from"/> </td>
                </tr>
                <tr>
                    <td> End Date </td>
                    <td><input type="date" name="end"/> </td>
                </tr>
                <tr>
                    <td>Package(Annually) </td>
                    <td><input type="text" name="package"/> </td>
                </tr>
                <tr>
                    <td><input type="submit" style="background-color: #4c4c4c; color: #f1f1f1" value="Save and Continue"/></td>
                </tr>
                           </table></center>
        </form>
        <center><td><input type="button" style="background-color: #4c4c4c; color: #f1f1f1" onclick="go()" value="I am Fresher" /></td></center>
        <script>
            function go()
            {
                alert("in go");
                window.location.href="StudentSignup10.jsp?msg=fresher";
            }
        </script>
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>