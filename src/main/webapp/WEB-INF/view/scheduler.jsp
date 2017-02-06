<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Utilities</title>
<link rel="stylesheet" href="resources/css/modal.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<script src="resources/js/ajax-utils.js"></script>
</head>
<body>
	<a href="/addAction" class="btn btn-default">Add action</a>
	<c:forEach items="${utilities}" var="utility">
		<h3>${utility.name}</h3>
	</c:forEach>

	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/decklist-script.js"></script>
</body>
</html>