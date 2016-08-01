
<%@page import="vmm.SimpleMailDemo"%>
<%@page import="java.sql.*"%>
<%@page import="abc.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
        <link href="./All.css" type="text/css" rel="stylesheet"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Selection</title>
    </head>
    <body>
        <div id="all">
            <%@include file="Header3.jsp" %>
             
            <div id="main">
        <%
            String check[] =(String []) session.getAttribute("check");
            ArrayList<Student> al = (ArrayList) session.getAttribute("studentdata");
            String desc = "abc";//session
            int companyid = (Integer)session.getAttribute("id");
            int pid=0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);            
            String values="\'"+desc+"\',"+companyid;
            String allcolumns="description,company";
            String insert="insert into placementdrive("+allcolumns+") values("+values+")";
            stmt.execute(insert,Statement.RETURN_GENERATED_KEYS);
            ResultSet keyset=stmt.getGeneratedKeys();
            if(keyset.next())
            {
                pid=keyset.getInt(1);
            }
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt2.executeQuery("select * from  shortlisted_students");
            for (int i = 0; i < check.length; i++)
            {
                int pos = Integer.parseInt(check[i]);
                Student s = al.get(pos);
                int studentid = s.id;
                rs2.moveToInsertRow();
                rs2.updateInt("studentid", studentid);
                rs2.updateInt("pid", pid);
                rs2.insertRow();
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select email from personal_information where user_id="+studentid);
                if(rs1.next())
                {
                    String email = rs1.getString("email");
                    new SimpleMailDemo(email,"Placement Drive","Congrats, you have been selected for placement drive");
                }
            }
            response.sendRedirect("CompanyHome.jsp");
        %>
        </div>
            <%@include file="Footer.jsp" %>
        </div>

    </body>
</html>
