<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>View Pending Request</title>
       
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <%
            
           
           Class.forName("com.mysql.jdbc.Driver");
           System.out.println("Driver loaded successfully");
           Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema","root","rahul");
           System.out.println("connection build");
           Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
           System.out.println("statement created");
           ResultSet rs=stmt.executeQuery("select * from company where status = 'false'");
           System.out.println("result set created");
        %>
           <table border="1">
               <tr>
                    <th>
                        Name of Company
                    </th> 
                    <th>
                        Logo
                    </th> 
                    <th>
                        View Pending Request
                    </th> 
                    <th>
                        Approve Request
                    </th> 
                    <th>
                        Delete Request
                    </th> 
               </tr>
               <%
                while(rs.next())
                {
                    String name = rs.getString("name");
                    String logo = rs.getString("imageurl");
                    int id=rs.getInt("id");
                    %>
                    <tr>
                        <td>
                            <%=name%>
                        </td>
                        <td>
                            <img src="<%=logo%>" width="100" height="100"/>
                        </td>
                        <td><a href="ViewRequestDetail.jsp?id=<%=id%>">View Pending Request Details</a>
                        </td>
                        <td>
                       <a href="Approve Request.jsp?id=<%=id%>">Approve Request

                        </td>
                         <td>
                       <a href="Delete Request.jsp?id=<%=id%>">Delete Request

                        </td>
                    </tr>
                    <%
                    
                }
               %>
           </table>
           </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
