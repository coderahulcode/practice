<%-- 
    Document   : StudentHome
    Created on : 17 Apr, 2014, 12:07:35 PM
    Author     : Mahajan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Home </title>
        <script>
            var xmlhttp;
            function go1(username)
            {
                alert(username);
                try
                {
                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e)
                {
                    try
                    {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e2)
                    {
                        xmlhttp = new XMLHttpRequest();
                    }
                }
                xmlhttp.onreadystatechange = go2;
                xmlhttp.open("POST", "./StudentMessages?username=" +username , true);
                xmlhttp.send();
            }

            function go2()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    document.getElementById("messagetable").innerHTML
                            = xmlhttp.responseText;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
               
        <%
            int count=0;
            String username=(String)session.getAttribute("studentname");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select count(*) as count from message where studentid in(select id from student where username='"+username+"')");
            if(rs.next())
            {
               count= rs.getInt("count");
            }
                
            
         %>
         <h1>Welcome <%=username%></h1>
          <%@include file="1.html" %>
         <table id="messagetable">
         </table>
         
         
         <%
         String msg = request.getParameter("msg");
         if(msg!=null)
         {
             %>
             <script>
                 alert("<%=msg%>");
             </script>
             <%
         }
         %>
         </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
