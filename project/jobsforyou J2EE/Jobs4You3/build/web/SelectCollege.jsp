<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Select Colleges</title>
        <script>
            var xmlhttp;
            function go(id,cmpid)
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
                xmlhttp.open("POST", "./RespectiveCollege?name=" + id+"&cmpid="+cmpid, true);
                xmlhttp.send();
            }

            function go2()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    document.getElementById("college").innerHTML
                            = xmlhttp.responseText;
                }
            }
            function go3(companyid)
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
                var clgid = document.getElementById("college").value;
                xmlhttp.onreadystatechange = go4;
                xmlhttp.open("GET", "./RespectiveCollege?id=" + clgid+"&companyid="+companyid, true);
                xmlhttp.send();
            }
            function go4()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                
                    document.getElementById("list").innerHTML
                            = xmlhttp.responseText;
                    document.getElementById("college").innerHTML = "<option>-------</option>"; 
                }
            }
            function go5(clgid,companyid)
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
                xmlhttp.onreadystatechange = go4;
                xmlhttp.open("POST", "./DeleteCollege?id=" + clgid+"&companyid="+companyid, true);
                xmlhttp.send();
            }
            function go6()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    document.getElementById("list").innerHTML
                            = xmlhttp.responseText;
                    document.getElementById("college").innerHTML = "<option>-------</option>"; 
                }
                
                
                
                
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%
            int companyid = (Integer) session.getAttribute("id");
        %>    
        
        <form method="post" action ="RespectiveCollege">
            <table class="CSSTableGenerator">
                <tr>
                    <td>Select University</td>
                    <td>Select College</td>
                </tr>
                    
                <tr>
                    <td>Select University</td>
                    <td><select onchange="go(this.value,<%=companyid%>)">
                            <%
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs = stmt.executeQuery("select * from university");
                                while (rs.next())
                                {
                                    String name = rs.getString("university");
                                    int id = rs.getInt("id");
                            %>
                            <option value="<%=id%>"><%=name%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Select College</td>
                    <td>
                        <select name="collegename" id="college" required>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="button" value="Add" onclick="go3(<%=companyid%>)" /></td>
                </tr>
            </table>
                <center><h1>My Associated Colleges</h1></center>
                    
        </form>
                <table id="list" class="CSSTableGenerator">
                    <tr>
                        
            <td>S. No</td><td>College Name</td><td>Options</td>
                    </tr>
            <%
                int i=1;
                
                Connection con4 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                Statement stmt4 = con4.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs4 = stmt4.executeQuery("select * from company_selection where company="+companyid);
                while(rs4.next())
                {
                    int clg = rs4.getInt("college");
                    Connection con5 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                    Statement stmt5 = con5.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs5 = stmt5.executeQuery("select * from college where id=" + clg);
                    if (rs5.next())
                    {
                        String name = rs5.getString("college_name");
                    %>
                    <tr>
                        <td><%=i++ %></td>
                        <td><%=name %></td>
                        <td><input type="button" value="Delete" onclick="go5(<%=clg%>,<%=companyid%>)"/></td>
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
