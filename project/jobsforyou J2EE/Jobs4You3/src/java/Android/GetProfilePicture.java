/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
public class GetProfilePicture extends HttpServlet
{
    int id=0;
    String profilepic="";
    byte buffer[]=new byte[100000];
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("image/jpeg");
        try
        {
            int id=Integer.parseInt(request.getParameter("userid"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reference", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from personal_information where user_id="+id);
            if(rs.next())
            {
                profilepic=rs.getString("photo");
            }
            FileInputStream fis=new FileInputStream(profilepic);
            File f=new File(profilepic);
            DataInputStream dis=new DataInputStream(fis);
            DataOutputStream dos=new DataOutputStream(response.getOutputStream());
            response.setHeader("image/jpeg", f.length()+"");
            int count=0;
            dos.writeLong(f.length());
            while(true)
            {
                int r=dis.read(buffer,0,100000);
                count+=r;
                if(r==f.length())
                    break;
                
                dos.write(buffer, 0, r);
                
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
