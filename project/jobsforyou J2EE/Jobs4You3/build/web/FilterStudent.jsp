<%@page import="java.util.ArrayList"%>
<%@page import="abc.Student"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Filter Students</title>
        <script>
            var ssc;
            var hsc;
            var degree_type;
            var grad;
            var postgradtype;
            var degreemarks;
            var postdegree;
            var colleges;
            function go()
            {
                if (document.getElementById("tenth").checked)
                {
                    document.getElementById("sscid").style.display = "block";
                }
                else
                {
                    document.getElementById("sscid").style.display = "none";
                    document.getElementById("ssc").value = "0";
                }
                if (document.getElementById("twelveth").checked)
                {
                    document.getElementById("hscid").style.display = "block";
                }
                else
                {
                    document.getElementById("hscid").style.display = "none";
                    document.getElementById("hsc").value = "0";
                }
                if (document.getElementById("degreetype").checked)
                {
                    document.getElementById("type").style.display = "block";
                }
                else
                {
                    document.getElementById("type").style.display = "none";
                    document.getElementById("degree_type").value = "0";
                }
                if (document.getElementById("checkdegree").checked)
                {
                    document.getElementById("degree").style.display = "block";
                }
                else
                {
                    document.getElementById("degree").style.display = "none";
                    document.getElementById("degreemarks").value = "0";
                }
                if (document.getElementById("PostGraduate").checked)
                {
                    document.getElementById("postgraduate").style.display = "block";
                }
                else
                {
                    document.getElementById("postgraduate").style.display = "none";
                    document.getElementById("postdegree").value = "0";
                }
                if (document.getElementById("college").checked)
                {
                    document.getElementById("collegediv").style.display = "block";
                    var coll = document.getElementById("colleges");
                    var i = false;
                    for (var j = 0; j < coll.length; j++)
                    {
                        if (coll[j].selected)
                        {
                            i = true;
                            break;
                        }
                    }
                    
                }
                else
                {
                    document.getElementById("collegediv").style.display = "none";
                }
            }
            function go1()
            {

                if (document.getElementById("tenth").checked)
                {
                    if (document.getElementById("ssc").value === "")
                    {
                        alert("Kindly enter value for 10th");
                    }
                    else
                        ssc = document.getElementById("ssc").value;
                }
                else
                {
                    ssc = 0;
                }
                if (document.getElementById("twelveth").checked)
                {
                    if (document.getElementById("hsc").value === "")
                    {
                        alert("Kindly enter value for 12th");
                    }
                    else
                        hsc = document.getElementById("hsc").value;
                }
                else
                {
                    hsc = 0;
                }
                if (document.getElementById("checkdegree").checked)
                {
                    if (document.getElementById("degreemarks").value === "")
                    {
                        alert("Kindly enter value for Graduate");
                    }
                    else
                    {
                        degreemarks = document.getElementById("degreemarks").value;
                        grad = document.getElementById("grad").value;
                    }
                }
                else
                {
                    degreemarks = 0;
                    grad = 0;
                }
                if (document.getElementById("degreetype").checked)
                {
                    degree_type = document.getElementById("degree_type").value;
                }
                else
                {
                    degree_type = 0;
                }
                if (document.getElementById("PostGraduate").checked)
                {
                    if (document.getElementById("postdegree").value ==="")
                    {
                        alert("Kindly enter value for Post Graduate");
                    }
                    else
                    {
                        postdegree = document.getElementById("postdegree").value;
                        postgradtype = document.getElementById("postgradtype").value;
                    }
                }
                else
                {
                    postdegree = 0;
                    postgradtype = 0;
                }
                if (document.getElementById("college").checked)
                {
                    document.getElementById("collegediv").style.display = "block";
                    var coll = document.getElementById("colleges");
                    var i = false;
                    for (var j = 0; j < coll.length; j++)
                    {
                        if (coll[j].selected)
                        {
                            i = true;
                            break;
                        }
                    }
                    if (!i)
                    {
                        alert("Kindly enter value for Colleges");
                    }
                    else
                    {
                        var coll = document.getElementById("colleges");
                        var i;
                        var collnames = "";
                        for (i = 0; i < coll.length; i++)
                        {
                            if (coll[i].selected)
                            {
                                collnames = collnames + coll[i].value + ",";
                            }
                        }
                        colleges = collnames;
                    }
                }
                else
                {
                    colleges = 0;
                }
                var send =
                        "ssc=" + ssc +
                        "&hsc=" + hsc +
                        "&degree_type=" + degree_type +
                        "&gradtype=" + grad +
                        "&postgradtype=" + postgradtype +
                        "&degreemarks=" + degreemarks +
                        "&postdegreemarks=" + postdegree +
                        "&colleges=" + colleges;
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
                xmlhttp.open("POST", "./FilteringStudent?" + send, true);
                xmlhttp.send();
            }

            function go2()
            {
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    document.getElementById("result").innerHTML
                            = xmlhttp.responseText;
                }
            }
        </script>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%
            int companyid = (Integer)session.getAttribute("id");
        %>
        <center><h1>Filtering Criteria</h1></center>
        <table>
            <tr>
                <td><input type="checkbox" id="tenth" onchange="go()"/></td>
                <td>10th(Percentage) </td>
                <td><div  style="display: none" id="sscid">>=<input type="text" id="ssc"/></div></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="twelveth" onchange="go()"/></td>
                <td>12th(Percentage) </td>
                <td><div style="display: none" id="hscid">>=<input type="text" id="hsc"/></div></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="degreetype" onchange="go()"/></td>
                <td>Degree Type </td>
                <td><div style="display: none" id="type"><select id="degree_type">
                            <%
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs = stmt.executeQuery("select * from degree");
                                while (rs.next())
                                {
                                    String name = rs.getString("degree");
                                    int id = rs.getInt("id");
                            %>
                            <option value="<%=id%>"><%=name%></option>
                            <%
                                }
                            %>    
                        </select></div></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="checkdegree" onchange="go()"/></td>
                <td>Graduation</td>
                <td><div style="display: none" id="degree">>=<select id="grad">
                            <%
                                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs1 = stmt1.executeQuery("select * from marks_type");
                                while (rs1.next())
                                {
                                    String marks_type = rs1.getString("marks_type");
                                    int id = rs1.getInt("id");
                            %>
                            <option value="<%=id%>"><%=marks_type%></option>
                            <%
                                }
                            %>   
                        </select><input type="text" id="degreemarks"/></div></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="PostGraduate" onchange="go()"/></td>
                <td>Post Graduate </td>
                <td><div style="display: none" id="postgraduate">>=<select id="postgradtype">
                            <%
                                Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs2 = stmt2.executeQuery("select * from marks_type");
                                while (rs2.next())
                                {
                                    String marks_type = rs2.getString("marks_type");
                                    int id = rs2.getInt("id");
                            %>
                            <option value="<%=id%>"><%=marks_type%></option>
                            <%
                                }
                            %>   
                        </select><input type="text" id="postdegree"/></div></td>
            </tr>
            <tr>
                <td><input type="checkbox" id="college" onchange="go()"/></td>
                <td>College</td>
                <td><div style="display: none;" id="collegediv"><select  id="colleges" multiple size="5" >
                            <%
                                Statement stmt3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs3 = stmt3.executeQuery("select * from college where id in(select college from myschema.company_selection where company=" + companyid + ")");
                                while (rs3.next())
                                {
                                    String college = rs3.getString("college_name");
                                    int clgid = rs3.getInt("id");
                            %>
                            <option value="<%=clgid%>"><%=college%></option>
                            <%
                                }
                            %>
                            <option></option>
                        </select></div></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="button" value="Search" onclick="go1()"/></td>
                <td></td>
            </tr>
        </table>
        <form action="ShortList.jsp" method="post">
            <table id="result" border="1">
                <tr><th>S. No. </th><th>Name</th><th>Graduation Marks</th><th>Xth Marks</th><th>XIIth Marks</th><th>Skills</th></tr>
                <%
                    if(!(session.getAttribute("studentdata")==null))
                    {
                        ArrayList<Student> al = (ArrayList) session.getAttribute("studentdata");
                        for(int i=0;i<al.size();i++)
                        {
                            Student s = al.get(i);
                            %>
                            <tr>
                                <td><input type="checkbox" name="check" value="<%=i%>"/></td>
                                <td><%=s.name%></td>
                                <td><%=s.graduationmarks%></td>
                                <td><%=s.tenthmarks%></td>
                                <td><%=s.twelvethmarks%></td>
                                <td><%=s.skill%></td>
                            </tr>
                            <%
                        }
                    }
                %>
            </table>
            <input type="submit" value="ShortList"/>
        </form>
            </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
