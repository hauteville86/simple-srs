<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- <link rel="icon" href="../../favicon.ico">  -->

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet"> 
    
    <!-- Custom styles for this template -->
    <link href="resources/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please log in</h2>
        <label for="inputEmail" class="sr-only">Username</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
      </form>

    </div> <!-- /container -->
    
    <!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
    
  </body>
</html>
