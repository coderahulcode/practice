package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSignup6 extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            
            String jobtype = request.getParameter("jobtype");
            String extra = request.getParameter("extra");
            int locid = Integer.parseInt(request.getParameter("location"));
            int rangeid = Integer.parseInt(request.getParameter("range"));
            int user_id = Integer.parseInt(request.getParameter("id"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from other_information");
            rs.moveToInsertRow();
            rs.updateString("prefered_job_type", jobtype);
            rs.updateInt("prefered_job_location", locid);
            rs.updateInt("expected_salary_range", rangeid);
            rs.updateString("extra", extra);
            rs.updateInt("user_id", user_id);
            rs.insertRow();
            out.println("Success");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
