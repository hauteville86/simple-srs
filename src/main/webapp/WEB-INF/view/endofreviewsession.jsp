<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Session Ended</title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/script.js"></script>
<script src="resources/js/ajax-utils.js"></script>
<link rel="import" href="WEB-INF/view/navbar.html">
</head>
<body>
	End of review session
	<!-- jQuery (Bootstrap JS plugins depend on it) -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$.get("/resources/html/navbar.html", function(data) {
			$("#nav-placeholder").replaceWith(data);
		});
	</script>
</body>
</html>