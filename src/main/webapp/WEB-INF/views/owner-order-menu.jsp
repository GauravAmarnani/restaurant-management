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
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap"
    rel="stylesheet">
    <title>Order</title>
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
        .btn1, .btn2{
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
        .lbl1{
            display: inline-block;
        }
        .lbl2{
            display: block;
        }
        .item{
            color: white;
            margin: 5px;
            font-size: 1.4em;
            padding: 5px;
        }
        input{
            color: white;
            font-size: 0.8em;
        }
        .item1{
            margin-left: 33px;
        }
        .item2{
            margin-left: 4px;
        }
        .item3{
            margin-left: 41px;
        }
        .item4{
            margin-left: 12px;
        }
        .btn2:hover{
            background-color: white;
            color: black;
            cursor: pointer;
        }
    </style>
</head>
<body>
	<div class="container">
		<form:form method="POST" action="${path}/owner/ordermenu/search" modelAttribute="menuItem">
				<h4>Select an Item:</h4> 
				<form:select path="id" items="${list}"/>
				<br /> <input class="btn1" type="submit" value="Search" />
			
		</form:form>
		<br />
		
		<c:if test="${!empty orderMenuItem}">
			<form:form method="POST" action="add" modelAttribute="orderMenuItem">
				<div class="lbl1 item">
            		<label for="name">Name:</label> 
            		<form:input class="item1" path="itemName"/> <br />
            	</div>
            	<div class="lbl2 item">
            		<label for="name">Quantity:</label> 
            		<form:input class="item2" path="itemQuantity"/> <br />
            	</div>
            	<div class="lbl3 item">
            		<label for="name">Price:</label> 
            		<form:input class="item3" path="itemPrice"/> <br />
            	</div>
            	<div class="lbl4 item">
            		<label for="name">Number:</label> 
            		<form:input class="item4" path="itemNumber"/> <br />
            	</div>
				<input class="btn2" type="submit" value="Add" />
			</form:form>
		</c:if>
	</div>
</body>
</html>