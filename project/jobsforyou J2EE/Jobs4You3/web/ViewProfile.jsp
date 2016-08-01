

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Profile</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header4.jsp" %>
             
            <div id="main">
        
        <%
            int id=(Integer)(session.getAttribute("id"));
            String photo="";
            String name="";
            String email="";
            double hsc=0;
            double ssc=0;
            double pack=0;
            double degreemarks=0;
            int markstypeid=0;
            int collegeid=0;
            String markstype="";
            String degree="";
            String college="";
            String university="";
            int universityid=0;
            String skills="";
            String experience;
            String stream="";
            int degreeid=0;
            String mobileno="";
            String role="";
            String company="";
            String fromdate="";
            String enddate="";
            String extra="";
            boolean flag =true;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "system");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from personal_information where user_id="+id);
            if(rs.next())
            {
               photo=rs.getString("photo");
               name=rs.getString("first_name")+" "+rs.getString("middle_name")+" "+rs.getString("last_name");
               email=rs.getString("email");
               mobileno=rs.getString("mobile_no");
               
            }
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from educational_qualification where user_id="+id);
            if(rs1.next())
            {
               hsc=rs1.getDouble("hsc");
               ssc=rs1.getDouble("ssc");
               stream=rs1.getString("stream");
               markstypeid=rs1.getInt("marks_type");
               collegeid=rs1.getInt("college");
               universityid=rs1.getInt("university");
               degreeid=rs1.getInt("degree");
               extra=rs1.getString("extra");
               degreemarks = rs1.getDouble("marks");
            }
            Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "system");
            Statement stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt2.executeQuery("select * from college where id="+collegeid);
            if(rs2.next())
            {
                college=rs2.getString("college_name");
            }
            rs2 = stmt2.executeQuery("select * from university where id="+universityid); 
            if(rs2.next())
            {
                university=rs2.getString("university");
            }
            rs2 = stmt2.executeQuery("select * from marks_type where id="+markstypeid); 
            if(rs2.next())
            {
                markstype=rs2.getString("marks_type");
            }
            
            rs2 = stmt2.executeQuery("select * from degree where id="+degreeid); 
            if(rs2.next())
            {
                degree=rs2.getString("degree");
            }
            rs1 = stmt1.executeQuery("select * from skills where user_id="+id);
            if(rs1.next())
            {
               skills=rs1.getString("skill");
            }
            rs1 = stmt1.executeQuery("select * from work_experience where user_id="+id);
            if(rs1.next())
            {
               role=rs1.getString("role");
               
               if(role.equals("fresher"))
               {
                  flag=false; 
               }
               else
               {
                    company=rs1.getString("company");
                    fromdate=rs1.getString("from_date");
                    enddate=rs1.getString("end_date");
                    pack =rs1.getDouble("package");
                    
               }
            }
            
       %>
     
       <table class="CSSTableGenerator"border="1">
           <tr>
               <td>
               <img src="<%=photo%>" width="150" height="150" style="" alt="<%=name%> Logo"/>
               </td>
               <td>
                   <%=name%>
                   <br>
                   <%=email%>
               </td>
                  
           </tr>
           <tr>
               <td>University</td>
               <td>
                   <%=university%>
               </td>
           </tr>
           <tr>
               <td>College</td>
               <td>
                   <%=college%>
               </td>
           </tr>
           <tr>
               <td>Stream</td>
               <td>
                   <%=stream%>
               </td>
           </tr>
           <tr>
               <td>Degree</td>
               <td>
                   <%=degree%>
               </td>
           </tr>
           <tr>
               <td>Degree marks</td>
               <td>
                   <%=degreemarks%>
                   <%=markstype%>
               </td>
           </tr>
           <tr>
               <td>10 th marks</td>
               <td>
                   <%=ssc%>
               </td>
           </tr>
           <tr>
               <td>12 th marks</td>
               <td>
                   <%=hsc%>
               </td>
           </tr>
           <tr>
               <td>Skills</td>
               <td>
                   <%=skills%>
               </td>
           </tr>
           <%
           if(flag==true)
           {
           %>
           <tr>
               <td>Experience</td>
               <td>-----------------------------------------------------
               </td>
           </tr>
           <tr>
               <td>Company</td>
               <td><%=company%>
               </td>
           </tr>
           <tr>
               <td>Role in company</td>
               <td>
                   <%=role%>
               </td>
           </tr>
           <tr>
               <td>From Date</td>
               <td>
                   <%=fromdate%>
               </td>
           </tr>
           <tr>
               <td>End Date</td>
               <td>
                   <%=enddate%>
               </td>
           </tr>
           <tr>
               <td>Current Salary</td>
               <td>
                   <%=pack%>
               </td>
           </tr>
           <%
           }
           else
           {
           %>
               <tr>
               <td>Experience</td>
               <td>Fresher
               </td>
           </tr>
           <%
           }
               
           %>
           <tr>
               <td>Extra Information</td>
               <td>
                   <%=extra%>
               </td>
           </tr>
       </table>
       
         </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
