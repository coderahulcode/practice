
import abc.Examination;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateExam extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try 
        {
            int idcategory[];
            int count[];
            int entries=0;
            ArrayList<Examination> paper;
            String src = request.getParameter("src");
            HttpSession session = request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("category"));
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  "+id);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stmt.executeQuery("select count(*) from questions where category="+id);
            if(rs.next())
            {
             entries=rs.getInt("count(*)");
             System.out.println("------------"+entries);
            }
            paper= new ArrayList<Examination>();
            idcategory= new int[entries];
            int k=0;
            count=new int[10];
            rs=stmt.executeQuery("select * from questions where category="+id);
            while(rs.next())
            {
              idcategory[k++]=rs.getInt("id");
            }
            for (int i=0; i<10; i++)
            {
                count[i] =  (int) ((entries-1) * (Math.random()));
                boolean flag = true;
                while(flag)
                {
                    int j;
                    for(j=0;j<i;j++)
                    {
                        if (count[j] == count[i]) 
                        {
                            count[i] =  (int) ((entries-1) * (Math.random()));
                            break;
                        } 
                    }
                    if(j==i)
                    {
                        flag = false;
                    }
                }
                System.out.println("random"+count[i]);
            }
            for(int i=0;i<count.length;i++)
            {
                System.out.println(idcategory[count[i]]);
                rs=stmt.executeQuery("select * from questions where id="+idcategory[count[i]]);
                if(rs.next())
                {
                    String question = rs.getString("question");
                    String a = rs.getString("a");
                    String b = rs.getString("b");
                    String c = rs.getString("c");
                    String d = rs.getString("d");
                    String answer = rs.getString("answer");
                    int category = rs.getInt("category");
                    paper.add(new Examination(question, a, b, c, d, answer,"null", category));
               }
            }
            if(src.equals("web"))
            {
                session.setAttribute("paper", paper);
                System.out.println("Done with paper");
                response.setHeader("Cache-Control", "no-cache");
                out.println(" ");
            }
            else
            {
                for(int i=0;i<paper.size();i++)
                {
                    out.println(paper.get(i).question);
                    out.println(paper.get(i).a);
                    out.println(paper.get(i).b);
                    out.println(paper.get(i).c);
                    out.println(paper.get(i).d);
                    out.println(paper.get(i).answer);
                    out.println(paper.get(i).category);
                }
                out.println(" ");
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

}
