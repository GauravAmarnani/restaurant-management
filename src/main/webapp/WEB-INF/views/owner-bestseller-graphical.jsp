<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
 
map = new HashMap<Object,Object>(); map.put("label", "Chicken Handi-F"); map.put("y", 5); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Handi-H"); map.put("y", 4); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Manchurian-F"); map.put("y", 6); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Manchurian-H"); map.put("y", 14);  list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Tandoori-F"); map.put("y", 20); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Tandoori-H"); map.put("y", 14); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Sandwich-F"); map.put("y", 26); list.add(map);
 
String dataPoints = gsonObj.toJson(list);
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	title: {
		text: "Items Sold in RMS."
	},
	axisX: {
		title: "April 2022."
	},
	axisY: {
		title: "Number.",
		includeZero: true
	},
	data: [{
		type: "column",
		yValueFormatString: "Total Sold :#,##0#",
		dataPoints: <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<br> <br>
<h1>
	<a href="${path}/owner/bestsellertextual">Textual Format.</a>
</h1>
</body>
</html> 

<!-- 

map = new HashMap<Object,Object>(); map.put("label", "Chicken Handi-F"); map.put("y", 5); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Handi-H"); map.put("y", 4); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Manchurian-F"); map.put("y", 6); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Manchurian-H"); map.put("y", 14);  list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Tandoori-F"); map.put("y", 20); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chicken Tandoori-H"); map.put("y", 14); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Sandwich-F"); map.put("y", 26); list.add(map);

 -->