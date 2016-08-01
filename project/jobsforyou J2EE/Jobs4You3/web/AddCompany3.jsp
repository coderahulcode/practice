
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Photo</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main">
        <%@page import="vmm.*" %>
        <%
            try
            {
                String absolutepath = getServletContext()
                        .getRealPath("/Uploads/logos/");
                String filename = vmm.FileUploader
                        .savefile(request, absolutepath);
                String relativepath = "./Uploads/logos/" + filename;
                int id = (Integer)session.getAttribute("cid");
        %>
        <p>Absolute path : <%=absolutepath%></p>
        <hr>
        <p>Relative path of file : <%=relativepath%></p>
        <h3>File Uploaded Successfully = <%=filename%></h3>
        <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from all_companies where id="+id);
                if(rs.next())
                {
                    rs.updateString("logo", relativepath);
                    rs.updateRow();
                    response.sendRedirect("AdminHome.jsp?msg=Company Added Successfully !");
                }
            } 
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>


    </body>
</html>
