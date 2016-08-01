<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Logo</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header.jsp" %>
             
            <div id="main">
        <%
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
            String companyname = request.getParameter("companyname");
            String description = request.getParameter("desc");
            String address = request.getParameter("address");
            String contact = request.getParameter("number");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String values="\'"+companyname+"\'";
            String allcolumns="name";
            String insert="insert into all_companies("+allcolumns+") values("+values+")";
            stmt.execute(insert,Statement.RETURN_GENERATED_KEYS);
            ResultSet keyset=stmt.getGeneratedKeys();
            int id=0;
            if(keyset.next())
            {
                id=keyset.getInt(1);
            }
            stmt = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company_details");
            rs.moveToInsertRow();
            rs.updateInt("company_id", id);
            rs.updateString("contactno", contact);
            rs.updateString("description", description);
            rs.updateString("address", address);
            rs.insertRow();
            session.setAttribute("cid", id);
        %>
        <h2> Upload Your Logo</h2>
        <form action="AddCompany3.jsp" enctype="multipart/form-data" method="post">
           <input type="file" name="upload"/>
           <br>
           <br>
          <input type="submit" value="Upload"/>
        </form>
        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
