package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import abc.Examination;
import java.util.ArrayList;
import java.sql.*;

public final class NewExam2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head><link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link href=\"./All.css\" type=\"text/css\" rel=\"stylesheet\"/>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function ti2()\n");
      out.write("            {\n");
      out.write("                var timer = sessionStorage.timer;\n");
      out.write("                var min = parseInt(((timer / 1000) / 60)).toString();\n");
      out.write("                var sec = parseInt(((timer / 1000) % 60)).toString();\n");
      out.write("                if (sec.length === 1)\n");
      out.write("                {\n");
      out.write("                    sec = \"0\" + sec;\n");
      out.write("                }\n");
      out.write("                if (min.length === 1)\n");
      out.write("                {\n");
      out.write("                    min = \"0\" + min;\n");
      out.write("                }\n");
      out.write("                document.getElementById(\"clock\").innerHTML = min + \":\" + sec;\n");
      out.write("                sessionStorage.timer-=1000;\n");
      out.write("                if(sessionStorage.timer<=0)\n");
      out.write("                {\n");
      out.write("                    window.location.href=\"FinishPage.jsp\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function ti1()\n");
      out.write("            {\n");
      out.write("                setInterval(ti2,1000);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        <title>\n");
      out.write("            Examination\n");
      out.write("        </title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body onload=\"ti1()\">\n");
      out.write("         <div id=\"all\">\n");
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
      out.write("            <div id=\"main\">\n");
      out.write("        \n");
      out.write("        ");

            ArrayList<Examination> paperal = (ArrayList) session.getAttribute("paper");
            int index = (Integer) session.getAttribute("index");
        
      out.write("\n");
      out.write("        <center><div id=\"paper\" >\n");
      out.write("            <form action=\"CreateExam2.jsp\" onsubmit=\"go(");
      out.print(index);
      out.write(")\" method=\"post\">\n");
      out.write("                <table class=\"CSSTableGenerator\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Question:");
      out.print((index + 1));
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(paperal.get(index).question);
      out.write("</td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>(a)</td>\n");
      out.write("                        <td><input type=\"radio\" name=\"answer\" value=\"");
      out.print(paperal.get((Integer) session.getAttribute("index")).a);
      out.write("\"\n");
      out.write("                                   ");

                                       if (paperal.get(index).useranswer.equals(paperal.get(index).a))
                                       {
                                   
      out.write("\n");
      out.write("                                   checked\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   />");
      out.print(paperal.get(index).a);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>(b)</td>\n");
      out.write("                        <td><input type=\"radio\" name=\"answer\" value=\"");
      out.print(paperal.get(index).b);
      out.write("\"\n");
      out.write("                                   ");

                                       if (paperal.get(index).useranswer.equals(paperal.get(index).b))
                                       {
                                   
      out.write("\n");
      out.write("                                   checked\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   />");
      out.print(paperal.get((Integer) session.getAttribute("index")).b);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>(c)</td>\n");
      out.write("                        <td><input type=\"radio\" name=\"answer\" value=\"");
      out.print(paperal.get(index).c);
      out.write("\"\n");
      out.write("                                   ");

                                       if (paperal.get(index).useranswer.equals(paperal.get(index).c))
                                       {
                                   
      out.write("\n");
      out.write("                                   checked\n");
      out.write("                                   ");
 }
                                   
      out.write("\n");
      out.write("                                   />");
      out.print(paperal.get((Integer) session.getAttribute("index")).c);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>(d)</td>\n");
      out.write("                        <td><input type=\"radio\" name=\"answer\" value=\"");
      out.print(paperal.get(index).d);
      out.write("\"\n");
      out.write("                                   ");

                                       if (paperal.get(index).useranswer.equals(paperal.get(index).d))
                                       {
                                   
      out.write("\n");
      out.write("                                   checked\n");
      out.write("                                   ");
 }
                                   
      out.write("\n");
      out.write("                                   />");
      out.print(paperal.get((Integer) session.getAttribute("index")).d);
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td><input type=\"submit\" name=\"submit\" value=\"Submit Answer\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><form action=\"CreateExam2.jsp\"><input id=\"prev\" type=\"submit\" name=\"submit\" value=\"Previous\"/></form></td>\n");
      out.write("                    <td><form action=\"CreateExam2.jsp\"><input id=\"next\" type=\"submit\" name=\"submit\" value=\"Next\"/></form></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <div>\n");
      out.write("            <form action=\"ChangeIndex.jsp\" method=\"post\">\n");
      out.write("                <table>\n");
      out.write("                    <tr><td>\n");
      out.write("                            <input type=\"submit\" id=\"q1\" value=\"1\" name=\"questionbt\" style=\"width: 50px; height: 30px \n");
      out.write("                                   ");

                                       if (!(paperal.get(0).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q2\" value=\"2\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(1).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q3\" value=\"3\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(2).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("\n");
      out.write("                            <input type=\"submit\" id=\"q4\" value=\"4\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(3).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q5\" value=\"5\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(4).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q6\" value=\"6\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(5).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q7\" value=\"7\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(6).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q8\" value=\"8\" name=\"questionbt\" style=\"width: 50px; height: 30px\n");
      out.write("                                   ");

                                       if (!(paperal.get(7).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q9\" value=\"9\" name=\"questionbt\" style=\"width: 50px; height: 30px");

                                if (!(paperal.get(8).useranswer.equals("null")))
                                {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                            <input type=\"submit\" id=\"q10\" value=\"10\" name=\"questionbt\" style=\"width: 50px; height: 30px;\n");
      out.write("                                   ");

                                       if (!(paperal.get(9).useranswer.equals("null")))
                                       {
                                   
      out.write("\n");
      out.write("                                   ; background-color:yellow\n");
      out.write("                                   ");

                                       }
                                   
      out.write("\n");
      out.write("                                   \"/>\n");
      out.write("                        </td></tr>    \n");
      out.write("                </table> \n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <form action=\"FinishPage.jsp\" method=\"post\">\n");
      out.write("            <input type=\"submit\" style=\"height: 100px; width: 100px; background-color:activecaption \" value=\"Finish Exam\" />\n");
      out.write("        </form>\n");
      out.write("        </center>   \n");
      out.write("                                   <table class=\"CSSTableGenerator\"><tr><td><h1 id=\"clock\"></h1></td></tr></table>\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("<img src=\"footerunderguidance.png\" width=\"980\" height=\"65\" alt=\"\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
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
