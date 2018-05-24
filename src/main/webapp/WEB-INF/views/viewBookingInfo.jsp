<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Schedules</title>
</head>
<style>
.info, label {
	font-size: 25pt;
}

a {
	font-size: 25pt;
}
</style>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>My Booking</h1>
		</div>
		<p>
			<a href=" <spring:url value="/mountaineer/homepage" /> "
				class="btn btn-default pull-right"> <span
				class="glyphicon-info-sign glyphicon" /></span>Dashboard
			</a>
		</p>
	</div>
	<section class="container">
		<div class="row">
			<div class="thumbnails">
				<div class="card">
					<label>Short Description: </label> <span class="info">${booking.schedule.shortDescription}</span><br>
					<label>Start Date: </label> <span class="info"><fmt:formatDate
							value="${booking.schedule.startDate}" pattern="yyyy-MM-dd" /></span> <br>
					<label>End Date:</label> <span class="info"><fmt:formatDate
							value="${booking.schedule.endDate}" pattern="yyyy-MM-dd" /></span> <br>
					<label>Tour Guide: </label> ${tourGuide} <br>
				</div>
			</div>
			<div>
				<a href="http://localhost:8080/Everest/booking/cancelBooking"><button
						class="btn btn-info">Cancel Booking</button></a>
			</div>
		</div>
	</section>
</body>
</html>