<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dictionary</title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
	<%@include file="/resources/html/navbar.html" %>
	
	<div class="container container-2">
		<div class="row">
			<div class="col-md-12"><h2>Choose your languages:</h2></div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="dropdown">
					<button class="btn btn-primary" id="dropdownLangcodes1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Language 1
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownLangcodes1">
						<c:forEach var="langcode" items="${langcodesOne}">
							<li>
								<c:url var="setLang" value="/dictSetLang">
									<c:param name="name1" value="${langcode.langname}" />
								</c:url>
								<a href="${setLang}">${langcode.langname}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<h4>${lang1}</h4>
			</div>
			<div class="col-md-6">
				<div class="dropdown">
					<button class="btn btn-primary" id="dropdownLangcodes2"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Language 2
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownLangcodes2">
						<c:forEach var="langcode" items="${langcodesTwo}">							
							<li>
								<c:url var="setLang" value="/dictSetLang">
									<c:param name="name2" value="${langcode.langname}" />
								</c:url>
								<a href="${setLang}">${langcode.langname}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<h4>${lang2}</h4>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>