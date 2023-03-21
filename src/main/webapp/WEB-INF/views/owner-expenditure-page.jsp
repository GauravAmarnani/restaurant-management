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
<title>Add Expenditure.</title>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap"
    rel="stylesheet">
    <style>
        *{
            margin: 0;
            padding: 0;
            background-color: black;
            font-family: 'Baloo Bhai 2', cursive;
        }
        .container{
            width: 800px;
            margin: 0 auto;
            box-shadow: 0 5px 10px white;
            padding: 10px;
        }
        label{
            color: white;
            font-size: 1.5em;
            margin-right: 10px;
        }
        .txt{
            color: white;
            font-size: 18px;
        }
        .btn{
            margin: 20px auto 20px;
            display: block;
            padding: 8px 25px 8px 25px;
            color: white;
            border-radius: 10px;
            font-size: 1em;
        }
        .btn:hover{
            cursor: pointer;
            color: black;
            background-color: white;
        }
        h3{
            color: white;
            font-weight: normal;
            font-size: 1.5em;
        }
        p{
            color: white;
            font-size: 1.5em;
        }
    </style>
</head>
<body>
<div class="container">
	<form:form action="${path}/owner/addexpenditure" method="POST" modelAttribute="expenditure">
		<label for="expenditure">Enter Expenditure:</label> <form:input class="txt" path="allExpenditures"/><br />
		<input class= "btn"type="submit" value="Add." />
	</form:form>
	<h3>	Format:</h3> <br />
	<p>	Syntax : [{Name of Expenditure} : {Amount Spent} ,] -> for each expenditure. <br /> 
		Eg: Raw Materials : 10000 , Staff : 10000 , Electricity Bill : 4000 , ....
	</p>
</div>
</body>
</html>