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
public class GetPersonalDetails extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            PrintWriter out = response.getWriter();
            int userid = Integer.parseInt(request.getParameter("userid"));
            System.out.println(userid);
            String state="";
            String country="";
            String picture="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "RISHAB");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "RISHAB");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from personal_information where user_id="+userid);
            if(rs.next())
            {
                String name = rs.getString("first_name")+" "+rs.getString("middle_name")+" "+rs.getString("last_name");
                out.println(name);
                System.out.println(name);
                out.println(rs.getString("email"));
                System.out.println(rs.getString("email"));
                out.println(rs.getString("mobile_no"));
                System.out.println(rs.getString("mobile_no"));
                picture = rs.getString("photo");
                System.out.println(picture);
                int addressid = Integer.parseInt(rs.getString("address"));
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt1.executeQuery("select * from user_address where id="+addressid);
                if(rs1.next())
                {
                    String city = rs1.getString("city");
                    String street = rs1.getString("street");
                    String pin = rs1.getString("pin");
                    int stateid = Integer.parseInt(rs1.getString("state"));
                    String countryid =rs1.getString("country");
                    Statement stmt2 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs2 = stmt2.executeQuery("select * from state where id="+stateid);
                    if( rs2.next())
                    {
                      state=rs2.getString("statename");
                      
                    }
                    stmt2 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs2 = stmt2.executeQuery("select * from country where id='"+countryid+"'");
                    if( rs2.next())
                    {
                      country=rs2.getString("name");
                      
                    }
                    String address=street+", "+city+", "+state+", "+country+", "+pin;                   
                    out.println(address);
                    System.out.println(address);
                    out.println(picture);
                }
            }
            out.println("");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
