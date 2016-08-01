/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahajan
 */
public class StudentMessages extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        int id=0;
        int pid=0;
        String description="";
        try 
        {
            out.println("<tr><th>S.No.</th><th>Description</th><th>Details</th></tr>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from message where studentid in(select id from student where username='" + username + "')");
            while (rs.next())
            {
                id = rs.getInt("id");
                pid = rs.getInt("pid");
                System.out.println(pid);
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select description from placementdrive where pid =" + pid);
                if (rs1.next()) 
                {
                    description = rs1.getString("description");
                }
                out.println("<tr><td>" + id + "</td><td>" + description + "</td><td><a href=\"MessageDetail.jsp?msgid=<%=id%>\"/></td></tr>");
            }
        } 
        catch (Exception e) 
        {
                e.printStackTrace();
        } 
    }
}