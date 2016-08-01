<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Add Question</title>
    </head>
    <body>
        <%
            String question = request.getParameter("question");
            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String c = request.getParameter("c");
            String d = request.getParameter("d");
            String answer = request.getParameter("answer");
            int category = Integer.parseInt(request.getParameter("category"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from questions");
            rs.moveToInsertRow();
            rs.updateString("question",question);
            rs.updateString("a",a);
            rs.updateString("c",c);
            rs.updateString("d",d);
            rs.updateString("b",b);
            rs.updateString("answer",answer);
            rs.updateInt("category",category);
            rs.insertRow();
            response.sendRedirect("AdminHome.jsp?msg=Question Added Successfully !");
        %>
    </body>
</html>
