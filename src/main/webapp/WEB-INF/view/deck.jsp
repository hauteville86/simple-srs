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

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<%@include file="/resources/html/navbar.html" %>
	
	<div class="container container-2">

	<div class="row">
		<div class="col-xs-12">
			<h2>Deck name: ${deck.name}</h2>
			<h3>Language: ${deck.language}</h3>
			<p>Created: ${deck.created}</p>
			<p>Cards in deck: ${deckInfo.numOfCards}</p>
			<p>Cards to review: ${deckInfo.numOfCardsToReview}</p>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<c:url var="reviewLink" value="/startReview">
			<c:param name="id" value="${deck.id}" />
		</c:url>
		<a id="add-deck-btn" class="btn btn-primary " href="${reviewLink}">Review</a>
		</div>
	</div>
		<div class="row button-div">
		<div class="col-sm-4">
			<div  id="add-card-btn" class="btn btn-primary " data-toggle="modal" data-target="#myModal">Add Card</div>
		</div>
		<div class="col-sm-4">
			<div  id="statistics-link" class="btn btn-primary " data-toggle="modal" data-target="#myModal-2">Statistics</div>	
		</div>
		
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    
	<div class="modal-dialog modal-lg">
      <div class="modal-content">
		
		 <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h2>Add Card</h2>
        </div>
		<div class="modal-body">
			<form:form action="addCard" modelAttribute="card" method="POST">
				<form:input path="deckId" type="hidden" value="${deck.id}" />
				<div class="row form-group">
    				<label class="col-md-4">Front:</label>
    				<div class="col-md-8"><form:input path="front" type="text" class="form-control"/></div>
				</div>
				<div class="row form-group">
    				<label class="col-md-4">Back:</label>
    				<div class="col-md-8"><form:input path="back" type="text" class="form-control"/></div>
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
	<div class="modal fade" id="myModal-2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    
	<div class="modal-dialog modal-lg">
      <div class="modal-content">
		
		<div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h2>Statistics</h2>
        </div>
		<div class="modal-statistics-body">
			<div class="row">
				<div class="col-xs-12">
					<h2>Deck name: ${deck.name}</h2>
					<h3>Language: ${deck.language}</h3>
					<p>Created: ${deck.created}</p>
					<p>Cards in deck: ${deckInfo.numOfCards}</p>
					<p>Cards to review: ${deckInfo.numOfCardsToReview}</p>
				</div>
			</div>
		</div>	
		</div>
		</div>	
		</div>
	</div>
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/deck-script.js"></script>

</body>
</html>