<%@page import="abc.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Short List Students</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%
            String check[] = request.getParameterValues("check");
            ArrayList<Student> al = (ArrayList) session.getAttribute("studentdata");
            session.setAttribute("check", check);
        %>
        <table class="CSSTableGenerator">
            <tr><td>S. No. </td><td>Name</td><td>Graduation Marks</td><td>Xth Marks</td><td>XIIth Marks</td><td>Skills</td></tr>
                    <%
                        for (int i = 0; i < check.length; i++)
                        {
                            int pos = Integer.parseInt(check[i]);
                            Student s = al.get(pos);
                    %>
            <tr>
                <td><%=(i + 1)%></td>
                <td><%=s.name%></td>
                <td><%=s.graduationmarks%></td>
                <td><%=s.tenthmarks%></td>
                <td><%=s.twelvethmarks%></td>
                <td><%=s.skill%></td>
            </tr>
            <%
                }
            %>
        </table>
        <form action="FilterStudent.jsp" method="post">
            <input type="submit" value="Edit"/>
        </form>
        <form method="post" action="ConfirmSelection.jsp">
            <input type="submit" value="Confirm Students"/>
        </form>
        
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>