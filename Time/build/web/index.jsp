<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! int flag=0;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time:Login</title>
    </head>
    <body>
    <center>
        <%
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
        %>
        <%
            if(flag==1)
            {
                //out.println("<script>alert('Login Successful.');</script>");
                response.sendRedirect("welcome.jsp");
            }
            else if(flag==2){
                out.println("<h2>Login Fail....!!!</h2>");
            }
        %>
        <div>
            <form action="">
            <label>User Id :</label>
            <input type="text" placeholder="Enter User Id" name="id"/></br>
            <label>Password :</label>
            <input type="password" placeholder="Enter Password" name="pass"/></br>
            <input type="submit" value="login" name="sub"/>
            </form>
        </div>
    </center>    
    </body>
</html>
