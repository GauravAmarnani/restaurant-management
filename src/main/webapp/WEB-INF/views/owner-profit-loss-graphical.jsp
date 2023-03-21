<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
 
map = new HashMap<Object,Object>(); map.put("label", "1st"); map.put("y", -186000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "2nd"); map.put("y", -171000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "3rd"); map.put("y", -168000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "4th"); map.put("y", -161000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "5th"); map.put("y", -154000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "6th"); map.put("y", -129000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "7th"); map.put("y", -108000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "8th"); map.put("y", -88000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "9th"); map.put("y", -74000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "11th"); map.put("y", -59000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "12th"); map.put("y", -48000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "13th"); map.put("y", -38000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "14th"); map.put("y", -31000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "15th"); map.put("y", -16000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "16th"); map.put("y", -2000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "17th"); map.put("y", 8000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "18th"); map.put("y", 17000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "19th"); map.put("y", 33000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "20th"); map.put("y", 35000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "21st"); map.put("y", 50000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "22nd"); map.put("y", 54000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "23rd"); map.put("y", 59000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "24th"); map.put("y", 70000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "25th"); map.put("y", 77000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "26th"); map.put("y", 84000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "27th"); map.put("y", 87000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "28th"); map.put("y", 99000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "29th"); map.put("y", 107000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "30th"); map.put("y", 113000); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "31st"); map.put("y", 127000); list.add(map);

String dataPoints = gsonObj.toJson(list);
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "Proit Loss Analysis for RMS."
	}, 	
	axisX: {
		title: "March 2022."
	},
	axisY: {
		title: "Sales (in Rs. ₹)",
		includeZero: true
	},
	data: [{
		type: "line",
		yValueFormatString: "#,##,###₹",
		dataPoints : <%out.print(dataPoints);%>
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
	<a href="${path}/owner/profitlosstextual">Textual Format.</a>
</h1>
</body>
</html>