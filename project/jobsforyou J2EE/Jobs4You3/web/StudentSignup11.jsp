<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Other Information</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main" class="studentlogin">
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from state where countryid='"+"IN"+"'");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from salary_range");
        %>
        <center> <h1> Other Information </h1></center>
        <form action="StudentSignup12.jsp" method="post">
                        <center> <table border="1">

                <tr>
                    <td> Preferred Job Type </td>
                    <td> <input type="text" name="jobtype" required/> </td>
                </tr>
                <tr>
                    <td> Preferred Job Location</td>
                            <td><select name="location">
                                    <%
                                        while(rs.next())
                                        {
                                            String name = rs.getString("statename");
                                            int id = rs.getInt("id");
                                            %>
                                            <option value="<%=id%>"><%=name%></option>
                                            <%
                                        }
                                    %>
                        </select></td>
                </tr>
                <tr>
                    <td> Preferred Salary Range </td>
                    <td><select name="range">
                                    <%
                                        while(rs1.next())
                                        {
                                            String name = rs1.getString("salary_range");
                                            int id = rs1.getInt("id");
                                            %>
                                            <option value="<%=id%>"><%=name%></option>
                                            <%
                                        }
                                    %>
                        </select></td>
                </tr>
                <tr>
                    <td>Extra Information</td>
                    <td><input type="text" name="extra" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
                            </table></center>
        </form>
                        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>