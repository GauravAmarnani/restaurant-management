<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>bill</title>
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
            width: 700px;
            margin: 0 auto;
            box-shadow: 0 5px 10px white;
            padding: 10px;
        }
        h2{
            color: white;
            padding: 10px;
            /* text-align: center; */
        }
        a{
            color: white;
            /* margin: 0 auto; */
            font-size: 1.2em;
        }
        a:hover{
            color: red;
            text-decoration: underline;
        }
    </style>
</head>
<body>
	<div class="container">
		<h2>${content}</h2>
		<a href="${path}/owner">Continue.</a>
	</div>
</body>
</html>