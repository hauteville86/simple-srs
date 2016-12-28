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
			<th>Comment</th>
			<th>Created on:</th>
		</tr>

		<c:forEach var="deck" items="${decks}">

			<tr>
				<td>${deck.name}</td>
				<td>${deck.language}</td>
				<td>${deck.comment}</td>
				<td>${deck.created}</td>
				<td>
					<c:url var="openLink" value="/showDeck">
						<c:param name="id" value="${deck.id}"/>
					</c:url>
					<a href="${openLink}">Open</a>
				</td>
			</tr>

		</c:forEach>
</body>
</html>