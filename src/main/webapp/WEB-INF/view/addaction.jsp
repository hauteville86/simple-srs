<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add action</title>
<link rel="stylesheet" href="resources/css/modal.css">

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">

<script src="resources/js/ajax-utils.js"></script>
<link rel="import" href="WEB-INF/view/navbar.html">
</head>
<body>
	<%@include file="/resources/html/navbar.html" %>
	<div class="container container-2">
	<h2>Add action</h2>
	<form:form action="addNewAction" modelAttribute="action" method="POST">
	<div class="row form-group">
    	<label class="col-md-4">Action:</label>
    	<div class="col-md-8"><form:input path="action" type="text" class="form-control"/></div>
	</div>
	<div class="row form-group">
    	<label class="col-md-4">Time amount(min):</label>
    	<div class="col-md-8"><form:input path="time" type="number" min="0" class="form-control"/></div>
	</div>
	<div class="row form-group">
    	
    	<div class="col-md-8 col-md-push-4"><input type="submit" value="Save" id="add-deck-btn" class="  save btn btn-primary " /></div>
	</div>
	
	</form:form>
</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/decklist-script.js"></script>
</body>
</html>