<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deck</title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/script.js"></script>
<script src="resources/js/ajax-utils.js"></script>

<div id="nav-placeholder" />
</head>
<body>
	<c:set var="answerChecked" value="false" />
	<table>
		<tr>
			<h4>
				<div id="front" class="card-front-text">${card.front}</div>
			</h4>
		</tr>
		<tr>
			<h4>
				<div id="back" class="card-back-text">${card.back}</div>
			</h4>
		</tr>
	</table>
	<button id="go-to-next-button" class="btn btn-primary">Check
		the answer</button>
	<div class="btn-group" id="srs-buttons">
		<c:forEach var="button" items="${buttons}">
			<c:url var="updateCard" value="/updateCard">
				<c:param name="cardId" value="${card.id}" />
				<c:param name="srsLevel" value="${button.srsLevel}" />
			</c:url>
			<a href="${updateCard}" class="btn btn-primary">${button.text}</a>
		</c:forEach>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$.get("navigation.html", function(data) {
			$("#nav-placeholder").replaceWith(data);
		});
	</script>

</body>
</html>