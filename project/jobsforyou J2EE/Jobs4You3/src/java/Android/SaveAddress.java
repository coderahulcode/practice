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
public class SaveAddress extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            String address=request.getParameter("address");
            String city=request.getParameter("city");
            String pin=request.getParameter("pin");
            String cid=request.getParameter("country");
            int sid=Integer.parseInt(request.getParameter("state"));
            int id=0;
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String values="\'"+address+"\',\'"+city+"\',\'"+pin+"\',\'"+cid+"\',\'"+sid+"\'";
            String allcolumns="street,city,pin,country,state";
            String insert="insert into user_address("+allcolumns+") values("+values+")";
            stmt1.execute(insert,Statement.RETURN_GENERATED_KEYS);
            ResultSet keyset=stmt1.getGeneratedKeys();
            if(keyset.next())
            {
                 id=keyset.getInt(1);
            }
            
            out.println(id+"");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
