<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>μμΌ μλ²</title>
    </head>
    <body>
    
    
        <script src="http://localhost:82/socket.io/socket.io.js"></script>
        <script src="https://code.jquery.com/jquery-1.11.1.js"></script>
        <script>
            $(document).ready(function(){
                var socket = io("http://localhost:82");
            });
        </script>
    </body>
</html>
