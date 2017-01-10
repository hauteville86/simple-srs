<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Decks</title>
<link rel="stylesheet" href="resources/css/modal.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<script src="resources/js/ajax-utils.js"></script>
</head>
<body>
	<div class="btn-group" id="testview-deck-buttons">
		<c:url var="addDeck" value="/addDeck">
			<c:param name="page" value="decklist" />
		</c:url>
		<div id="add-deck-btn" class="btn btn-primary">
			Add deck
		</div>
		<!-- Modal content -->
		<div class="modal-content" id="modal-content">
			<div class="modal-header">
				<span class="close">&times;</span>
				<h2>Add new deck</h2>
			</div>
			<div class="modal-body">
				<form:form action="/addDeck" modelAttribute="deck" method="POST">	
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" type="text" /></td>
					</tr>

					<tr>
						<td><label>Language:</label></td>
						<td><form:input path="language" type="text" /></td>
					</tr>

					<tr>
						<td><label>Comment:</label></td>
						<td><form:input path="comment" type="text" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>
			</div>
		</div>
	</div>
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
				<td><c:url var="openLink" value="/showDeck">
						<c:param name="id" value="${deck.deck.id}" />
					</c:url> <c:url var="deleteLink" value="/deleteDeck">
						<c:param name="id" value="${deck.deck.id}" />
						<c:param name="page" value="decklist" />
					</c:url> <a href="${openLink}">Open</a>|<a href="${deleteLink}">Delete</a>
				</td>
			</tr>

		</c:forEach>
	</table>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/decklist-script.js"></script>
</body>
</html>