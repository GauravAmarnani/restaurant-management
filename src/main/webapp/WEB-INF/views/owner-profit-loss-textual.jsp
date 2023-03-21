<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	animationEnabled: true,
	title: {
		text: "Average Sea Temperature - Amsterdam"
	},
	axisX: {
		valueFormatString: "MMM"
	},
	axisY: {
		title: "Temperature (in °C)",
		includeZero: true,
		suffix: " °C"
	},
	data: [{
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "MMM",
		yValueFormatString: "#,##0 °C",
		dataPoints: dps[0]
	}]
});
 
var xValue;
var yValue;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		xValue = parseInt("${dataPoint.x}");
		yValue = parseFloat("${dataPoint.y}");
		dps[parseInt("${loop.index}")].push({
			x : xValue,
			y : yValue
		});		
	</c:forEach>	
</c:forEach> 
 
chart.render();
 
}
</script>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@700&family=Grechen+Fuemen&display=swap" rel="stylesheet">
	<title>Bill.</title>
</head>
<style>
	* {
    	margin: 0;
        padding: 0;
        background-color: black;
        font-family: 'Baloo Bhai 2', cursive;
    }
    .container {
        width: 700px;
        margin: 0 auto;
        box-shadow: 0 5px 10px white;
        padding: 10px;
    }
    h2 {
        color: white;
        padding: 10px;
    }
    a {
        color: white;
        font-size: 1.2em;
    }
    a:hover {
        color: red;
        text-decoration: underline;
    }
</style>
<body>
	<div class="container">
		<h2>${content}</h2>
		<h2>
			<a href="${path}/owner">Back.</a> <br> <br>
			<a href="${path}/owner/profitlossgraphical">Graphical Format.</a>
		</h2>
	</div>
</body>
</html>
