<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Register/Update Mountaineer</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${tagline}</p>
				Register/Update Mountaineer
			</div>

			<div class="container">
				<form:form modelAttribute="newMountaineer" action="selector"
					method="POST">

					<div>
						<label for="firstName">FirstName</label> <br>
						<form:input type="text" path="firstName" placeholder="e.g. Jim"
							value="${mountaineer.firstName}" />
						<br>
						<form:errors path="firstName" />
					</div>

					<div>
						<label for="lastName">LastName</label> <br>
						<form:input type="text" path="lastName" placeholder="e.g. Carett"
							value="${mountaineer.lastName}" />
						<br>
						<form:errors path="lastName" />
					</div>

					<div>
						<label for="email">Email</label> <br>
						<form:input type="email" path="email"
							placeholder="abc@example.com" value="${mountaineer.email}" />
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
						<label for="gender">Gender: </label> <br> <select
							name="gender">
							<option value="Select Gender ..." selected>Select Gender ...</option>
							<option value="Male">Male</option>
							<option value="Female">Female</option>
						</select>
					</div>

					<div>
						<label for="phone">Phone: </label> <br>
						<form:input type="text" path="phone" placeholder="641-451-5489"
							value="${mountaineer.phone}" />
						<br>
						<form:errors path="phone" />
					</div>

					<input type="submit" value="Add Mountaineer" />
					<br>
					<form:input type="hidden" name="id" path="id"
						value="${mountaineer.id}" />
				</form:form>
			</div>
		</div>
	</section>
</body>
</html>