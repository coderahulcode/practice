<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Exam</title>
        <script>
            var xmlhttp;
            var id=0;
            function go1()
            {
                sessionStorage.timer=600000;
                id=document.getElementById("category").value;
                go();
            }
            function go()
            {
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
                xmlhttp.open("Get", "./CreateExam?category=" + id+"&src=web", true);
                xmlhttp.send();
            }

            function go2()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    window.location.href="NewExam2.jsp";
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main" class="studentlogin">
                <table class="CSSTableGenerator">
                    <tr>
                        <td>
        <select id="category">
            <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from category ");
            while(rs.next())
            {
                String options=rs.getString("category");
                int id=rs.getInt("id");
             %>
             <option value="<%=id%>"><%=options%></option>
            <%
            }
             session.setAttribute("index", 0);
            %>
        </select></td>
        
            
        <td><input type="button" value="Create Exam" onclick="go1()" /></td></tr>
        </table>
                
</div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
