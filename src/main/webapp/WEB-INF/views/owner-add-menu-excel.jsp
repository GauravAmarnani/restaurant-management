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
<title>Add Menu Items.</title>
</head>
<body>
	<c:if test="${!empty sqlErrorMessage}">
		<h1 align="center" style="color: red;">${sqlErrorMessage}</h1>
	</c:if>
	<c:if test="${empty sqlErrorMessage}">
		<c:if test="${!empty errorMessage}">
			<h1 align="center" style="color: red;">${errorMessage}</h1>
		</c:if>
		<c:if test="${empty errorMessage}">
			<c:if test="${empty lstUser}">
				<h1>Add Excel Sheet: </h1>
				<form:form
					action="${path}/owner/processExcel?${_csrf.parameterName}=${_csrf.token}"
					method="POST" enctype="multipart/form-data">
					<input name="excelfile" type="file">
					<input type="submit" value="processExcel">
				</form:form>
			</c:if>
			<c:if test="${!empty lstUser}">

				<hr>
				<h3 align="center" style="color: green;">Successfully inserted
					the following list into database:</h3>
				<table class="tg">
					<tr>
						<th width="100">Name</th>
						<th width="100">Quantity</th>
						<th width="100">Price</th>
					</tr>
					<c:forEach items="${lstUser}" var="user">
						<tr>
							<td>${user.itemName}</td>
							<td>${user.itemQuantity}</td>
							<td>${user.itemPrice}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</c:if>
	</c:if>
</body>
