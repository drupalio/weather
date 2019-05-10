<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body class="container">
	<div class="alert alert-error" role="alert">
		<h4 class="alert-heading">Weather Error Page</h4>
		<li>
		        <label>Something went wrong when consulting the weather service: </label>
		        <br>
		        <textarea name="json" class="field-long field-textarea">${message}</textarea>
		</li>
		<a href="/"><button class="btn btn-primary">Back to home</button></a>
	</div>
	<script type="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>
