/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-09-12 04:42:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.layout;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import data.dao.ShopDao;
import data.dao.MemberDao;

public final class title_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("data.dao.MemberDao");
    _jspx_imports_classes.add("data.dao.ShopDao");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300&family=East+Sea+Dokdo&family=Gamja+Flower&family=Gowun+Dodum&family=Nanum+Gothic+Coding&family=Nanum+Pen+Script&family=Orbit&display=swap\" rel=\"stylesheet\">\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.0.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("	div.cart{\n");
      out.write("		float: right;\n");
      out.write("		cursor: pointer;\n");
      out.write("		margin-right: 50px;\n");
      out.write("	}\n");
      out.write("	.count{\n");
      out.write("		width: 30px;\n");
      out.write("		height: 30px;\n");
      out.write("		float: right;\n");
      out.write("		background-color: red;\n");
      out.write("		color: white;\n");
      out.write("		border-radius: 30px;\n");
      out.write("		text-align: center;\n");
      out.write("		line-height:30px;\n");
      out.write("		z-index: 10;\n");
      out.write("		position: relative;\n");
      out.write("		left: -20px;\n");
      out.write("		top: 10px;\n");
      out.write("		font-size: 0.8em;\n");
      out.write("	}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("$(function(){\n");
      out.write("	$(\"div.cart\").click(function(){\n");
      out.write("		\n");
      out.write("		location.href=\"index.jsp?main=shop/mycart.jsp\";\n");
      out.write("		\n");
      out.write("	});\n");
      out.write("	\n");
      out.write("});\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<title>Insert title here</title>\n");

// 절대경로 잡기
String root=request.getContextPath();


// 로그인세션
String loginok=(String)session.getAttribute("loginok");

// 세션으로부터 아이디를 얻는다 
String myid=(String)session.getAttribute("myid");

// db에 있는 이름 가져온다
MemberDao dao=new MemberDao();
String name=dao.getName(myid);


      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<a href=\"");
      out.print(root);
      out.write("\" style=\"color: black;\"><img alt=\"\" src=\"");
      out.print(root);
      out.write("/image/spring/s1.webp\" style=\"width: 70px;\"></a>\n");
      out.write("	JSP & JQuery Mini Project\n");
      out.write("	\n");
      out.write("	\n");

// 1.타이틀에 로그아웃시: 로그인버튼   로그인시: 로그아웃버튼
if(loginok==null){
      out.write("\n");
      out.write("	\n");
      out.write("	<button type=\"button\" class=\"btn btn-success\" style=\"width: 100px;\" onclick=\"location.href='index.jsp?main=login/loginform.jsp'\">Login</button>\n");
      out.write("	\n");
} else {
      out.write("\n");
      out.write("	<b style=\"font-size: 15px;\">");
      out.print(name );
      out.write("님이 로그인 중...</b>\n");
      out.write("	<button type=\"button\" class=\"btn btn-danger\" style=\"width: 100px;\" onclick=\"location.href='login/logoutaction.jsp'\">Logout</button>\n");
      out.write("	\n");
}


      out.write("\n");
      out.write("<div class=\"cart\">\n");
      out.write("	");

	ShopDao sdao=new ShopDao();
	
	// 장바구니에 몇개다 담겨 있는지 갯수 구해보기
	int cartSize=sdao.getCartList(myid).size();
	
	
      out.write("\n");
      out.write("	<i class=\"bi bi-cart cartimg\" style=\"font-size: 1.05em;\"></i>\n");
      out.write("	<div class=\"count\">");
      out.print(cartSize );
      out.write("</div>\n");
      out.write("</div>\n");
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
