package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/index_3.jsp");
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

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
      out.write("<table id=\"Table_01\" width=\"980\" height=\"136\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"3\">\n");
      out.write("                    <img src=\"images/header_01.png\" width=\"980\" height=\"8\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td rowspan=\"2\">\n");
      out.write("                    <img src=\"images/header_02.png\" width=\"17\" height=\"128\" alt=\"\"></td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"CompanyHome.jsp\"><img src=\"images/header_03.png\" width=\"113\" height=\"123\" alt=\"\"></a></td>\n");
      out.write("                <td rowspan=\"2\">\n");
      out.write("                    <img src=\"images/header_04.png\" width=\"850\" height=\"128\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <img src=\"images/header_05.png\" width=\"113\" height=\"5\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <div  style=\"position:absolute\">\n");
      out.write("                <input type=\"text\" id=\"search\" style=\" margin-left: 690px;  margin-top:80px;\" class=\"textbox\" onkeyup=\"goheader(event)\"placeholder=\"Search Company\"/>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </table>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head><link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\">\n");
      out.write("\t<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />\n");
      out.write("\t<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' />\n");
      out.write("\t<link rel='stylesheet' type='text/css' href='styles_3.css' />\n");
      out.write("\t<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>\n");
      out.write("\t<script type='text/javascript' src='menu_jquery_1.js'></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id='cssmenu'>\n");
      out.write("<ul>\n");
      out.write("   <li><a href='SelectCollege.jsp'><span>Select Colleges</span></a></li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Placement Drive</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='FilterStudent.jsp'><span>Filter Students</span></a></li>\n");
      out.write("         <li class='last'><a href='ViewMyPD.jsp'><span>View Previous Drives</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li><a href='ViewMyPD.jsp'><span>Add Message</span></a></li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Personal Details</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='CompanyProfile.jsp?id=");
      out.print((Integer)session.getAttribute("id"));
      out.write("'><span>View My Details</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li class=''><a href='ContactRecruiter.jsp'><span>Contact Us</span></a></li>\n");
      out.write("   <li class=''><a href='RecruiterLogout.jsp'><span>Logout</span></a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
