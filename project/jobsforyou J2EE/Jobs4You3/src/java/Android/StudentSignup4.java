package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSignup4 extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            
            String skillname = request.getParameter("skillname");
            int skilllevel = Integer.parseInt(request.getParameter("skilllevel"));
            int experience = Integer.parseInt(request.getParameter("experience"));
            int user_id = Integer.parseInt(request.getParameter("id"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from skills");
            rs.moveToInsertRow();
            rs.updateString("skill", skillname);
            rs.updateInt("id", user_id);
            rs.updateInt("skill_level", skilllevel);
            rs.updateInt("experience", experience);
            rs.insertRow();
            out.println("Success");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
