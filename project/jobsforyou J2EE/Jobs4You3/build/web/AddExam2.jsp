<%@page import="java.sql.*"%>
<%@page import="vmm.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Add Exam</title>
    </head>
    <body>
        <%
            String title = request.getParameter("title");
            String desc = request.getParameter("desc");
            int c_id = Integer.parseInt(request.getParameter("c_id"));
            int year = Integer.parseInt(request.getParameter("year"));
            try
            {
                String absolutepath = getServletContext()
                        .getRealPath("/Uploads/Papers/");
                String filename = vmm.FileUploader
                        .savefile(request, absolutepath);
                String relativepath = "./Uploads/Papers/" + filename;

        %>
        <p>Absolute path : <%=absolutepath%></p>
        <hr>
        <p>Relative path of file : <%=relativepath%></p>
        <h3>File Uploaded Successfully = <%=filename%></h3>
        <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from papers");
                rs.moveToInsertRow();
                rs.updateString("title",title);
                rs.updateString("description",desc);
                rs.updateString("path",relativepath);
                rs.updateInt("year",year);
                rs.updateInt("company",c_id);
                rs.insertRow();
                response.sendRedirect("AdminHome.jsp?msg=Paper Added Successfully !");
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }
        %>
    </body>
</html>
