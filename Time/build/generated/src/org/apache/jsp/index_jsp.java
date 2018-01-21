package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int flag=0;
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Time:Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        ");

            try{
                if(request.getParameter("sub").equals("login")&&!request.getParameter("id").equals(null)&&!request.getParameter("pass").equals(null)){
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","ashish","ashish");
                    Statement st=con.createStatement();
                    String sql="select * from R_USER where id="+request.getParameter("id")+" and pass="+request.getParameter("pass");
                    ResultSet rs=st.executeQuery(sql);
                    if(rs.next()){
                       flag=1;
                    }
                    else{
                        flag=2;
                    }
                }
                else 
                    flag=0;
            }catch(Exception e){System.out.println(e);}    
        
      out.write("\n");
      out.write("        ");

            if(flag==1)
            {
                //out.println("<script>alert('Login Successful.');</script>");
                response.sendRedirect("welcome.jsp");
            }
            else if(flag==2){
                out.println("<h2>Login Fail....!!!</h2>");
            }
        
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <form action=\"\">\n");
      out.write("            <label>User Id :</label>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter User Id\" name=\"id\"/></br>\n");
      out.write("            <label>Password :</label>\n");
      out.write("            <input type=\"password\" placeholder=\"Enter Password\" name=\"pass\"/></br>\n");
      out.write("            <input type=\"submit\" value=\"login\" name=\"sub\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </center>    \n");
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
