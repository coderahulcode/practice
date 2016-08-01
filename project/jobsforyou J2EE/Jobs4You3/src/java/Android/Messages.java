package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Messages extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            int max = Integer.parseInt(request.getParameter("max"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from message where studentid = "+id+" and id>"+max);
            while(rs.next())
            {
                String message = rs.getString("message");
                int pid = rs.getInt("pid");
                int msgid =rs.getInt("id");
                String datetime = rs.getString("date_time");
                String date_time[] = datetime.split(" ");
                String tempdate = date_time[0];
                String d[] = tempdate.split("-");
                String date = d[2]+"/"+d[1];
                String temptime = date_time[1];
                String t[] = temptime.split(":");
                String time = t[0]+":"+t[1];
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from company where id=(select company from placementdrive where pid = "+pid+")");
                if(rs1.next())
                {
                    String name = rs1.getString("name");
                    out.println("Message from "+name);
                    out.println(msgid);
                    out.println(message);
                    out.println(date);
                    out.println(time);
                }
            }
            out.println(" ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}