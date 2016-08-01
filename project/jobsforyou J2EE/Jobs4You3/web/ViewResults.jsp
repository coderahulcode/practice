<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
                <table class="CSSTableGenerator" border="1">
                    <tr>
                    <td>Type of Exam</td>
                    <td>Marks Obtained</td>
                    <td>Date and Time</td>
                    </tr>
            <%
                int id=(Integer)session.getAttribute("id");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "system");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from result where student_id=" +id + " order by id desc");//session id
                while (rs.next())
                {
            %>
            <tr>
                <%
                    String cat = "";
                    String result = rs.getString("result");
                    String date = rs.getString("date_time");
                    int category = rs.getInt("category");
                    Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("select * from category where id=" + category);//session id"
                    if (rs1.next())
                    {
                        cat = rs1.getString("category");
                %>
                <td><%=cat%></td>
                <%
                    }
                %>
                <td><%=result%></td>
                <td><%=date%></td>
            </tr>

            <%
                }
            %>
        </table>
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
