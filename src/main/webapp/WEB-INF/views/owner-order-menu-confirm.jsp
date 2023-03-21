<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap"
    rel="stylesheet">
    <title>Confirmed Order!</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            background-color: black;
            font-family: 'Baloo Bhai 2', cursive;
        }
        .container{
            width: 700px;
            margin: 0 auto;
            box-shadow: 0 5px 10px white;
            padding-bottom: 3px;
        }
        label{
            color: white;
            font-size: 1.25em;
            margin: 15px;
        }
        input{
            font-size: 1.2em;
            color: white;
        }
        .btn{
            display: block;
            margin: 24px auto;
            padding: 0 20px;
            border-radius: 10px;
        }
        .btn:hover{
            cursor: pointer;
            background-color: #fff;
            color: black;
        }
    </style>
</head>
<body>
	<div class="container">
		<form:form action="${path}/owner/ordermenu/done" method="POST" modelAttribute="user">
			 <label for="passage">Enter Customer Name:</label> <form:input id="passage" path="name"/> <br />
			<input type="submit" value="Done." class="btn" />
		</form:form>
	</div>
</body>
</html>