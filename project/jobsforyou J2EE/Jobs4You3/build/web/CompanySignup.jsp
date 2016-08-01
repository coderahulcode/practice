<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Company Signup</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
         <div id="main" class="recruiter">
        <form action="CompanySignup2.jsp" method="post">
            <center>
                <table border="1" style="margin-top: 10px">
                <tr>
                    <td> Company Name </td>
                    <td> <input type="text" name="companyname" required/> </td>
                </tr>
                <tr>
                    <td> Username </td>
                    <td> <input type="text" name="username" required/> </td>
                </tr>
                <tr>
                    <td> Email ID </td>
                    <td> <input type="email" name="email" required/> </td>
                </tr>
                <tr>
                    <td> Contact No. </td>
                    <td> <input type="text" name="number" required/> </td>
                </tr>
                <tr>
                    <td> Location </td>
                    <td> <input type="text" name="location" required/> </td>
                </tr>
                <tr>
                    <td> Address </td>
                    <td> <input type="text" name="address" required/> </td>
                </tr>
                <tr>
                    <td> Turnover </td>
                    <td> <input type="text" name="turnover" required/> </td>
                </tr>
                <tr>
                    <td> Description </td>
                    <td> <textarea name="description" placeholder="Description about the company"></textarea> </td>
                </tr>
                <tr>
                    <td>Type of Package</td>
                    <td><select name="option" >
                            <%
                                String name="";
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs = stmt.executeQuery("select * from package");
                                while (rs.next())
                                {
                                    name = rs.getString("name");
                            %>
                            <option name="<%=name%>"><%=name%></option>
                            <%
                                }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Signup"/></td>
                </tr>
            </table>
            </center>
        </form>
        <%
            String msg = (String) request.getParameter("msg");
            if(msg!=null)
            {
                %>
                    <div style="color: red "><label>*<%=msg%></label> </div>
                <%
            }
        %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
