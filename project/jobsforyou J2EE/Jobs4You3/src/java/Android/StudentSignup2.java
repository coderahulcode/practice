package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSignup2 extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String fname = request.getParameter("firstname");
            String mname = request.getParameter("middlename");
            String lname = request.getParameter("lastname");
            String smail = request.getParameter("semail");
            String contact = request.getParameter("contactno");
            String ntn = request.getParameter("nationality");
            String username = request.getParameter("username");
            String gender = request.getParameter("gender");
            int address = Integer.parseInt(request.getParameter("address"));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from personal_information where username='" + username+"'");
            if(rs.next())
            {
                rs.updateString("first_name", fname);
                rs.updateString("middle_name", mname);
                rs.updateString("last_name", lname);
                rs.updateString("secondary_email", smail);
                rs.updateString("home_phone", contact);
                rs.updateString("nationality", ntn);
                rs.updateString("gender", gender);
                rs.updateInt("address", address);
                rs.updateRow();
                out.println("Success");
            }
            else
            {
                out.println("Failure");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
