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
<body>
	<div class="jumbotron">
		<div class="container">
			<h1>Schedules & Bookings</h1>
		</div>
		<p>
			<a
				href=" <spring:url value="/employee/employeeDashboard" /> "
				class="btn btn-default pull-right"> <span
				class="glyphicon-info-sign glyphicon" /></span> Dashboard
			</a>
		</p>
	</div>
	<section class="container">
		<div class="row">
			<c:forEach items="${schedules}" var="schedule">
				<!-- <div class="col-sm-6 col-md-3 col-xd-3" style="padding-bottom: 15px"> -->
				<div class="thumbnails">
					<!-- img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/-->
					<div class="card">
						<h3>${schedule.shortDescription}</h3>
						<label>Start Date: </label>
						<fmt:formatDate value="${schedule.startDate}" pattern="yyyy-MM-dd" />
						<br> <label>End Date: </label>
						<fmt:formatDate value="${schedule.endDate}" pattern="yyyy-MM-dd" />
						<br>
						<%-- <p>${schedule.startDate}</p>
						<p>${schedule.endDate}</p> --%>
						<label>Description: </label> ${schedule.description}<br>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Booking Id</th>
									<th scope="col">Mountaineer</th>
									<th scope="col">Booking Date</th>
									<th scope="col">Status</th>
									<th></th>
								</tr>
							</thead>
							<c:forEach items="${schedule.booking}" var="booking">
								<tbody>
									<tr>
										<td>${booking.id}</td>
										<td>${booking.mountaineer.firstName}</td>
										<td>${booking.bookingDate}</td>
										<td>${booking.status}</td>
										<td>
											<p>
												<a
													href=" <spring:url value="/booking/approveBooking?bookingId=${booking.id}" /> "
													class="btn btn-primary"> <span
													class="glyphicon-info-sign glyphicon" /></span> Approve
												</a>
											</p>
										</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						<p>
							<a
								href=" <spring:url value="/schedule/updateschedule?id=${schedule.id}" /> "
								class="btn btn-primary"> <span
								class="glyphicon-info-sign glyphicon" /></span> Update
							</a>
						</p>

					</div>
				</div>
				<!-- </div> -->
			</c:forEach>
		</div>
	</section>
</body>
</html>