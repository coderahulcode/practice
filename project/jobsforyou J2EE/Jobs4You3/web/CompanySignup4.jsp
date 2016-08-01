<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Signup</title>
    </head>
    <body>
        <%@page import="vmm.*" %>
        <%
            String username = (String) session.getAttribute("recruiter");
            try
            {
                //String username = (String) session.getAttribute("recruiter");
                String absolutepath = getServletContext().getRealPath("/Uploads/logos");
                String filename = vmm.FileUploader.savefile(request, absolutepath);
                String relativepath = "./Uploads/logos/" + filename;
       %>
                 <p>Absolute path : <%=absolutepath%></p>
                 <hr>
                 <p>Relative path of file : <%=relativepath%></p>
                 <h3>File Uploaded Successfully = <%=filename%></h3>
                 <%=username%>
                 <h1>Logo uploaded successfully..!!</h1>
                 <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company where username='" + username + "'");
            if (rs.next())
            {
            rs.updateString("imageurl", relativepath);
            rs.updateRow();
            response.sendRedirect("CompanyHome.jsp?msg=Logo Updated Successfully");
        %>
        
        <%
                }
            } catch (Exception ex)
            {
                %>
                <%=username%>
                <%
                ex.printStackTrace();
            }
        %>
    </body>
</html>
