/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.90
 * Generated at: 2018-10-06 13:00:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class session_002dinvalid_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/tld/fn.tld", Long.valueOf(1448460094000L));
    _jspx_dependants.put("/WEB-INF/tld/fmt.tld", Long.valueOf(1448460094000L));
    _jspx_dependants.put("/WEB-INF/tld/c.tld", Long.valueOf(1448460094000L));
    _jspx_dependants.put("/WEB-INF/tld/spring-form.tld", Long.valueOf(1448460094000L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!doctype html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>PHFI</title>\n");
      out.write("    <link rel=\"icon\" href=\"../images/favicon.png\" type=\"image/png\">\n");
      out.write("\t<link  type=\"text/css\" rel=\"stylesheet\" href=\"../css/bootstrap.min.css\">\n");
      out.write("    <link  type=\"text/css\" rel=\"stylesheet\" href=\"../css/bootstrap-theme.min.css\">\n");
      out.write("    <link href=\"../css/main.css\" rel=\"stylesheet\"/>\n");
      out.write("    <link href=\"../css/style.css\" rel=\"stylesheet\" />\n");
      out.write("\t<script src=\"../js/login.js\" type=\"text/javascript\"></script>\n");
      out.write("\t   <script src=\"../js/backbutton.js\" type=\"text/javascript\"></script>\n");
      out.write("   \n");
      out.write("</head>\n");
      out.write("<body>\t\n");
      out.write("\t<div id=\"wrapper\">\n");
      out.write("\t\t<div class=\"container-fluid prepaid-admin-dashboard\">\n");
      out.write("\t\t\t<header class=\"col-sm-12 content-wrapper\">\n");
      out.write("\t\t\t\t<div class=\"col-sm-4\"> \n");
      out.write("\t\t\t\t\t<img class=\"login-logo-size\" src=\"../images/logo.jpg\" class=\"subPageLogo\" alt=\"Prepaid Heading\">\n");
      out.write("\t\t\t\t</div>\t\t\t\t\n");
      out.write("\t\t\t</header> <!-- all-page-header end -->\t\t\t\n");
      out.write("\t\t\t<!-- Dashboard Content start - end -->\n");
      out.write("\t\t\t<article> \n");
      out.write("\t\t\t\t<div class=\"col-xs-12 content-wrapper login-page-content\">\n");
      out.write("\t\t\t\t\t<label class=\"font-style-text\"> Your browser session is expired! Please click here to <a href=\"login\" >Login</a> page</label>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</article>\n");
      out.write("\t\t\t<!-- Dashboard Content start - end -->\n");
      out.write("\t\t\t <footer class=\"footer\">\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\t\t\t</footer>\n");
      out.write("\t\t</div><!-- prepaid-admin-dashboard End -->\n");
      out.write("\t</div>\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}