/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.90
 * Generated at: 2018-10-06 13:10:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class dashboardAshaNext_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/tld/fn.tld", Long.valueOf(1448460094000L));
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>PHFI</title>\r\n");
      out.write("    <link rel=\"icon\" href=\"../images/favicon.png\" type=\"image/png\">\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"../css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!--Body Wrapper block Start -->\t\r\n");
      out.write("    <div id=\"wrapper\">\r\n");
      out.write("\t\t<!--Container block Start -->\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<!--Navigation Block Start --> \r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navigation.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t<!--Navigation Block Start -->   \t\t\t\r\n");
      out.write("\t\t\t<!--Article Block Start-->\r\n");
      out.write("\t\t\t<article>\r\n");
      out.write("\t\t\t\t<div class=\"col-xs-12 content-wrapper\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-xs-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"discriptionErrorMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"green-error\" id=\"sucessDiv\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${success}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"red-error\" id=\"errorDiv\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- <h3>Dash Board (Static)</h3> \r\n");
      out.write("\t\t\t\t\tContent Block Start\r\n");
      out.write("\t\t\t\t\t\t<img src=\"../images/dashboard.png\" width=\"100%\" height=\"400px\">\r\n");
      out.write("\t\t\t\t\tContent Block End\t -->\r\n");
      out.write("\t\t\t\t\t<table id=\"serviceResults\" class=\"table table-striped table-bordered  \">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"buttonMain\" height=\"300px\" valign=\"middle\"><p style=\"margin-top: 100px;margin-left: 50px\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" id=\"buttonCreate\" class=\"button\" value=\"New Registration\" style=\"height: 25px\" onclick=\"document.location.href='show-phfi-registration-form';\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" id=\"buttonCreate\" class=\"button\"  value=\"Add Visit Detail\" style=\"height: 25px;\" onclick=\"document.location.href='dashboard-addVisit-Next-page';\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" id=\"buttonCreate\" class=\"button\"  value=\"Add Delivery Registration\" style=\"height: 25px;\" onclick=\"document.location.href='show-phfi-delivery-visit-form';\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" id=\"buttonCreate\" class=\"button\"  value=\"Back\" style=\"height: 25px;\" onclick=\"document.location.href='dashboard-sec-page';\">\r\n");
      out.write("\t\t\t\t\t\t\t</p></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</article>\r\n");
      out.write("\t\t\t<!--Article Block End-->\r\n");
      out.write("\t\t\t<footer class=\"footer\">\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--Container block End -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--Body Wrapper block End -->\t\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("    <script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("    <!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("    <script src=\"../js/bootstrap.min.js\"></script>\t\r\n");
      out.write("\t<script>\t\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$( \"#navListId1\" ).addClass( \"active-background\" );\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t/* Select li full area function Start */\r\n");
      out.write("\t\t$(\"li\").click(function(){\r\n");
      out.write("\t\t\twindow.location=$(this).find(\"a\").attr(\"href\"); \r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t/* Select li full area function End */\r\n");
      out.write("\t\t/* Common Navigation Include Start */\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* Common Navigation Include End */\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("  </body>  \r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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