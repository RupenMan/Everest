<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booking Information</title>
</head>
<body>
	<div>
		<label>Status: </label> ${booking.status}
	</div>

	<div>
		<label>Booking Date: </label> ${booking.bookingDate}
	</div>
	<br>

	<div>
		<label>Booking Schedule: </label> <br> <label>Short
			Description: </label> ${booking.schedule.shortDescription}<br> <label>Start
			Date: </label>
		<fmt:formatDate value="${booking.schedule.startDate}"
			pattern="yyyy-MM-dd" />
		<br> <label>End Date:</label>
		<fmt:formatDate value="${booking.schedule.endDate}"
			pattern="yyyy-MM-dd" />
		<br> <label>Tour Guide: </label> ${tourGuide} <br>
	</div>

	<a href="http://localhost:8080/Everest/mountaineer/homepage">Return
		To About Me</a>
</body>
</html>