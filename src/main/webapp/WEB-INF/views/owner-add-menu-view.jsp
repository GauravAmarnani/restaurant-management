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
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap" rel="stylesheet">
    <title>Table</title>
</head>
<style>
  * {
    font-family: 'Baloo Bhai 2', cursive; /* Change your font family */
    margin: 0;
    padding: 0;
}

.container{
  width: 700px;
  margin: 0 auto;
}
body{
background-color: black;
}
h3{
    text-transform: capitalize;
    color: white;
    font-size: 2em;
    margin-top: 50px;
    text-align: center;
}

.content-table {
  border-collapse: collapse;
  margin: 50px 150px;
  font-size: 0.9em;
  min-width: 400px;
  border-radius: 5px 5px 0 0;
  overflow: hidden;
  box-shadow: 0 0 20px white;
}

.content-table thead tr {
  background-color: rgb(245, 234, 190);
  color: black;
  text-align: left;
  font-weight: bold;
}

.content-table th,
.content-table td {
  padding: 12px 15px;
}

.content-table tbody tr {
  border-bottom: 1px solid  rgb(245, 234, 190);
}

.content-table tbody tr{
  background-color: #f3f3f3;
}

.content-table tbody tr:last-of-type {
  border-bottom: 2px solid  rgb(245, 234, 190);
}


</style>
<body>
	<c:if test="${!empty listOfItems}">
		<h3 align="center" style="color: green;">List of Menu Items:</h3>
		<div class="container">
      	<table class="content-table">
			<tr>
				<th width="100">Name</th>
				<th width="100">Quantity</th>
				<th width="100">Price</th>
			</tr>
			<c:forEach items="${listOfItems}" var="item">
				<tr>
					<td>${item.itemName}</td>
					<td>${item.itemQuantity}</td>
					<td>${item.itemPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>