
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Placement Drive Shortlisting</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main" class='recruiter'>
        <%
            int pid=0;
            String description="";
            int students_count=0;
            %>
        <table class='CSSTableGenerator'>
            
            <tr>
            <td>Company Name</td>
            <td>No. of Students</td>
            <td>Description</td>
            </tr>
        <%
        int companyid = (Integer)session.getAttribute("id");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from placementdrive where company=" + companyid);
        Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        int cid=0;

        while (rs.next())
        {
            pid = rs.getInt("pid");
            description = rs.getString("description");
           cid= rs.getInt("company");
            String cname="";
            ResultSet rs1 = stmt1.executeQuery("select count(id) as count from shortlisted_students where pid=" + pid);
            if (rs1.next())
            {
                students_count = rs1.getInt("count");
            }
            ResultSet rs2 = stmt2.executeQuery("select * from company where id="+cid);
            if (rs2.next())
            {
                cname = rs2.getString("name");
            }
        %>
        
        
        <tr><td><%=cname%></td><td><%=students_count%></td><td><a href="AllStudents.jsp?pid=<%=pid%>">Show Details</a></td></tr>
        <%
        }
        %>
        </table>
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>  
