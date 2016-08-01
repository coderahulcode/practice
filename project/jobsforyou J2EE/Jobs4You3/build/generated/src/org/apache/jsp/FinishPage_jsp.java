package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import abc.Examination;
import java.util.ArrayList;

public final class FinishPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Header4.jsp");
    _jspx_dependants.add("/index_1.jsp");
    _jspx_dependants.add("/Footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head><link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link href=\"./All.css\" type=\"text/css\" rel=\"stylesheet\"/>\n");
      out.write("        <script>\n");
      out.write("            function exit()\n");
      out.write("            {\n");
      out.write("                window.location.href=\"StudentHome.jsp\";\n");
      out.write("            }\n");
      out.write("            function retake()\n");
      out.write("            {\n");
      out.write("            window.location.href = \"NewExam.jsp\";\n");
      out.write("            }\n");
      out.write("         </script>\n");
      out.write("            <title> Exam result </title>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <div id=\"all\">\n");
      out.write("            ");
      out.write("<script>\n");
      out.write("    function goheader(e)\n");
      out.write("    {\n");
      out.write("       if(e.keyCode ===13)\n");
      out.write("       {\n");
      out.write("           var name = document.getElementById(\"search\").value;\n");
      out.write("           window.location.href=\"OurRecruiters.jsp?search=\"+name;\n");
      out.write("       }\n");
      out.write("\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("<div  style=\"position:absolute\">\n");
      out.write("    <input type=\"text\" id=\"search\" style=\" margin-left: 690px;  margin-top:80px;\" class=\"textbox\" onkeyup=\"goheader(event)\"placeholder=\"Search Company\"/>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("<table id=\"Table_01\" width=\"980\" height=\"136\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"3\">\n");
      out.write("                    <img src=\"images/header_01.png\" width=\"980\" height=\"8\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td rowspan=\"2\">\n");
      out.write("                    <img src=\"images/header_02.png\" width=\"17\" height=\"128\" alt=\"\"></td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"StudentHome.jsp\"><img src=\"images/header_03.png\" width=\"113\" height=\"123\" alt=\"\"></a></td>\n");
      out.write("                <td rowspan=\"2\">\n");
      out.write("                    <img src=\"images/header_04.png\" width=\"850\" height=\"128\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <img src=\"images/header_05.png\" width=\"113\" height=\"5\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("<link rel='stylesheet' type='text/css' href='styles_1.css' />\n");
      out.write("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>\n");
      out.write("<script type='text/javascript' src='menu_jquery.js'></script>\n");

int username22=(Integer)session.getAttribute("id");


      out.write("\n");
      out.write("<div id='cssmenu'>\n");
      out.write("    <ul>\n");
      out.write("        <li class='active'><a href='CompanySearchStudent.jsp'><span>Search</span></a></li>\n");
      out.write("        \n");
      out.write("        <li class='has-sub'><a href='#'><span>Exam</span></a>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href='NewExam.jsp'><span>Take Exam</span></a></li>\n");
      out.write("                <li><a href='DownloadPapers.jsp'><span>Download Exam Papers</span></a></li>\n");
      out.write("                <li class='has-sub last'><a href='ViewResults.jsp'><span>View Previous Result</span></a></li>\n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("        <li><a href='ViewProfile.jsp'><span>View Profile</span></a></li>\n");
      out.write("        <li><a href='Messages.jsp' onclick=\"go1('");
      out.print(username22);
      out.write("')\"><span>Messages</span></a></li>\n");
      out.write("        <li class='has-sub last'><a href='#'><span>Uploads</span></a>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href='UploadResumeStudent.jsp'><span>Upload Resume</span></a></li>\n");
      out.write("                <li class='last'><a href='UploadPhotoStudent.jsp'><span>Upload Picture</span></a></li>\n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("        <li><a href='StudentLogout.jsp'><span>Logout</span></a></li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("             \n");
      out.write("            <div id=\"main\" class=\"studentlogin\">\n");
      out.write("            ");

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "rahul");
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from result");
                rs.moveToInsertRow();
            
      out.write("\n");
      out.write("            <center>\n");
      out.write("            <table border = \"1\">\n");
      out.write("                    <th> Question </th>\n");
      out.write("                    <th> Correct Answer </th>\n");
      out.write("                    <th> Your Response </th>\n");
      out.write("                    <th> Correct / Incorrect </th>\n");
      out.write("\n");
      out.write("            ");

                ArrayList<Examination> paperal = (ArrayList) session.getAttribute("paper");
                int i = 0;
                int result = 0;
                rs.updateInt("category", paperal.get(i).category);
                rs.updateInt("student_id", 1);              //          (Integer)session.getAttribute("id"));  //check name of id given to dtudent in session
                for (i = 0; i < paperal.size(); i++) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                    <td> ");
      out.print(i+1);
      out.write(" </td>\n");
      out.write("                    <td>");
      out.print(paperal.get(i).answer);
      out.write(" </td>\n");
      out.write("            ");

                if (paperal.get(i).useranswer.equals("null")) {
            
      out.write("\n");
      out.write("            <td> Not - answered </td>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("            <td>");
      out.print(paperal.get(i).useranswer);
      out.write(" </td>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            ");

                if ((paperal.get(i).answer.equals(paperal.get(i).useranswer))) 
                {
                    result=result+4;
            
      out.write("\n");
      out.write("            <td style = \"background-color: green\"> correct </td>\n");
      out.write("            ");

                } 
                else if((paperal.get(i).useranswer.equals("null"))) 
                {
            
      out.write("\n");
      out.write("            <td style = \"background-color: yellow\"> Un Attempted </td>\n");
      out.write("            ");

                }
                else 
                {
                result=result-1;
            
      out.write("\n");
      out.write("            <td style = \"background-color: red\"> incorrect </td>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
                session.setAttribute("paper", null);
                session.setAttribute("index", null);
                rs.updateInt("result", result);
                rs.insertRow();
            
      out.write("\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("                    <h2> Your result is:");
      out.print(result);
      out.write("/40 </h2>\n");
      out.write("                    <input type = \"button\"  value = \"Click to Exit\" onclick = \"exit()\"/>\n");
      out.write("                    <input type = \"button\"  value = \"Click to Retake Test\" onclick = \"retake()\"/>\n");
      out.write("            </center>\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("<img src=\"footer1.png\" width=\"980\" height=\"65\" alt=\"\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("                    </body>\n");
      out.write("                    </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
