<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OWNER PAGE</title>
</head>
<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap" rel="stylesheet">
<style>
    body {
    	background-color : black;
        color: rgb(245, 234, 190);
        margin: 0px;
        padding: 0px;
        font-family: 'Baloo Bhai 2', cursive;
        background-image: url('bg.jpg');
        background-size: 100% 100%;
        background-repeat: no-repeat;
    }

    h1 {
    	color: wheat;
        text-transform: uppercase;
        margin: 10px;
        padding: 20px;
    }

    .box {
        display: grid;
        grid-template-columns: 2fr 2fr 2fr;
        padding: 20px;
        margin: 30px;
        box-shadow: 0 0 20px white;
        border-radius: 4px;         
    }

    a {	
    	color: wheat;
        font-size: 25px;
        text-align: center;
        border: 1px dashed rgb(238, 222, 159);
        box-shadow: 0 0 40px rgba(0, 0, 0, 0.2);
        border-radius: 25px;
        margin: 3px;
        margin-top: 20px;
        padding: 12px 40px;
    }

    a:hover {
        color:  lavenderblush;
        text-decoration: underline;
        cursor: pointer;
    }
</style>
<body>
	<h1 align="center">Welcome ${username}</h1>
	<div class="box">
			<a href="${path}/owner/addmenu">Add Menu Items.</a> <br> <br> 
			<a href="${path}/owner/ordermenu">Order Menu Items.</a> <br> <br> 
			<a href="${path}/owner/viewbill">View Bills.</a> <br> <br> 
			<a href="${path}/owner/expenditure">Add Expenditure.</a> <br> <br>
			<a href="${path}/owner/profitlosstextual"> View Profit Loss Statements. </a> <br> <br>
			<a href="${path}/owner/bestsellertextual"> View Best Seller. </a> <br> <br>
			<a href="${path}/logout">Logout.</a> 
	</div>
</body>
</html>