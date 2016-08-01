package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkExperience extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String company;
            String role;
            double pack;
            Date fromdate;
            Date enddate;
            int userid=Integer.parseInt(request.getParameter("userid"));
            System.out.println("*/************");
            System.out.println(userid);
            System.out.println("****************");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from work_experience where user_id=" + userid );
            if(rs.next())
            {
                company = rs.getString("company");
                role = rs.getString("role");
                pack = rs.getDouble("package");
                fromdate = rs.getDate("from_date");
                enddate = rs.getDate("end_date");
                out.println(company);
                out.println(role);
                out.println(fromdate);
                out.println(enddate);
                out.println(pack);
                System.out.println(company+" "+role+" "+fromdate+" "+enddate+" "+pack);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}