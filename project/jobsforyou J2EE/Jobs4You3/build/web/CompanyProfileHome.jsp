<%-- 
    Document   : CompanyProfileHome
    Created on : May 14, 2014, 6:00:23 AM
    Author     : Harpreet
--%>



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
            <%@include file="Header2.jsp" %>
             
            <div id="main">
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            Class.forName("com.mysql.jdbc.Driver");
            String name="";
            String path="";
            String desc="";
            String address="";
            String contact="";
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from all_companies where id ="+id);
            if(rs.next())
            {
                name = rs.getString("name");
                path = rs.getString("logo");
            }
            stmt = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery("select * from company_details where company_id ="+id);
            if(rs.next())
            {
                desc = rs.getString("description");
                address = rs.getString("address");
                contact = rs.getString("contactno");
            }
        %>
        <h1 style="background-color: chartreuse;" align="center" ><%=name%></h1>
        <center><img src="<%=path%>" width="250" height="250" style="" alt="<%=name%> Logo"/></center>
        <h3 style="background-color: palegoldenrod;text-align: justify"><%=desc%></h3>
        <h4 style="background-color: chartreuse">Address: <%=address%></h4>
        <h4 style="background-color: chartreuse">Contact No. : <%=contact%></h4>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
