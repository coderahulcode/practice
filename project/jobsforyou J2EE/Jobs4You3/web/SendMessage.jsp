<%@page import="java.sql.*"%>
<%@page import="vmm.SimpleMailDemo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Send Message</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%
            String check[] = request.getParameterValues("check");
            String message = request.getParameter("message");
            int cid = (Integer)request.getAttribute("id");
            int pid =Integer.parseInt(request.getParameter("pid"));
            ArrayList<String> al = (ArrayList) session.getAttribute("allstudents");
            for (int i = 0; i < check.length; i++)
            {
                int pos = Integer.parseInt(check[i]);
                String s = al.get(pos);
                String arr[] = s.split(",");
                int id = Integer.parseInt(arr[2]);
                System.out.println(arr[0]+","+arr[1]+","+arr[2]);
                new SimpleMailDemo(arr[1],"Message From Jobs4You",message);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from message");
                rs.moveToInsertRow();
                rs.updateString("message", message);
                rs.updateInt("studentid", id);
                rs.updateInt("pid", pid);
                rs.insertRow();
            }
            session.removeAttribute("allstudents");
            response.sendRedirect("CompanyHome.jsp");
        %>
       </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
