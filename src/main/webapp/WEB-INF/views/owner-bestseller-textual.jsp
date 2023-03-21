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
<title>Best Seller</title>
</head>
<body>
	<h1 align="center">Best Sellers!</h1>
	<c:if test="${!empty listOfRecords}">
		<table class="tg" bordercolor="red" border="1px">
			<tr>
				<th width="100">Name</th>
				<th width="100">Number</th>
			</tr>
			<c:forEach items="${listOfRecords}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.number}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<h2>
		<a href="${path}/owner">Home.</a> <br> <br>
		<a href="${path}/owner/bestsellergraphical">Graphical Format.</a> 
	</h2>
</body>
</html>