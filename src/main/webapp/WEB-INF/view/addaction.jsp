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
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">


<script src="resources/js/ajax-utils.js"></script>
<link rel="import" href="WEB-INF/view/navbar.html">
</head>
<body>
	<%@include file="/resources/html/navbar.html" %>
	<h2>Add action</h2>
	<form:form action="addNewAction" modelAttribute="action" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>Action:</label></td>
					<td><form:input path="action" type="text" /></td>
				</tr>

				<tr>
					<td><label>Time amount(min):</label></td>
					<td><form:input path="time" type="number" min="0"/></td>
				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>

			</tbody>
		</table>
	</form:form>

	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/decklist-script.js"></script>
</body>
</html>