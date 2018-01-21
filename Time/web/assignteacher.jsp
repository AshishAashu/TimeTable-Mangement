<%-- 
    Document   : assignteacher.jsp
    Created on : Jun 26, 2017, 3:28:42 PM
    Author     : AshishAashu
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Use.EsConnection" %>
<%! Connection con;%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<select onchange="enablebtn();" name="Cteach"><option value="null">--Select teacher for <%=request.getParameter("dept")%>--</option>
 <%
                        try{
                            con=EsConnection.getConnection();
                            Statement st=con.createStatement();
                            String s="select distinct * from teacher where dept='"+request.getParameter("dept")+"'";
                            ResultSet rs=st.executeQuery(s);
                            while(rs.next()){
                                
                    %>
                    <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
                    <%
                            }
                            con.close();
                        }catch(Exception e){}
                    %>
</select>
