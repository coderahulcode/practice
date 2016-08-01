package Android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentSignup extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            int id=0;
            PrintWriter out = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String number = request.getParameter("number");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from student where username='" + username+"'" );
            if(!rs.next())
            {
                Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String values="\'"+username+"\',\'"+password+"\'";
                String allcolumns="username,password";
                String insert="insert into student("+allcolumns+") values("+values+")";
                stmt1.execute(insert,Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset=stmt1.getGeneratedKeys();
                if(keyset.next())
                {
                     id=keyset.getInt(1);
                }
                Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs1 = stmt2.executeQuery("select * from personal_information");
                rs1.moveToInsertRow();
                rs1.updateInt("user_id",id);
                rs1.updateString("username",username);
                rs1.updateString("email",email);
                rs1.updateString("mobile_no",number);
                rs1.insertRow();
                out.println("Success");
                out.println(id);
            }
            else
            {
                out.println("Username Already Exists");
            }
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}