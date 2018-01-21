<script src="jquery-3.2.1.min.js"></script>
<script>
    function setTeacher(){
        alert($("#dept").val());
        if($("#dept").val()==null)
            alert("Please select course");
        else{
            $.get("assignteacher.jsp?dept="+$("#dept").val(),function(data){
                $("#assignthr").html(data);
            });
        }
    }
    function enablebtn(){
        $("#adbtn").attr("disabled",false);
    }
</script> 

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Use.EsConnection" %>
<%! Connection con;%>
<h3>Fill Form to add <strong>Course</strong> : </h3>
<form action="/Time/addcourse">
    <table>
        <tr>
            <td>Course Id : </td>
            <td><input type="text" name="Cid"/></td>
        </tr>
        <tr>
            <td>Course Name : </td>
            <td><input type="text" name="Cname"/></td>
        </tr>
        <tr>
            <td>Branch Name : </td>
            <td><select name="brname">
                <%
                        try{
                            con=EsConnection.getConnection();
                            Statement st=con.createStatement();
                            ResultSet rs=st.executeQuery("select distinct * from branch");
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
            <td>Year : </td>
            <td><select name="Cy">
                    <option>1<sup>st</sup></option>
                    <option>2<sup>nd</sup></option>
                    <option>3<sup>rd</sup></option>
                    <option>4<sup>th</sup></option>
                </select></td>
        </tr>
        <tr>
            <td>Department : </td>
            <td><select id="dept" name="Cdept" onchange="setTeacher();"><option value="null">--Select Department--</option>
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
            <td>Assign Teacher : </td>
            <td id="assignthr"><select><option>--Select Teacher--</option></select></td>
        </tr>
        <tr>
            <td>Theory Lec. : </td>
            <td><input type="number" name="theory"/></td>
        </tr>
        <tr>
            <td>Practicals : </td>
            <td><input type="number" name="practicals"/></td>
        </tr>
        
        <tr>
            <td></td>
            <td><input type="submit" value="Add Course"  id="adbtn" disabled/></td>
        </tr>
    </table>
</form>