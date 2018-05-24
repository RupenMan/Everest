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
	<form:form modelAttribute="newAddress" action="selector"
		method="POST">

		<div>
			<label for="line1">Line 1: </label> <br>
			<form:input type="text" path="line1" placeholder="e.g. 1000 N. 4th Street"
				value="${address.line1}" />
			<br>
			<form:errors path="line1" />
		</div>

		<div>
			<label for="line2">Line 2: </label> <br>
			<form:input type="text" path="line2" placeholder="e.g. MR #001"
				value="${address.line2}" />
			<br>
			<form:errors path="line2" />
		</div>

		<div>
			<label for="city">City: </label> <br>
			<form:input type="city" path="city" placeholder="e.g. New York"
				value="${address.city}" />
			<br>
			<form:errors path="city" />
		</div>

		<div>
			<label for="state">State: </label> <br>
			<form:input type="text" path="state" placeholder="e.g. NY"
				value="${address.state}" />
			<br>
			<form:errors path="state" />
		</div>
		
		<div>
			<label for="zipcode">ZipCode: </label> <br>
			<form:input type="text" path="zipcode" placeholder="e.g. 52556"
				value="${address.zipcode}" />
			<br>
			<form:errors path="zipcode" />
		</div>

		<div>
			<label for="country">Country: </label> <br>
			<form:input type="text" path="country" placeholder="e.g. United States"
				value="${address.country}" />
			<br>
			<form:errors path="country" />
		</div>
		<input type="submit" value="Add Address" />
		<br>
		<form:input type="hidden" name="id" path="id"
			value="${address.id}" />

	</form:form>
</body>
</html>