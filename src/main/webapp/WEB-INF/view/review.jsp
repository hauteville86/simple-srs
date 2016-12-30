<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deck</title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/script.js"></script>
<script src="resources/js/ajax-utils.js"></script>
</head>
<body>
	<c:set var="answerChecked" value="false" />
	<table>
		<tr>
			<div id="front">${card.front}</div>
		</tr>
		<tr>
			<div id="back" >${card.back}</div>
		</tr>
	</table>
		<button id="go-to-next-button" class="btn btn-primary">Check the answer</button>
	<div class="btn-group" id="srs-buttons">			
				<button id="srs-button-1" class="btn btn-primary">0</button>
				<button id="srs-button-2" class="btn btn-primary">1</button>
				<button id="srs-button-3" class="btn btn-primary">2</button>
				<button id="srs-button-4" class="btn btn-primary">3</button>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>