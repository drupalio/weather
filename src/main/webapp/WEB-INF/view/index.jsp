<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body class="container">
	<form action="/weather" method="get">
		<h2>Weather api test</h2>
		<div class="form-group">
			<label for="exampleFormControlFile1">Select you city:</label> 
			<select
				name="city" class="field-select">
				<option value="2643743">London</option>
				<option value="1819729">Hong Kong</option>
			</select>
		</div>
		<input class="btn btn-primary" type="submit" value="Submit" />
	</form>
	<script type="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>
