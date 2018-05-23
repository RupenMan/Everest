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
<title>Add a schedule</title>
</head>
<body>
	<form:form modelAttribute="newSchedule" action="saveSchedule"
		method="POST">

		<%-- <form:errors path="*" cssClass="alert alert-danger" /> --%>
		<div>
			<form:input type="number" path="id" visibility="hidden" />
		</div>
		<div>
			<label for="shortDescription">Short Description</label> <br>
			<form:input type="text" path="shortDescription" placeholder="April Week 01 Trip" />
			<br>
			<form:errors path="shortDescription" />
		</div>

		<div>
			<label for="startDate">Start Date</label> <br>
			<form:input type="date" path="startDate" class="date" placeholder=""/>
			<br>
			<form:errors path="startDate" />
		</div>

		<div>
			<label for="endDate">End Date</label> <br>
			<form:input type="date" path="endDate" class = "date" placeholder=""/>
			<br>
			<form:errors path="endDate" />
		</div>


		<div>
			<label for="description">Description</label> <br>
			<form:input type="text" path="description" placeholder=""/>
		</div>

		<input type="submit" value="Add schedule" />
		<br>

	</form:form>
</body>
</html>