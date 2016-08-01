package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddUniversityCollege_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/Header5.jsp");
    _jspx_dependants.add("/index_2.html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head><link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link href=\"./All.css\" type=\"text/css\" rel=\"stylesheet\"/>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>add University or College</title>\n");
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
      out.write("    <table id=\"Table_01\" width=\"980\" height=\"136\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"3\">\n");
      out.write("                    <img src=\"images/header_01.png\" width=\"980\" height=\"8\" alt=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td rowspan=\"2\">\n");
      out.write("                    <img src=\"images/header_02.png\" width=\"17\" height=\"128\" alt=\"\"></td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"AdminHome.jsp\"><img src=\"images/header_03.png\" width=\"113\" height=\"123\" alt=\"\"></a></td>\n");
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
      out.write("\t<link rel='stylesheet' type='text/css' href='styles.css' />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id='cssmenu'>\n");
      out.write("<ul>\n");
      out.write("   <li class='active'><a href='AdminHome.jsp'><span>Home</span></a></li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Additions</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='AddUniversityCollege.jsp'><span>Add University/College</span></a></li>\n");
      out.write("         <li><a href='AddQuestions.jsp'><span>Add Questions</span></a></li>\n");
      out.write("         <li><a href='AddPackage.jsp'><span>Add Package</span></a></li>\n");
      out.write("         <li><a href='ManagePackage.jsp'><span>Manage Package</span></a></li>\n");
      out.write("         <li><a href='AddExam.jsp'><span>Add Papers</span></a></li>\n");
      out.write("         <li class='last'><a href='AddCompany.jsp'><span>Add Company</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li><a href='ViewPendingRequest.jsp'><span>View Pending Requests</span></a></li>\n");
      out.write("   <li class='has-sub'><a href='#'><span>Further Additons</span></a>\n");
      out.write("      <ul>\n");
      out.write("         <li><a href='AddSalaryRange.jsp'><span>Add Salary Range</span></a></li>\n");
      out.write("         <li><a href='AddMarksType.jsp'><span>Add Marks Type</span></a></li>\n");
      out.write("         <li><a href='AddCategory.jsp'><span>Add Category</span></a></li>\n");
      out.write("         <li><a href='AddExperience.jsp'><span>Add Experience</span></a></li>\n");
      out.write("         <li><a href='AddSkillLevel.jsp'><span>Add Skill Level </span></a></li>\n");
      out.write("         <li class='last'><a href='AddDegree.jsp'><span>Add Degree</span></a></li>\n");
      out.write("      </ul>\n");
      out.write("   </li>\n");
      out.write("   <li><a href='ChangePassword.jsp'><span>Change Password</span></a></li>\n");
      out.write("   <li class='last'><a href='Logout.jsp'><span>Logout</span></a></li>\n");
      out.write("</ul>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("             \n");
      out.write("            <div id=\"main\">\n");
      out.write("        <form action=\"AddUniversity.jsp\" method=\"post\">\n");
      out.write("        <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td> University name </td>\n");
      out.write("                    <td> <input type=\"text\" name =\"university\"/> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"ADD University\"/></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            </form>\n");
      out.write("        <form action=\"AddCollege.jsp\" method=\"post\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tr>\n");
      out.write("                    <td> College Name </td>\n");
      out.write("                    <td>  <input type=\"text\" name =\"college\" /> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td></td>\n");
      out.write("                    <td><input type=\"submit\" value=\"ADD College\"/></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("                </div>\n");
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
