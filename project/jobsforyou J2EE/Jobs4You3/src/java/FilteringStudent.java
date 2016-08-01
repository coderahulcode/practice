/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import abc.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rishab
 */
public class FilteringStudent extends HttpServlet
{

    ArrayList <Student> al;
    HttpSession session ;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
            al=new ArrayList<Student>();
        try
        {
            session = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String finalcollname;
            double ssc=Double.parseDouble(request.getParameter("ssc"));
            double hsc=Double.parseDouble(request.getParameter("hsc"));
            String finalname = "select * from educational_qualification where ssc>="+ssc+" and hsc>="+hsc;
            int degree_type =Integer.parseInt(request.getParameter("degree_type"));
            if(degree_type==0)
            {
                finalname+=" and degree not in("+degree_type+")";
            }
            else
            {
                finalname+=" and degree="+(degree_type);
            }
            int gradtype =Integer.parseInt(request.getParameter("gradtype"));
            if(gradtype==0)
            {
                //finalname+=" and marks_type not in("+gradtype+")";
            }
            else
            {
                finalname+=" and marks_type="+gradtype;
            }
            int postgradtype =Integer.parseInt(request.getParameter("postgradtype"));
            if(postgradtype==0)
            {
                //finalname+=" and post_marks_type not in("+postgradtype+")";
            }
            else
            {
                finalname+=" and post_marks_type="+postgradtype;
            }
            double gradmarks =Double.parseDouble(request.getParameter("degreemarks"));
            if(gradmarks==0)
            {
                //finalname+=" and post_marks_type not in("+postgradtype+")";
            }
            else
            {
                finalname+=" and marks>="+gradmarks;
            }
            double postgradmarks =Double.parseDouble(request.getParameter("postdegreemarks"));
            if(postgradmarks==0)
            {
                //finalname+=" and post_marks_type not in("+postgradtype+")";
            }
            else
            {
                finalname+=" and post_marks>="+postgradmarks;
            }
            String colleges =request.getParameter("colleges");
            if(colleges.contains("0"))
            {
                finalname+=" and college not in("+colleges+")";
            }
            else
            {
                finalcollname = colleges.substring(0, colleges.length()-1);
                finalname+=" and college in("+finalcollname+")";
            }
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(finalname);
            int i=0;
            out.println("<tr><th> </th><th>Name</th><th>Graduation Marks</th><th>Xth Marks</th><th>XIIth Marks</th><th>Skills</th></tr>");
            
            while (rs.next())
            {
                int userid = rs.getInt("user_id");
                String name="";
                String skills="";
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select first_name from personal_information where user_id="+userid);
                if(rs1.next())
                {
                    name = rs1.getString("first_name");
                }
                Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2 = stmt2.executeQuery("select skill from skills where user_id="+userid);
                if(rs2.next())
                {
                    skills = rs2.getString("skill");
                }
                double marks = rs.getDouble("marks");
                double tenth = rs.getDouble("ssc");
                double twelveth = rs.getDouble("hsc");
                al.add(new Student(userid,name,marks,tenth,twelveth,skills));
                
                out.println("<tr><td><input type=\"checkbox\" name=\"check\" value=\""+i++ +"\"/></td><td>"+name+"</td><td>"+marks+"</td><td>"+tenth+"</td><td>"+twelveth+"</td><td>"+skills+"</td></tr>");
            }
            session.setAttribute("studentdata", al);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
