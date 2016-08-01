package Android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetPaper extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        DataOutputStream out = new DataOutputStream(response.getOutputStream());
        DataInputStream dis;
        FileInputStream fis;
        try
        {
            int id = Integer.parseInt(request.getParameter("paperid"));
            System.out.println(id);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from papers where id="+id );
            if(rs.next())
            {
                int count=0;
                String path = rs.getString("path");
                String fn= path.substring(path.lastIndexOf("/")+1);
                response.setHeader("File-Name", fn);
                String finalpath=getServletContext().getRealPath("/Uploads/Papers");
                File f=new File(finalpath+"\\"+fn);
                fis=new FileInputStream(f);
                response.setHeader("Content-Length", f.length()+"");
                System.out.println(response.getHeader("Content-Length"));
                byte []b= new byte[100000];
                while(true)
                {
                    int r = fis.read(b, 0, 100000);
                    count+=r;
                    out.write(b,0, r);
                    if(count==f.length())
                    {
                        fis.close();
                        break;
                    }
                }
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}