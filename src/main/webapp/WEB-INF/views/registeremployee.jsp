<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Register Employee</title>
</head>
<body>
<form:form modelAttribute="newEmployee"
		action="employee/saveEmployee" method="POST">

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
			<label for="age">Phone</label> <br>
			<form:input type="text" path="phone" value="15" min="15" max="80" />
		</div>
		
		<input type="submit" value="Add Employee" />
		<br>

	</form:form>
</body>
</html>