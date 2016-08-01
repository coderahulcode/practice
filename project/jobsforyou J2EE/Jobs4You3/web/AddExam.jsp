<%-- 
    Document   : AddExam
    Created on : 18 Apr, 2014, 12:33:30 PM
    Author     : Mahajan
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Exam</title>
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <script>
            function go()
            {
                var title=document.getElementById("title").value;
                var desc=document.getElementById("desc").value;
                var year=document.getElementById("year").value;
                var company=document.getElementById("company").value;
                document.getElementById("paperform").action="AddExam2.jsp?title="+title+"&desc="+desc+"&year="+year+"&c_id="+company;
                return true;
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header5.jsp" %>
             
            <div id="main">
        <form id="paperform" enctype="multipart/form-data" method="post" action="">
        <table>
            <tr><td>Exam Title</td><td><input type="text" id="title" placeholder="Exam title"/></td></tr>
            <tr><td>Description</td><td><input type="text" id="desc" placeholder="Description"/></td></tr>
            <tr><td>Year of the paper</td>
                <td><select id="year">
                            <option 	value=	"1980"	>	1980	</option>
                            <option 	value=	"1981"	>	1981	</option>
                            <option 	value=	"1982"	>	1982	</option>
                            <option 	value=	"1983"	>	1983	</option>
                            <option 	value=	"1984"	>	1984	</option>
                            <option 	value=	"1985"	>	1985	</option>
                            <option 	value=	"1986"	>	1986	</option>
                            <option 	value=	"1987"	>	1987	</option>
                            <option 	value=	"1988"	>	1988	</option>
                            <option 	value=	"1989"	>	1989	</option>
                            <option 	value=	"1990"	>	1990	</option>
                            <option 	value=	"1991"	>	1991	</option>
                            <option 	value=	"1992"	>	1992	</option>
                            <option 	value=	"1993"	>	1993	</option>
                            <option 	value=	"1994"	>	1994	</option>
                            <option 	value=	"1995"	>	1995	</option>
                            <option 	value=	"1996"	>	1996	</option>
                            <option 	value=	"1997"	>	1997	</option>
                            <option 	value=	"1998"	>	1998	</option>
                            <option 	value=	"1999"	>	1999	</option>
                            <option 	value=	"2000"	>	2000	</option>
                            <option 	value=	"2001"	>	2001	</option>
                            <option 	value=	"2002"	>	2002	</option>
                            <option 	value=	"2003"	>	2003	</option>
                            <option 	value=	"2004"	>	2004	</option>
                            <option 	value=	"2005"	>	2005	</option>
                            <option 	value=	"2006"	>	2006	</option>
                            <option 	value=	"2007"	>	2007	</option>
                            <option 	value=	"2008"	>	2008	</option>
                            <option 	value=	"2009"	>	2009	</option>
                            <option 	value=	"2010"	>	2010	</option>
                            <option 	value=	"2011"	>	2011	</option>
                            <option 	value=	"2012"	>	2012	</option>
                            <option 	value=	"2013"	>	2013	</option>
                            <option 	value=	"2014"	>	2014	</option>


                        </select> </td>
                </tr>
                <tr><td>Company</td><td><select id="company">
                <%  
                    String company; 
                    int c_id;
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs = stmt.executeQuery("select * from all_companies");
                    while(rs.next())
                    {
                        company=rs.getString("name");
                        c_id=rs.getInt("id");
                    
                %>
                <option value="<%=c_id%>"><%=company%></option>
                <%
                    }
                %>
                        </select></td></tr>
                <tr><td>Upload Paper</td><td><input type="file" name="examfile"/></td></tr>
                <tr><td></td><td><input type="submit" value="Add" onclick=" return go();"/></td></tr>
        </table>
    </form>
                        </div>
            <%@include file="Footer.jsp" %>
        </div>

        
    </body>
</html>
