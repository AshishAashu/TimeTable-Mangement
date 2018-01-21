<%-- 
    Document   : viewcourse
    Created on : Jul 9, 2017, 11:41:30 PM
    Author     : AshishAashu
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Use.EsConnection" %>
<div>
    <table>
        <tr>
            <th>Course Id </th>
            <th>Course Name </th>
            <th>Branch Name</th>
            <th>Branch Year </th>
            <th>Course Dept </th>
            <th>Assign Teacher Id </th>
            <th>Theory</th>
            <th>Practicals</th>
        </tr>
<%! Connection con;%>
<%
    try{
        con=EsConnection.getConnection();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select distinct * from course");
        while(rs.next()){
%>    
        <tr>
            <td><%=rs.getString(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getString(4)%></td>
            <td><%=rs.getString(5)%></td>
            <td><%=rs.getString(6)%></td>
            <td><%=rs.getString(7)%></td>
            <td><%=rs.getString(8)%></td>
        </tr>
        <%
            }
        } 
        catch(Exception e){System.out.println(e);}
        %>    
    </table>    
</div>
