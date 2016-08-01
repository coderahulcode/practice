<%-- 
    Document   : SearchCompany2
    Created on : May 12, 2014, 9:59:44 AM
    Author     : Harpreet
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Company</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main">
        <table class="CSSTableGenerator" border="1">
            <tr>
            <td>S.No.</td>
            <td>Company Name</td>
            <td>logo</td>
                
            </tr>
        <%
            int i=0;
            String company=request.getParameter("search");
            String companyname;
            String logo;
            int id;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from all_companies where name like '%"+company+"%'");
            while(rs.next())
            {
                companyname=rs.getString("name");
                id=rs.getInt("id");
                logo=rs.getString("logo");
                i++;
                %>
            <tr>
                    <td> <%=i%></td>
                    <td><a href="CompanyProfileHome.jsp?id=<%=id%>"><%=companyname%></a></td>
                    <td> <img src="<%=logo%>" width="50" height="50" style="" alt="<%=companyname%>"/></td>
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
