<%-- 
    Document   : ChangeIndex
    Created on : May 10, 2014, 12:14:00 PM
    Author     : Harpreet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Index</title>
    </head>
    <body>
        <%
            int value=Integer.parseInt(request.getParameter("questionbt"));
            session.setAttribute("index", value-1);
            response.sendRedirect("NewExam2.jsp");
            %>
    </body>
</html>
