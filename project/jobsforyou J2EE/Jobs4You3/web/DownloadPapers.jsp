<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Download Papers</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
        <h1>Previous Year Papers</h1>
        <table class="CSSTableGenerator">
            <tr>
                <td>S.No</td>
                <td>Company Name</td>
                <td>Title</td>
                <td>Description</td>
                <td>Year</td>
                <td>Link</td>
            </tr>
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from papers");
                while(rs.next())
                {
                    String desc = rs.getString("description");
                    String title = rs.getString("title");
                    String path = rs.getString("path");
                    int year = rs.getInt("year");
                    int sno = rs.getInt("id");
                    int c_id = rs.getInt("company");
                    String c_name="";
                    Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("select name from all_companies where id="+c_id);
                    if(rs1.next())
                    {
                        c_name = rs1.getString("name");
                    }
                    %>
                    <tr>
                        <td><%=sno%></td>
                        <td><%=c_name%></td>
                        <td><%=title%></td>
                        <td><%=desc%></td>
                        <td><%=year%></td>
                        <td><a href="<%=path%>" target="_self">Download</a></td>
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
