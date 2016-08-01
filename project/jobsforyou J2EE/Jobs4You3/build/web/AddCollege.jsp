<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Add College</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <h4>Select The Name Of University Under Which You Want To Add College:</h4>
        <form action="AddCollege2.jsp" method="Post">
            
            <%String college=request.getParameter("college");
                %>
                <input type="text" name="college_name" value="<%=college%>" readonly/>
        <select name="university">
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from university");
             while(rs.next())
            {
                String options=rs.getString("university");
                int id=rs.getInt("id");
             %>
             <option value="<%=id%>"><%=options%></option>
            <%
            }
             session.setAttribute("index", 0);
            %>
        </select>
        
        <input type="submit" value="Add"/>
        </form>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
