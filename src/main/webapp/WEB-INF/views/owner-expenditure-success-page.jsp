<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenditure Successfully Added.</title>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap"
    rel="stylesheet">
    <title>Expenditure Successfully Added</title>
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
            padding: 10px;
        }
        h1{
            color: white;
            font-weight: normal;
        }
        a{
            color: white;
            font-size: 1.1em;
        }
        a:hover{
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
	<h1>Successfully Added all the expenditures.</h1>
	<h1>Total amount spent: ${amount}</h1>
	<a href="${path}/owner">Done.</a>
</div>
</body>
</html>