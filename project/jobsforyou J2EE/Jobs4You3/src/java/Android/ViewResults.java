/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rishab
 */
public class ViewResults extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from result where student_id="+id);
            while(rs.next())
            {
                String date_time = rs.getString("date_time");
                int result = rs.getInt("result");
                int categoryid = rs.getInt("category");
                String category="";
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select category from category where id="+categoryid);
                if(rs1.next())
                {
                    category = rs1.getString("category");
                }
                out.println(date_time);
                out.println(result);
                out.println(category);
                System.out.println(date_time);
                System.out.println(result);
                System.out.println(category);
            }
            out.println(" ");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
