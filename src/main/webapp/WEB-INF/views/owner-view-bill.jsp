<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
    <title>List of Bills</title>
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
            box-shadow: 0 0 20px white;
            padding: 10px;
        }
        h4{
            text-align: center;
            color: white;
            font-size: 2em;
            display: inline-block;
            padding: 20px;
        }
        select{
            color: white;
            padding: 10px;
            font-size: 1em;
        }
        .btn1{
            color: white;
            padding: 10px 0 10px 0;
            width: 100px;
            border-radius: 15%;
            display: block;
            margin: 10px auto;
        }
        .btn1:hover{
            background-color: white;
            color: black;
            cursor: pointer;
        }
    </style>
</head>
<body>
	<div class="container">
		<form:form method="POST" action="${path}/owner/viewbill/display" modelAttribute="bill">
			<h4>Select a Bill:</h4> 
			<form:select path="displayId" items="${list}"/>
			<br /> <input type="submit" value="Search" class="btn1" />
		</form:form>
	</div>
</body>
</html>