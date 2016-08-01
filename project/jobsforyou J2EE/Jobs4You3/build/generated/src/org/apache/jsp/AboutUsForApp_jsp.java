package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AboutUsForApp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>About Us</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"main\" style=\"background-image: url('students1.jpg');background-repeat: no-repeat;width: 600px;\">\n");
      out.write("            <h1>About Us</h1>\n");
      out.write("            <img src=\"logo.png\" alt=\"Your Future,Our Responsibility\"/>\n");
      out.write("            <p>\n");
      out.write("            <h3>“Your  Future Our Responsibility” </h3>\n");
      out.write("\n");
      out.write("            <h3>Our Vision:</h3>\n");
      out.write("\n");
      out.write("            <h4>The above motto is the key rule by which we have abided our commitment and strength.We have build a platform to assist uninitiated and professional level personals in taking their leap of advancement. Jobs4you is a assessment and recruitment  platform. We are currently working  and at the same time  contacting with many corporate across fresher's and lateral's. \n");
      out.write("                Students  and even professionals through our platform get the access to vast and indispensible information to act as stepping stone in building a great future prospective . Our vision is to ensure that everyone in the country gets an equal opportunity to build a career. We are strong team based out of Holy city “Amritsar”  with a venture of  looking out for more exciting people who are responsible relentless and resourceful to be part of our growth story.</h4></p>\n");
      out.write("\n");
      out.write("        <h4> <p>If you are someone who wants to work hard, prepared for a steep learning curve and an amazing career growth, we'd be interested to hear from you. If you want to make a dent in the world. We are changing the face of hiring in India, we are a team which is working towards ensuring the every kid in any corner of the country can get an equal opportunity to build a career.\n");
      out.write("\n");
      out.write("                If you are enthusiastic and want an opportunity to excel you at right place. You are Guided by the guys who themselves have the job letters from international companies like Software AG and Tata Consultancy services  .\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                So Your Future is the responsibility of Jobs4You.</h4></p>\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
