<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE.</title>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap"
    rel="stylesheet">
    <style>
    	body{
            color: cornsilk;
            margin: 0px;
            padding: 0px;
            font-family: 'Baloo Bhai 2', cursive;
            background-image: url('bg.jpg');
            background-size: 100% 100%;
            background-repeat: no-repeat;
           	background-color: black;
        }
        h1{
            text-transform: uppercase;
            margin: 20px;
            padding: 30px;
        }
        .box{
            padding: 50px;
            width: 500px;
            margin: 30px auto;
            box-shadow: 0 0 20px white;
        }
        a{
        
            font-size: 20;
            text-align:center;
            color: cornsilk;
            border: 1px dashed cornsilk;
            border-radius: 25px;
            margin: 3px;
            margin-top: 20px;
            padding: 12px 40px;
            
        }
        a:hover{
            text-decoration: underline;
            color:lavenderblush;
            cursor: pointer;
        }
    </style>
</head>
<body>
	<h1 align="center">Hello, Unregistered User!!</h1>
        <h2 align="center">
            <div class="box">
	            <a href="${path}/login">Login</a>
        	</div>
        </h2>
</body>
</html>
