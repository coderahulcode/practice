package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadPaper extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            int id = Integer.parseInt(request.getParameter("companyid"));
            String query;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "system");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            if(id==0)
            {
                query = "select * from papers";
            }
            else
            {
                query = "select * from papers where company="+id;
            }
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                
                String title = rs.getString("title");
                int year = rs.getInt("year");
                int pid=rs.getInt("id");
                out.println(title);
                out.println(pid);
                out.println(year);
            }
            out.println(" ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}