<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Skills Information</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main" class="studentlogin">
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from skill_level");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from experience");
        %>
        <center><h1> Skills </h1></center>
        <form action="StudentSignup8.jsp" method="post">
                        <center> <table border="1">

                <tr>
                    <td> Skills </td>
                    <td> <input type="text" name="skill" required/> </td>
                </tr>
                <tr>
                    <td> Skill Level </td>
                    <td> <select name="level">
                            <%
                                while(rs.next())
                                {
                                    String level = rs.getString("skill_level");
                                    int id = rs.getInt("id");
                                    %>
                                    <option value="<%=id%>"><%=level%></option>
                                    <%
                                    
                                }
                            %>
                        </select> </td>
                </tr>
                <tr>
                    <td> Experience </td>
                    <td> <select name="experience">
                            <%
                                while(rs1.next())
                                {
                                    String experience = rs1.getString("experience");
                                    int id = rs1.getInt("id");
                                    %>
                                    <option value="<%=id%>"><%=experience%></option>
                                    <%

                                }
                            %>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save and Continue"/></td>
                </tr>
                            </table></center>
        </form>
                        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>