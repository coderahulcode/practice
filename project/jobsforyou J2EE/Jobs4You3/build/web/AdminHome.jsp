<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Home</title>
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
        <center>  <h1 > WELCOME ADMIN <%=username%> </h1></center>
         <%@include file="1.html" %>
        <%
        String message=request.getParameter("msg");
        if(message!=null)
        {
        %>
        <script>
            alert("<%=message%>");
        </script>
        <%
        }
        %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
