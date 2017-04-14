<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deck</title>
<link rel="stylesheet" href="resources/css/modal.css">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="import" href="WEB-INF/view/navbar.html">
</head>
<body>
	<%@include file="/resources/html/navbar.html" %>
	<table>
		<h3>Deck name: ${deck.name}</h3>
		<h3>Language: ${deck.language}</h3>
		<tr>Created: ${deck.created}
		</tr>
		<tr>Cards to review: ${deckInfo.numOfCardsToReview}
		</tr>



		<div id="add-card-link">Add Card</div>
		<div> | </div>
		<div id="statistics-link">Statistics</div>
		<div> | </div>
		<c:url var="reviewLink" value="/startReview">
			<c:param name="id" value="${deck.id}" />
		</c:url>
		<a href="${reviewLink}">Review</a>
	</table>
	<div class="modal-content modal-addcard-content" id="modal-content">
		<div class="modal-header">
			<span class="close">&times;</span>
			<h2>Add new card</h2>
		</div>
		<div class="modal-body">
			<form:form action="addCard" modelAttribute="card" method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>Front:</label></td>
							<td><form:input path="front" type="text" /></td>
						</tr>

						<tr>
							<td><label>Back:</label></td>
							<td><form:input path="back" type="text" /></td>
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
	<div class="modal-content modal-statistics-content" id="modal-statistics-content">
		<div class="modal-statistics-header">
			<span class="close">&times;</span>
			<h2>Statistics</h2>
		</div>
		<div class="modal-statistics-body">
			
		</div>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/deck-script.js"></script>
</body>
</html>