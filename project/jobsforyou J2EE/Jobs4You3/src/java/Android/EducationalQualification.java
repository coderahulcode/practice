package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EducationalQualification extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String tenth="";
            String twelveth="";
            String degree="";
            String stream="";
            String degreemarks="";
            String college="";
            String university="";
            int uid=0;
            int cid=0;
            System.out.println("aaaa");
            int userid=Integer.parseInt(request.getParameter("userid"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "system");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from educational_qualification where user_id=" + userid );
            if(rs.next())
            {
                tenth=rs.getString("ssc");
                twelveth=rs.getString("hsc");
                degree=rs.getString("degree");
                stream=rs.getString("stream");
                degreemarks=rs.getDouble("marks")+"";
                cid=rs.getInt("college");
                uid=rs.getInt("university");
                System.out.println("ascsdf");
            }
            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "system");
            Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery("select * from university where id=" + uid );
            if(rs1.next())
            {
                university=rs1.getString("university");
            }
            stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt1.executeQuery("select * from college where id=" + cid );
            if(rs2.next())
            {
                college=rs2.getString("college_name");
            }
            out.println(tenth);
            out.println(twelveth);
            out.println(degree);
            out.println(stream);
            out.println(degreemarks);
            out.println(university);
            out.println(college);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}