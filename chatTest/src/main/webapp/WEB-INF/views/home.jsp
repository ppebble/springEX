<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SOCKET</title>
        <style>
            #chat_box{
                width: 800px;
                min-width: 800px;
                height: 500px;
                min-height: 500px;
                border: 1px solid #999;
            }
            #msg{
                width: 700px;
            }
            #msg_process{
                width: 90px;
            }
            
            
        </style>
    </head>
    <body>
        <div id="chat_box">
        	☞  /q to exit ☜
        </div>
        <input type="text" id="msg">
        <button id="msg_process">SEND</button>
        
        <script src="http://localhost:82/socket.io/socket.io.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script>
            $(document).ready(function(){
                alert("welcome");
                var socket = io("http://localhost:82");

                $("#msg").keydown(function(key){
                    if(key.keyCode==13){
                        msg_process.click();
                    }
                });

                $("#msg_process").click(function(){
                    socket.emit("send_msg", $("#msg").val());
                    if($("#msg").val() == '/q'){
                    	window.close();
                    }
                    $("#msg").val("");
                });
                socket.on('send_msg', function(msg){
                	$('<div></div>').text(msg).appendTo("#chat_box");
                });
 
            });
        </script>
    </body>
</html>
