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
		<tr>
			<th>Id</th>
			<th>Front</th>
			<th>Back</th>
			<th>SRS status:</th>
		</tr>

		<c:forEach var="card" items="${cards}">
			<tr>
				<td>${card.id}</td>
				<td>${card.front}</td>
				<td>${card.back}</td>
				<td>${card.srsStatus}</td>
				<td>
					<c:url var="openLink" value="/showDeck">
						<c:param name="id" value="${deck.id}"/>
					</c:url>
					<a href="${openLink}">Open</a>
				</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>