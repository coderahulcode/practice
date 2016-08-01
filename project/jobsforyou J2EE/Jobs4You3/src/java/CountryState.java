/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rishab
 */
public class CountryState extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        try 
        {
            PrintWriter out = response.getWriter();
            String country = request.getParameter("country");
            response.setContentType("text/html;charset=UTF-8");
            System.out.println(country+"------------------");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from state where countryid = '"+country+"'");
            while(rs.next())
            {
                String state = rs.getString("statename");
                int id = rs.getInt("id");
                out.println("<option value=\""+id+"\">"+state+"</option>");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
