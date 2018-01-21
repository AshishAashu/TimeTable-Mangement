<%-- 
    Document   : ViewTeacher
    Created on : Jul 9, 2017, 5:39:01 PM
    Author     : AshishAashu
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Use.EsConnection" %>
<div>
    <table>
        <tr>
            <th>Teacher Id </th>
            <th>Teacher Name </th>
            <th>Teacher Dept </th>
            <th>Teacher Address </th>
        </tr>
<%! Connection con;%>
<%
    try{
        con=EsConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select distinct * from teacher");
        while(rs.next()){
%>    
        <tr>
            <td><%=rs.getString(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getString(4)%></td>
        </tr>
        <%
            }
        } 
        catch(Exception e){System.out.println(e);}
        %>    
    </table>    
</div>