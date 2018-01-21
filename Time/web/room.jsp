<%-- 
    Document   : room
    Created on : Jul 9, 2017, 11:53:19 PM
    Author     : AshishAashu
--%>

<%@page import="java.sql.*"%>
<%@page import="Use.EsConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! Connection con;%>
<div>
    <h3>Fill Form to add room :</h3>
    <form action="addroom">
    <table>
        <tr>
            <td>Room Id :</td>
            <td>
                <input type="text" name="roomid"/>
            </td>
        </tr>
        <tr>
            <td>Department : </td>
            <td><select id="dept" name="rdept" onchange="setTeacher();"><option value="null">--Select Department--</option>
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
            <td>
                Alloted For :
            </td>
            <td>
                <select name="af">
                    <option value="T">Theory</option>
                    <option value="P">Practical</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add Room"/></td>
        </tr>
    </table>
    </form>            
</div>
