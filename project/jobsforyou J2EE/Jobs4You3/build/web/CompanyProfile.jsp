

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Company Profile</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%
            int id = (Integer)(session.getAttribute("id"));
            Class.forName("com.mysql.jdbc.Driver");
            String name="";
            String path="";
            String desc="";
            String address="";
            String contact="";
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company where id ="+id);
            if(rs.next())
            {
                name = rs.getString("name");
                path = rs.getString("imageurl");
                desc = rs.getString("description");
                address = rs.getString("address");
                contact = rs.getString("workphone");
            }
        %>
        <h1 style="background-color: background;" align="center" ><%=name%></h1>
        <center><img src="<%=path%>" width="400" height="400" style="" alt="<%=name%> Logo"/></center>
        <h3 style="background-color: palegoldenrod;text-align: justify"><%=desc%></h3>
        <h4 style="background-color: chartreuse">Address: <%=address%></h4>
        <h4 style="background-color: chartreuse">Contact No. : <%=contact%></h4>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
