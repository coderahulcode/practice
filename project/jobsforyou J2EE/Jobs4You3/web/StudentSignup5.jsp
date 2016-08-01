<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Educational Details</title>
        <script>
            var xmlhttp;

            function go()
            {
                var a = document.getElementById("check").checked;
                if (a)
                {
                    document.getElementById("select").disabled = true;
                    document.getElementById("other").readOnly = false;
                }
                else
                {
                    document.getElementById("select").disabled = false;
                    document.getElementById("other").readOnly = true;
                }
            }
            function go1(id)
            {
                try
                {
                    xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e)
                {
                    try
                    {
                        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e2)
                    {
                        xmlhttp = new XMLHttpRequest();
                    }
                }
                xmlhttp.onreadystatechange = go2;
                xmlhttp.open("POST", "./GetColleges?name=" + id, true);
                xmlhttp.send();
            }
            function go2()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    document.getElementById("college").innerHTML
                            = xmlhttp.responseText;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header2.jsp" %>
             
            <div id="main" class="studentlogin">
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from degree");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from marks_type");
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt2.executeQuery("select * from university");

        %>
        <form action="StudentSignup6.jsp" method="post" >
            <center> <table border="1">
                <tr>
                    <td>10th(in %)</td>
                    <td><input type="text" name = "ssc"/></td>
                </tr>
                <tr>
                    <td>12th(in %)</td>
                    <td><input type="text" name = "hsc"/></td>
                </tr>
                <tr>
                    <td>Degree</td>
                    <td>
                        <select  name="degree" id="select">
                            <%                                
                                while (rs.next())
                                {
                                    String degree = rs.getString("degree");
                                    int iddegree = rs.getInt("id");
                            %>
                            <option value="<%=iddegree%>"><%=degree%></option>
                            <%
                                }
                            %>
                        </select></td>


                </tr>
                <tr>
                    <td>Any Other Degree</td>
                    <td> <input type="checkbox" id="check" onchange="go()" /> </td>
                </tr>
                <tr>
                    <td>Other Degree</td>
                    <td> <input type="text" name="otherdegree" id="other" readonly /> </td>
                </tr>
                <tr>
                    <td>Year of Passing</td>
                    <td> <select name="year">
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
                <tr>
                    <td> Stream </td>
                    <td> <input type="text" name="stream"  required/> </td>
                </tr>
                <tr>
                    <td> Marks type </td>
                    <td>
                        <select name="markstype">
                            <%
                                while (rs1.next())
                                {
                                    String marks_type = rs1.getString("marks_type");
                                    int idmarks = rs1.getInt("id");
                            %>
                            <option value="<%=idmarks%>"><%=marks_type%></option>
                            <%
                                }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td> Marks </td>
                    <td> 
                        <input type="text" name="marks" required />
                    </td>
                </tr>

                <tr>
                    <td> University </td>
                    <td> <select name="university" onchange="go1(this.value)" >  
                            <%
                                while (rs2.next())
                                {
                                    String university = rs2.getString("university");
                                    int id = rs2.getInt("id");

                            %>
                            <option value="<%= id%>"> <%= university%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> College </td>
                    <td> <select id="college"  name="coll" required></select>   
                    </td>
                </tr>
                <tr>
                    <td> Extra Information </td>
                    <td> <textarea name="extra" maxlength="90"></textarea> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save And Continue"/></td>
                    <td></td>
                </tr>
                </table></center>
        </form>
                        </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
