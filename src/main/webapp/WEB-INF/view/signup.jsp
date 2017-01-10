<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<!-- <link rel="icon" href="../../favicon.ico">  -->

<title>Please sign up</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/signin.css" rel="stylesheet">

</head>

<body>

	<div class="container">
		<!-- SEPARATE ACTION MUST BE IMPLEMENTED -->
		<form class="form-signin" th:action=""
			method='POST'>
			<h2 class="form-signin-heading">Please sign up</h2>
			<div><label for="inputEmail" class="sr-only">Username </label><input
				type="text" class="form-control" placeholder="Login"
				name="username"
				required autofocus/></div>
			 <div><label for="inputPassword"
				class="sr-only">Password</label><input type="password" class="form-control"
				placeholder="Password"
				name="password" required/></div> 
			<div><label for="repeatPassword"
				class="sr-only">Repeat password</label><input type="password" class="form-control"
				placeholder="Repeat password"
				name="password" required/></div> 
			<button class="btn btn-lg btn-primary btn-block" type="submit">Log
				in</button>
		</form>
	</div>
	<!-- /container -->

	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>
