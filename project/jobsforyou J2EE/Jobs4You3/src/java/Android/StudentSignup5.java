package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSignup5 extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String company = request.getParameter("company");
            if(company.equals("null"))
            {
                int user_id = Integer.parseInt(request.getParameter("id"));
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from work_experience");
                rs.moveToInsertRow();
                rs.updateString("role", "fresher");
                rs.updateString("company", null);
                rs.updateDouble("package", 0.0);
                rs.updateInt("user_id", user_id);
                rs.insertRow();
                out.println("Success");
            }
            else
            {
                String role = request.getParameter("role");
                double pack = Double.parseDouble(request.getParameter("package"));
                int fyr = Integer.parseInt(request.getParameter("fyr"));
                int fmth = Integer.parseInt(request.getParameter("fmth"));
                int fday = Integer.parseInt(request.getParameter("fday"));
                int tyr = Integer.parseInt(request.getParameter("tyr"));
                int tmth = Integer.parseInt(request.getParameter("tmth"));
                int tday = Integer.parseInt(request.getParameter("tday"));
                int user_id = Integer.parseInt(request.getParameter("id"));
                Date from = new Date(fyr-1900,fmth-1,fday);
                Date to = new Date(tyr-1900,tmth-1,tday);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from work_experience");
                rs.moveToInsertRow();
                rs.updateString("role", role);
                rs.updateString("company", company);
                rs.updateDouble("package", pack);
                rs.updateInt("user_id", user_id);
                rs.updateDate("from_date", from);
                rs.updateDate("end_date", to);
                rs.insertRow();
                out.println("Success");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
