package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Skill extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String skill;
            String skilllevel;
            String experience;
            int userid=Integer.parseInt(request.getParameter("userid"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from skills where user_id=" + userid );
            if(rs.next())
            {
                skill = rs.getString("skill");
                out.println(skill);
                int skill_level=rs.getInt("skill_level");
                int exp=rs.getInt("experience");
                Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from skill_level where id=" + skill_level );
                if(rs1.next())
                {
                    skilllevel=rs1.getString("skill_level");
                    out.println(skilllevel);
                }
                stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs1 = stmt1.executeQuery("select * from experience where id=" + exp );
                if(rs1.next())
                {
                    experience=rs1.getString("experience");
                    out.println(experience);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}