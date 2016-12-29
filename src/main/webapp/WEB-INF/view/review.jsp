<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deck</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<c:set var="answerChecked" value="false" />
	<table>
		<tr>
			<h4>${card.front}</h4>
		</tr>
		<tr>
			<c:if test="${answerChecked}">
				<h4>${card.back}</h4>
			</c:if>
		</tr>
	</table>
	<div class="btn-group">
		<c:choose>
			<c:when test="${answerChecked}">
				<button></button>
			</c:when>
			<c:otherwise>
				<button id="srs-button-1" class="btn btn-primary">0</button>
				<button id="srs-button-2" class="btn btn-primary">1</button>
				<button id="srs-button-3" class="btn btn-primary">2</button>
				<button id="srs-button-4" class="btn btn-primary">3</button>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>