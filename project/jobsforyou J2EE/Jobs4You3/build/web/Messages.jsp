<%-- 
    Document   : Messages
    Created on : May 14, 2014, 3:21:25 PM
    Author     : Harpreet
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Messages </title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
                <table class="CSSTableGenerator" border="1">
              <tr>
                  <td>Company Name</td>
                  <td>Message</td>
                  <td>Date</td>
                  <td>Time</td>
              </tr>
        <%
            int id =(Integer)(session.getAttribute("id"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from message where studentid = "+id);
          
            while(rs.next())
            {
                String message = rs.getString("message");
                int pid = rs.getInt("pid");
                int msgid =rs.getInt("id");
                String datetime = rs.getString("date_time");
                String date_time[] = datetime.split(" ");
                String tempdate = date_time[0];
                String d[] = tempdate.split("-");
                String date = d[2]+"/"+d[1];
                String temptime = date_time[1];
                String t[] = temptime.split(":");
                String time = t[0]+":"+t[1];
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from company where id=(select company from placementdrive where pid = "+pid+")");
                if(rs1.next())
                {
                    String name = rs1.getString("name");
       %>
                    <tr>
                        <td><%=name%></td>
                        <td> <%=message%></td>
                        <td><%=date%></td>
                        <td><%=time%></td>
                        
                    </tr>
           <%
                   
                }
            }
            %>
    </table>
    
    </div>
            <%@include file="Footer.jsp" %>
        </div>
   
    </body>
</html>
