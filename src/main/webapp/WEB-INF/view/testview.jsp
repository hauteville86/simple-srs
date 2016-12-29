<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Decks</title>
</head>
<body>
	<table>

		<tr>
			<th>Name</th>
			<th>Language</th>
			<th>Cards to review</th>
		</tr>

		<c:forEach var="deck" items="${decks}">

			<tr>
				<td>${deck.deck.name}</td>
				<td>${deck.deck.language}</td>
				<td>${deck.numOfCardsToReview}</td>
				<td>
					<c:url var="openLink" value="/showDeck">
						<c:param name="id" value="${deck.deck.id}"/>
					</c:url>
					<a href="${openLink}">Open</a>
				</td>
			</tr>

		</c:forEach>
</body>
</html>