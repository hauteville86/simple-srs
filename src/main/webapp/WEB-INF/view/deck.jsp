<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deck</title>
</head>
<body>
	<table>
		<h3>Deck name: ${deck.name}</h3>
		<h3>Language: ${deck.language}</h3>
		<tr>Created: ${deck.created}</tr>
		<tr>Cards to review: ${deckInfo.numOfCardsToReview}</tr>

		<c:url var="reviewLink" value="/startReview">
			<c:param name="id" value="${deck.deck.id}"/> 
		</c:url>
		<a href="${reviewLink}">Review</a>
	</table>
</body>
</html>