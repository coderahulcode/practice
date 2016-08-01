
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <title>Student Login</title>
    </head>
    <body>
        <%
            int degree = Integer.parseInt(request.getParameter("degree"));
            String otherdegree = request.getParameter("otherdegree");
            int year = Integer.parseInt(request.getParameter("year"));
            String stream = request.getParameter("stream");
            double ssc = Double.parseDouble(request.getParameter("ssc"));
            double hsc = Double.parseDouble(request.getParameter("hsc"));
            int  markstype = Integer.parseInt(request.getParameter("markstype"));
            double marks = Double.parseDouble(request.getParameter("marks"));
            int university =Integer.parseInt( request.getParameter("university"));
            int college = Integer.parseInt(request.getParameter("coll"));
            String extra = request.getParameter("extra");
            int id = (Integer)session.getAttribute("id");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from educational_qualification");
            rs.moveToInsertRow();
            rs.updateInt("user_id",id);
            rs.updateInt("degree",degree);
            rs.updateDouble("ssc",ssc);
            rs.updateDouble("hsc",hsc);
            rs.updateString("other_degree",otherdegree);
            rs.updateInt("year_of_passing",year);
            rs.updateString("stream",stream);
            rs.updateInt("marks_type",markstype);
            rs.updateDouble("marks",marks);
            rs.updateInt("university",university);
            rs.updateInt("college",college);
            rs.updateString("extra",extra);
            rs.insertRow();
            response.sendRedirect("UploadResume.jsp");
        %>
    </body>
</html>
