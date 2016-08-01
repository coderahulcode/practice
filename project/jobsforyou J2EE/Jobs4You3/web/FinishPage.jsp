<%-- 
    Document   : FinishPage
    Created on : May 10, 2014, 9:11:39 AM
    Author     : Harpreet
--%>

<%@page import="java.sql.*"%>
<%@page import="abc.Examination"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <script>
            function exit()
            {
                window.location.href="StudentHome.jsp";
            }
            function retake()
            {
            window.location.href = "NewExam.jsp";
            }
         </script>
            <title> Exam result </title>
        </head>
        <body>
            <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main" class="studentlogin">
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from result");
                rs.moveToInsertRow();
            %>
            <center>
            <table border = "1">
                    <th> Question </th>
                    <th> Correct Answer </th>
                    <th> Your Response </th>
                    <th> Correct / Incorrect </th>

            <%
                ArrayList<Examination> paperal = (ArrayList) session.getAttribute("paper");
                int i = 0;
                int result = 0;
                rs.updateInt("category", paperal.get(i).category);
                rs.updateInt("student_id", 1);              //          (Integer)session.getAttribute("id"));  //check name of id given to dtudent in session
                for (i = 0; i < paperal.size(); i++) {
            %>
            <tr>
                    <td> <%=i+1%> </td>
                    <td><%=paperal.get(i).answer%> </td>
            <%
                if (paperal.get(i).useranswer.equals("null")) {
            %>
            <td> Not - answered </td>
            <%
            } else {
            %>
            <td><%=paperal.get(i).useranswer%> </td>
            <%
                }
            %>
            <%
                if ((paperal.get(i).answer.equals(paperal.get(i).useranswer))) 
                {
                    result=result+4;
            %>
            <td style = "background-color: green"> correct </td>
            <%
                } 
                else if((paperal.get(i).useranswer.equals("null"))) 
                {
            %>
            <td style = "background-color: yellow"> Un Attempted </td>
            <%
                }
                else 
                {
                result=result-1;
            %>
            <td style = "background-color: red"> incorrect </td>
            <%
                }
            %>
            </tr>
            <%
                }
                session.setAttribute("paper", null);
                session.setAttribute("index", null);
                rs.updateInt("result", result);
                rs.insertRow();
            %>

            </table>
                    <h2> Your result is:<%=result%>/40 </h2>
                    <input type = "button"  value = "Click to Exit" onclick = "exit()"/>
                    <input type = "button"  value = "Click to Retake Test" onclick = "retake()"/>
            </center>
            </div>
            <%@include file="Footer.jsp" %>
        </div>

                    </body>
                    </html>
