<%-- 
    Document   : welcome
    Created on : Jun 26, 2017, 12:22:07 PM
    Author     : AshishAashu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome:Admin</title>
        <style>
            .ul{
                list-style-type: none;
                display:block;
            }
            .ul li{
                display:block;
                float:left;
                font-family: cursive;
                font-kerning: normal;
                margin:0px 10px 0px 10px;
                padding:2px 5px 2px 5px;
            }
            .ul li:hover{
                cursor: default;
                background: #E217CC;
                color:white;
                font-family: cursive;
            }
            .content{
                display:block;
                margin-top:20px;
            }
        </style>
        <script src="jquery-3.2.1.min.js"></script>
        <script>
            function call(x){
                if(x=='AT'){
                    $.get("Addteacher.jsp",function(data){
                        $('#content').html(data);
                    });                    
                }
                if(x=='AC'){
                    $.get("Addcourse.jsp",function(data){
                        $('#content').html(data);
                    });                    
                }
                if(x=='VT'){
                    $.get("ViewTeacher.jsp",function(data){
                        $('#content').html(data);
                    });
                }
                if(x=='VC'){
                    $.get("viewcourse.jsp",function(data){
                        $('#content').html(data);
                    });
                }
                if(x=='AR'){
                    $.get("room.jsp",function(data){
                        $('#content').html(data);
                    });
                }
                if(x=='GT'){
                    $.get("FinalTimeTable",function(data){
                        $('#content').html(data);
                    });
                }
                
            }
        </script>
    </head>
    <body>
    <center>
        <div style="display:inline-block;">
            <nav>
                <ul class="ul">
                    <li onclick="call('AT');">Add Teacher</li>
                    <li onclick="call('AC');">Add Course</li>
                    <li onclick="call('AR');">Add Room</li>
                    <li onclick="call('VT');">View Teacher</li>
                    <li onclick="call('VC');">View Course</li>
                    <li onclick="call('GT');">Get Table</li>
                </ul>
                
            </nav>
            <hr>
        </div>
        <div id="content" class="content">
            
        </div>
    </center>        
    </body>
</html>
