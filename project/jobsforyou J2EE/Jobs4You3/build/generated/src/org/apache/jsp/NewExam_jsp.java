package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;

public final class NewExam_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head><link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link href=\"./All.css\" type=\"text/css\" rel=\"stylesheet\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Take Exam</title>\n");
      out.write("        <script>\n");
      out.write("            var xmlhttp;\n");
      out.write("            var id=0;\n");
      out.write("            function go1()\n");
      out.write("            {\n");
      out.write("                sessionStorage.timer=600000;\n");
      out.write("                id=document.getElementById(\"category\").value;\n");
      out.write("                go();\n");
      out.write("            }\n");
      out.write("            function go()\n");
      out.write("            {\n");
      out.write("                try\n");
      out.write("                {\n");
      out.write("                    xmlhttp = new ActiveXObject(\"Msxml2.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                catch (e)\n");
      out.write("                {\n");
      out.write("                    try\n");
      out.write("                    {\n");
      out.write("                        xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                    }\n");
      out.write("                    catch (e2)\n");
      out.write("                    {\n");
      out.write("                        xmlhttp = new XMLHttpRequest();\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                xmlhttp.onreadystatechange = go2;\n");
      out.write("                xmlhttp.open(\"Get\", \"./CreateExam?category=\" + id+\"&src=web\", true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function go2()\n");
      out.write("            {\n");
      out.write("                if (xmlhttp.readyState === 4 && xmlhttp.status === 200)\n");
      out.write("                {\n");
      out.write("                    window.location.href=\"NewExam2.jsp\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"all\">\n");
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
      out.write("                <table class=\"CSSTableGenerator\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("        <select id=\"category\">\n");
      out.write("            ");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/myschema", "root", "RISHAB");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from category ");
            while(rs.next())
            {
                String options=rs.getString("category");
                int id=rs.getInt("id");
             
      out.write("\n");
      out.write("             <option value=\"");
      out.print(id);
      out.write('"');
      out.write('>');
      out.print(options);
      out.write("</option>\n");
      out.write("            ");

            }
             session.setAttribute("index", 0);
            
      out.write("\n");
      out.write("        </select></td>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("        <td><input type=\"button\" value=\"Create Exam\" onclick=\"go1()\" /></td></tr>\n");
      out.write("        </table>\n");
      out.write("                \n");
      out.write("</div>\n");
      out.write("            ");
      out.write("<img src=\"footerunderguidance.png\" width=\"980\" height=\"65\" alt=\"\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
