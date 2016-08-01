<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>All Students</title>
        <script>
            
            function go()
            {
                if(document.getElementById("check").checked)
                {
                    var a = document.getElementsByClassName("box");
                    for(var i=0;i<a.length;i++)
                    {
                        a[i].style.display = "block";
                    }
                }
                else
                {
                    var a = document.getElementsByClassName("box");
                    for(var i=0;i<a.length;i++)
                    {
                        a[i].style.display = "none";
                    }
                }
            }
        </script>

    </head>
    <%
        int sno = 0;
        String name;
        String email;
        int id=0;
    %>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%            
            ArrayList<String> al = new ArrayList<String>();
            int pid = Integer.parseInt(request.getParameter("pid"));
        %>
        <h3><input type="checkbox" id="check" onchange="go(<%=sno%>)"/>Kindly Select to Proceed</h3>
        <form action="SendMessage.jsp?pid=<%=pid%>" method="post">
            
            
            <table class="CSSTableGenerator">
                <tr>
                    <td>S. No.</td>
                    <td>Name</td>
                    <td>E-Mail</td>
                    <td></td>
                </tr>
                <%
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from personal_information where user_id in(select studentid from shortlisted_students where pid=" + pid+")");
                    while (rs.next())
                    {
                        name = rs.getString("first_name")+" "+rs.getString("middle_name")+" "+rs.getString("last_name");
                        email = rs.getString("email");
                        id = rs.getInt("user_id");
                        al.add(name + "," + email+","+id);
                %>
                <tr><td><%=++sno%></td><td><%=name%></td><td><%=email%></td><td><div class="box" style="display: none"><input type="checkbox"  value="<%=(sno - 1)%>" name="check"/></div></td></tr>
                            <%
                                }
                                session.setAttribute("allstudents", al);
                            %>
            </table>
            <textarea  name="message" placeholder="Message"></textarea>
                <input type="submit" value="Send Message " style="background-color: #4c4c4c;color:#f1f1f1"/>
        </form>
            </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
