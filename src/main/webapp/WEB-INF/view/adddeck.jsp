<script>//window.location=</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add deck</title>
</head>
<body>
	<form:form action="saveDeck" modelAttribute="deck" method="POST">	
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>

					<tr>
						<td><label>Language:</label></td>
						<td><form:input path="language" /></td>
					</tr>

					<tr>
						<td><label>Comment:</label></td>
						<td><form:input path="comment" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>
</body>
</html>