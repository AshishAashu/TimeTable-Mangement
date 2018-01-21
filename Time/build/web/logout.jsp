<%-- 
    Document   : logout
    Created on : Jul 24, 2017, 4:05:39 PM
    Author     : AshishAashu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    session.invalidate();
%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout Page</title>
        <script>
            window.onload=function(){
                alert("Logout Successful...");
            };
        </script>
    </head>
         <%
         %>  
</html>
