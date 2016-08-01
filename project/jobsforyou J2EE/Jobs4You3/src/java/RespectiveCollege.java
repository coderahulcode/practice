
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RespectiveCollege extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            HttpSession s = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            int id = Integer.parseInt(request.getParameter("name"));
            int cmpid = Integer.parseInt(request.getParameter("cmpid"));

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from college where university_id=" + id + " and id not in (select college from myschema.company_selection where company=" + cmpid + ")");
            while (rs.next())
            {
                out.println("<option value=\"" + rs.getInt("id") + "\">" + rs.getString("college_name") + "</option>");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("companyid"));
            int clgid = Integer.parseInt(request.getParameter("id"));
            int i = 1;
            int count = 0;
            int no_of_colleges = 0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company_selection");
            Statement stmt5 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs5 = stmt5.executeQuery("select * from company_selection where company=" + id);
            while (rs5.next())
            {
                count++;
            }
            Statement stmt4 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs4 = stmt4.executeQuery("select no_of_colleges from package where id in(select type from company where id =" + id + ")");
            if (rs4.next())
            {
                no_of_colleges = rs4.getInt("no_of_colleges");
            }
            if (no_of_colleges > count)
            {
                rs.moveToInsertRow();
                rs.updateInt("company", id);
                rs.updateInt("college", clgid);
                rs.insertRow();
                Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2 = stmt2.executeQuery("select * from company_selection where company=" + id);
                out.println("<th>S. No</th><th>College Name</th><th>Options</th>");

                while (rs2.next())
                {
                    int clg = rs2.getInt("college");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                    Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("select * from college where id=" + clg);
                    if (rs1.next())
                    {
                        String name = rs1.getString("college_name");
                        out.println("<tr><td>" + (i++) + "</td><td>" + name + "</td><td><input type=\"button\" value=\"Delete\" onclick= \"go5(" + clg + "," + id + ")\"/></td></tr>");
                    }
                }
            } else
            {
                Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2 = stmt2.executeQuery("select * from company_selection where company=" + id);
                out.println("<th>S. No</th><th>College Name</th><th>Options</th>");

                while (rs2.next())
                {
                    int clg = rs2.getInt("college");
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
                    Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs1 = stmt1.executeQuery("select * from college where id=" + clg);
                    if (rs1.next())
                    {
                        String name = rs1.getString("college_name");
                        out.println("<tr><td>" + (i++) + "</td><td>" + name + "</td><td><input type=\"button\" value=\"Delete\" onclick= \"go5(" + clg + "," + id + ")\"/></td></tr>");
                    }

                }
                out.println("<tr><td colspan=\"2\"><label style=\"color:red\">*You have reached your maximium college selection limit</label></td></tr>");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
