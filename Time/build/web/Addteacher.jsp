<%-- 
    Document   : Addteacher
    Created on : Jun 26, 2017, 1:28:33 PM
    Author     : AshishAashu
--%>

<%@page import="java.sql.*"%>
<%@page import="Use.EsConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!Connection con;%>   
<!DOCTYPE html>
<h3>Fill Form to add <strong>Teacher</strong> : </h3>
<form action="/Time/addteacher">
    <table>
        <tr>
            <td>Id : </td>
            <td><input type="text" name="tid"/></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><input type="text" name="tname"/></td>
        </tr>
        <tr>
            <td>Department : </td>
            <td><select id="dept" name="tdept" onchange="setTeacher();"><option value="null">--Select Department--</option>
                    <%
                        try{
                            con=EsConnection.getConnection();
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select distinct * from department");
                            while(rs.next()){
                                
                    %>
                    <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
                    <%
                            }
                            con.close();
                        }catch(Exception e){}
                    %>
                </select></td>
        </tr>
        <tr>
            <td>Address : </td>
            <td><input type="text" name="tadd"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form>

