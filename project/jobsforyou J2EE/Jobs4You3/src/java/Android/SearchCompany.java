package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchCompany extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String companyname = request.getParameter("name");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from all_companies where name like '%"+companyname+"%'" );
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String logo = rs.getString("logo");
                out.println(name);
                out.println(id);
                out.println(logo);
            }
            out.println(" ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}