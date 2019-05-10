<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body class="container">
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Field</th>
				<th scope="col">Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">1</th>
				<td>Date</td>
				<td>${response.date}</td>
			</tr>
			
			<tr>
				<th scope="row">2</th>
				<td>City</td>
				<td>${response.city}</td>
			</tr>
			
			<tr>
				<th scope="row">3</th>
				<td>Weather</td>
				<td>${response.weather}</td>
			</tr>
			
			<tr>
				<th scope="row">4</th>
				<td>Weather description</td>
				<td>${response.weatherDesc}</td>
			</tr>
			
			<tr>
				<th scope="row">5</th>
				<td>Temperature Farenheit</td>
				<td>${response.tempFa}</td>
			</tr>
			
			<tr>
				<th scope="row">6</th>
				<td>Temperature Celcius</td>
				<td>${response.tempCe}</td>
			</tr>
			
			<tr>
				<th scope="row">7</th>
				<td>Sunrise</td>
				<td>${response.sunrise}</td>
			</tr>
			
			<tr>
				<th scope="row">8</th>
				<td>Sunset</td>
				<td>${response.sunset}</td>
			</tr>
						
		</tbody>
	</table>
	<script type="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>
