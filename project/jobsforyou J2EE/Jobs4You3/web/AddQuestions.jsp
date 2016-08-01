<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Add Questions</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <%
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
        %>
        <form action="AddQuestions2.jsp" method="post">
            <table border="1">
                <tr>
                    <td> Question </td>
                    <td> <input type="text" name="question" required/> </td>
                </tr>
                <tr>
                    <td>A</td>
                    <td><input type="text" name="a" required/></td>
                </tr>
                <tr>
                    <td>B</td>
                    <td><input type="text" name="b" required/></td>
                </tr>
                <tr>
                    <td>C</td>
                    <td><input type="text" name="c" required/></td>
                </tr>
                <tr>
                    <td>D</td>
                    <td><input type="text" name="d" required/></td>
                </tr>
                <tr>
                    <td>Answer</td>
                    <td><input type="text" name="answer" required/></td>
                </tr>
                <tr>
                    <td>Category</td>
                    <td><select name="category">
                                    <%
                                        Class.forName("com.mysql.jdbc.Driver");
                                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                                        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                        ResultSet rs = stmt.executeQuery("select * from category");
                                        while(rs.next())
                                        {
                                            String name = rs.getString("category");
                                            int id = rs.getInt("id");
                                            %>
                                            <option value="<%=id%>"><%=name%></option>
                                            <%
                                        }
                                    %>
                        </select></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Question"/></td>
                </tr>
            </table>
        </form>
                        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
