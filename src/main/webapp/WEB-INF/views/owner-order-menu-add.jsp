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
    <title>Menu Item Added!</title>
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
        h1, h3{
            color: white;
            margin: 20px;
            text-align: center;
        }
        .h3-tag{
            color: wheat;
        }
        .table-fill {
            background: white;
            border-radius:3px;
            border-collapse: collapse;
            /* height: 320px; */
            margin: auto;
            max-width: 600px;
            padding:5px;
            width: 100%;
            box-shadow: 0 5px 10px white;
        }
 
        th {
            color:black;
            background: rgb(245, 234, 190);
            border-bottom:4px solid rgb(245, 234, 190);
            /* border-right: 1px solid #343a45; */
            font-size:23px;
            /* font-weight: 100; */
            padding:12px;
            text-align:left;
            /* text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1); */
            vertical-align:middle;
        }

        /* th:first-child {
            border-top-left-radius:3px;
        } */
 
        /* th:last-child {
            border-top-right-radius:3px;
            border-right:none;
        } */
  
        tr {
            border-top: 1px solid rgb(245, 234, 190);
            border-bottom: 1px solid rgb(245, 234, 190);
            color:black;
            font-size:16px;
            font-weight:normal;
            /* text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1); */
        }
 
        /* tr:hover td {
            background:#4E5066;
            color:#FFFFFF;
            border-top: 1px solid #22262e;
        } */
 
        /* tr:first-child {
            border-top:none;
        } */
/* 
        tr:last-child {
            border-bottom:none;
        } */
 
        tr:nth-child(odd) td {
            background:#f3f3f3;
        }
 
        /* tr:nth-child(odd):hover td {
            background:#4E5066;
        } */

        /* tr:last-child td:first-child {
            border-bottom-left-radius:3px;
        } */
 
        /* tr:last-child td:last-child {
            border-bottom-right-radius:3px;
        } */
 
        td {
            background:#FFFFFF;
            padding:20px;
            text-align:left;
            vertical-align:middle;
            font-weight:300;
            font-size:18px;
            text-shadow: -1px -1px 1px rgb(245, 234, 190);
            /* border-right: 1px solid #C1C3D1; */
        }

        td:last-child {
            border-right: 0px;
        }

        th.text-left {
            text-align: left;
        }

        th.text-center {
            text-align: center;
        }

        th.text-right {
            text-align: right;
        }

        td.text-left {
            text-align: left;
        }

        td.text-center {
            text-align: center;
        }

        td.text-right {
            text-align: right;
        }
        a{
            display: block;
            text-align: center;
            margin: 20px;
            color: white;
            text-decoration: none;
        }
        a:hover{
            color: red;
            text-decoration: underline;
        }
    </style>
</head>
<body>
	<div class="heading">
		<h1 align="center">Menu Item Added!</h1>
	</div>
		<c:if test="${!empty listOfOrderMenuItem}">
			<hr>
			<div class="heading">
				<h3 class="h3-tag">List of Ordered Menu Items:</h3>
			</div>
		<div class="container">
        	<table class="table-fill">
				<thead>
					<tr>
						<th class="text-left" width="100">Name</th>
						<th class="text-left" width="100">Quantity</th>
						<th class="text-left" width="100">Price</th>
						<th class="text-left" width="100">Number</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listOfOrderMenuItem}" var="item">
						<tr>
							<td class="text-left">${item.itemName}</td>
							<td class="text-left">${item.itemQuantity}</td>
							<td class="text-left">${item.itemPrice}</td>
							<td class="text-left">${item.itemNumber}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<a href="${path}/owner/ordermenu">Add More.</a> <br> <br> 
	<a href="${path}/owner/ordermenu/confirm">Confirm Order.</a> <br> <br> 
	<a href="${path}/owner/ordermenu/cancel">Cancel.</a> <br> <br> 
</body>
</html>