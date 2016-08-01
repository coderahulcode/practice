import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Rishab
 */
public class DeleteCollege extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            int cmpid = Integer.parseInt(request.getParameter("companyid"));
            int clgid = Integer.parseInt(request.getParameter("id"));
            int i = 1;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from company_selection where company="+cmpid+" and college="+clgid);
            if(rs.next())
            {
            rs.deleteRow();
            }
            
            Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs2 = stmt2.executeQuery("select * from company_selection where company=" + cmpid);
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
                    out.println("<tr><td>" + i++ + "</td>" +"<td>"+ name +"</td>"+ "<td><input type=\"button\" value=\"Delete\" onclick= \"go5(" + clg + "," + cmpid + ")\"/></td></tr>");
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
