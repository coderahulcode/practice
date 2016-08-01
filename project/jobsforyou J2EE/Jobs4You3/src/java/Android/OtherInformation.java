package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherInformation extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String jobtype;
            String jobloc;
            String salaryrange;
            String extra;
            int userid=Integer.parseInt(request.getParameter("userid"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from other_information where user_id=" + userid );
            if(rs.next())
            {
                jobtype = rs.getString("prefered_job_type");
                out.println(jobtype);
                extra = rs.getString("extra");
                int sal = rs.getInt("expected_salary_range");
                int loc = rs.getInt("prefered_job_location");
                Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from state where id=" + loc );
                if(rs1.next())
                {
                    jobloc = rs1.getString("statename");
                    out.println(jobloc);
                }
                stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs1 = stmt1.executeQuery("select * from salary_range where id=" + sal );
                if(rs1.next())
                {
                    salaryrange = rs1.getString("salary_range");
                    out.println(salaryrange);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}