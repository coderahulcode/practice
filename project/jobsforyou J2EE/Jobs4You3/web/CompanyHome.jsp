<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Home</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
           
        <%
            String username = (String) session.getAttribute("recruiter");
        %>
             
          <div id="main" >
              <center><h1> Welcome <%=username%> </h1></center>
        <%@include file="1.html" %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
