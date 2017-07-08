<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deck</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<script src="resources/js/script.js"></script>
<script src="resources/js/ajax-utils.js"></script>

<div id="nav-placeholder" />
</head>
<body>
	<%@include file="/resources/html/navbar.html" %>
	<div class="container container-2 text-center">
	<c:set var="answerChecked" value="false" />
	<h2 id="front-review-session" class="card-front-text">${card.front}</h2>
	<h2 id="back-review-session" class="card-back-text">${card.back}</h2>
	<div class="button-div-2 text-center">
	<button id="go-to-next-button" class="btn btn-primary">Check the answer</button>
	<div class="btn-group " id="srs-buttons">
		<c:forEach var="button" items="${buttons}">
			<c:url var="updateCard" value="/updateCard">
				<c:param name="cardId" value="${card.id}" />
				<c:param name="srsLevel" value="${button.srsLevel}" />
			</c:url>
			<a href="${updateCard}" class="btn btn-primary">${button.text}</a>
		</c:forEach>
	</div>
	</div>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>