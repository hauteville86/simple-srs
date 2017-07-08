<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Decks</title>
<link rel="stylesheet" href="resources/css/modal.css">

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">

<script src="resources/js/ajax-utils.js"></script>

</head>
<body>
   <%@include file="/resources/html/navbar.html" %>
   <div class="container">
	
	<div class="btn-group pull-right" id="testview-deck-buttons">
		<c:url var="addDeck" value="/addDeck">
			<c:param name="page" value="decklist" />
		</c:url>
		<div id="add-deck-btn" class="btn btn-primary " data-toggle="modal" data-target="#myModal">Add deck</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h2>Add new deck</h2>
        </div>
        <div class="modal-body">
          <form:form action="addDeck" modelAttribute="deck" method="POST">
          	<div class="row form-group">
    			<label class="col-md-4">Name:</label>
    			<div class="col-md-8"><form:input path="name" type="text" class="form-control"/></div>
			</div>
			<div class="row form-group">
    			<label class="col-md-4">Language:</label>
    			<div class="col-md-8"><form:input path="language" type="text" class="form-control"/></div>
			</div>
			<div class="row form-group">
    			<label class="col-md-4">Comment:</label>
    			<div class="col-md-8"><form:input path="comment" type="text" class="form-control"/></div>
			</div>
			<div class="row form-group">
    			<div class="col-md-8 col-md-push-4"><input type="submit" value="Save" id="add-deck-btn" class="  save btn btn-primary " /></div>
			</div>
					
				</form:form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
</div>

	</div>
	<table  class="table">

		<tr>
			<th>Name</th>
			<th>Language</th>
			<th>Cards to review</th>
			<th>Open</th>
			<th>Delete</th>
			
		</tr>

		<c:forEach var="deck" items="${decks}">

			<tr>
				<td>${deck.deck.name}</td>
				<td>${deck.deck.language}</td>
				<td>${deck.numOfCardsToReview}</td>
				<td><c:url var="openLink" value="/showDeck">
						<c:param name="id" value="${deck.deck.id}" />
					</c:url> 
				
					<c:url var="deleteLink" value="/deleteDeck">
						<c:param name="id" value="${deck.deck.id}" />
						<c:param name="page" value="decklist" />
					</c:url> 
					
					<a href="${openLink}">Open</a></td><td><a href="${deleteLink}">Delete</a>
				</td>
			</tr>

		</c:forEach>
	
	</table>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/decklist-script.js"></script>
	<!--  <script>
		$.get("/resources/html/navbar.html", function(data) {
			$("#nav-placeholder").replaceWith(data);
		});
	</script>  -->
</body>
</html>