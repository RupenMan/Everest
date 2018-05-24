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
	<form:form modelAttribute="newMountaineer" action="selector"
		method="POST">

		<%-- <form:errors path="*" cssClass="alert alert-danger" /> --%>
		<div>
			<label for="firstName">FirstName</label> <br>
			<form:input type="text" path="firstName" placeholder="e.g. John"
				value="${mountaineer.firstName}" />
			<br>
			<form:errors path="firstName" />
		</div>

		<div>
			<label for="lastName">LastName</label> <br>
			<form:input type="text" path="lastName" placeholder="e.g. Cena"
				value="${mountaineer.lastName}" />
			<br>
			<form:errors path="lastName" />
		</div>

		<div>
			<label for="email">Email</label> <br>
			<form:input type="email" path="email" placeholder="abc@example.com"
				value="${mountaineer.email}" />
			<br>
			<form:errors path="email" />
		</div>


		<div>
			<label for="age">Age</label> <br>
			<c:if test="${mountaineer.age>0}">
				<form:input type="number" path="age" value="${mountaineer.age}"
					min="15" max="80" />
			</c:if>
			<c:if test="${mountaineer.age <= 0}">
				<form:input type="number" path="age" value="15" min="15" max="80" />

			</c:if>
		</div>

		<div>
			<label for="gender">Gender: </label> <br> <select name="gender">
				<option value="Select Gender ..." selected>Select Gender ...</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
			</select>
		</div>

		<div>
			<label for="phone">Phone: </label> <br>
			<form:input type="text" path="phone" placeholder="e.g. 641-451-5489"
				value="${mountaineer.phone}" />
			<br>
			<form:errors path="phone" />
		</div>

		<input type="submit" value="Add Mountaineer" />
		<br>
		<form:input type="hidden" name="id" path="id"
			value="${mountaineer.id}" />
	</form:form>
</body>
</html>