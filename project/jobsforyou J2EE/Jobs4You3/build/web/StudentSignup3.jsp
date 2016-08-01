<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <title>Personal Information</title>
        <script>
            function gocountry(country)
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
                xmlhttp.onreadystatechange = gocountry2;
                xmlhttp.open("POST", "./CountryState?country=" + country, true);
                xmlhttp.send();
            }

            function gocountry2()
            {
                alert(xmlhttp.responseText);
                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
                {
                    document.getElementById("state").innerHTML
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
            String email = (String) session.getAttribute("email");
            String no = (String) session.getAttribute("no");
            session.setAttribute("email", null);
            session.setAttribute("no", null);
        %>
        <form action="StudentSignup4.jsp" method="post">
            <center><table>
                <tr>
                    <td> First Name </td>
                    <td> Middle Name </td>
                    <td> Last Name </td>
                </tr>
                <tr>
                    <td> <input type="text" name="firstname" required/> </td>
                    <td> <input type="text" name="middlename" /> </td>
                    <td> <input type="text" name="lastname" required/> </td>
                </tr>
                <tr>
                    <td>E-mail </td>
                    <td> <input type="text" value="<%=email%>" disabled /> </td>
                </tr>
                <tr>
                    <td>Secondary E-mail </td>
                    <td> <input type="email" name="secemail"  /> </td>
                </tr>
                <tr>
                    <td> Contact No.(Mobile) </td>
                    <td> <input type="text" value="<%=no%>"  disabled/> </td>
                </tr>
                <tr>
                    <td> Contact No.(Home) </td>
                    <td> <input type="text" name="homeno" /> </td>
                </tr>
                <tr>
                    <td>Street Name</td>
                    <td><input type="text" name="street"/></td>
                </tr>
                <tr>
                    <td>City</td>
                    <td><input type="text" name="city"/></td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td><select name="country" onchange="gocountry(this.value)">
                            <%
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reference", "root", "rahul");
                                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet rs = stmt.executeQuery("select * from country");
                                while (rs.next())
                                {
                                    String country = rs.getString("name");
                                    String id = rs.getString("id");
                            %>
                            <option value="<%=id%>" ><%=country%></option>
                            <%
                                }
                            %>
                        </select></td>
                </tr>
                <tr>
                    <td>State</td>
                    <td><select id="state" name="state" required></select></td>
                </tr>
                <tr>
                    <td>Pin</td>
                    <td><input type="text" name="pin" required /></td>
                </tr>
                <tr>
                    <td> Gender </td>
                    <td> 
                        <select name="gender">
                            <option value="M">Male</option>
                            <option value="F">Female</option>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td> Nationality </td>
                    <td> <input type="text" name="nationality" /> </td>
                </tr>
                
                <tr>
                    <td></td>
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
