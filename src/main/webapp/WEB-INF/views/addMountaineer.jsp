<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Mountaineer</title>
</head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<body>
	<form:form modelAttribute="newMountaineer" action="saveMountaineer" method="POST">

		<%-- <form:errors path="*" cssClass="alert alert-danger" /> --%>
		<div>
			<label for="firstName">FirstName</label> <br>
			<form:input type="text" path="firstName" placeholder="e.g. John" /><br>
			<form:errors path="firstName" />
		</div>

		<div>
			<label for="lastName">LastName</label> <br>
			<form:input type="text" path="lastName" placeholder="e.g. Cena" /><br>
			<form:errors path="lastName" />
		</div>

		<div>
			<label for="email">Email</label> <br>
			<form:input type="email" path="email" placeholder="abc@example.com" /><br>
			<form:errors path="email" />
		</div>


		<div>
			<label for="age">Age</label> <br>
			<form:input type="number" path="age" value="15" min="15" max="80" />
		</div>

		<div>
			<label for="gender">Gender:</label> <br> <select name="gender">
				<option value="Select Gender ..." selected>Select Gender ...</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
			</select>
		</div>
		
		<input type="submit" value="Add Mountaineer" />
		<br>

	</form:form>
</body>
</html>