<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main">
        <%
            if(session.getAttribute("username")==null)
            {
                response.sendRedirect("AdminLogin.jsp");
                
            }
            else
            {
        %>
        
        <%
            session.removeAttribute("username");
            response.sendRedirect("AdminLogin.jsp");
            }
         %>
            
       
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>