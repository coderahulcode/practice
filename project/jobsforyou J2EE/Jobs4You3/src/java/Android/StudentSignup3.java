package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSignup3 extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            double ssc =Double.parseDouble(request.getParameter("ssc"));
            double hsc =Double.parseDouble(request.getParameter("hsc"));
            double marks =Double.parseDouble(request.getParameter("marks"));
            String otherdegree = request.getParameter("otherdegree");
            String stream = request.getParameter("stream");
            String extra = request.getParameter("extra");
            int markstype = Integer.parseInt(request.getParameter("markstype"));
            int year = Integer.parseInt(request.getParameter("year"));
            int degree = Integer.parseInt(request.getParameter("degree"));
            int university = Integer.parseInt(request.getParameter("university"));
            int college = Integer.parseInt(request.getParameter("college"));
            int user_id = Integer.parseInt(request.getParameter("userid"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from educational_qualification");
            rs.moveToInsertRow();
            rs.updateDouble("ssc", ssc);
            rs.updateDouble("hsc", hsc);
            rs.updateDouble("marks", marks);
            rs.updateString("other_degree", otherdegree);
            rs.updateString("stream", stream);
            rs.updateString("extra", extra);
            rs.updateInt("marks_type", markstype);
            rs.updateInt("year_of_passing", year);
            rs.updateInt("degree", degree);
            rs.updateInt("university", university);
            rs.updateInt("college", college);
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
