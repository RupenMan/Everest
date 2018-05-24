<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/mountaineer_homepage.css">
<title>HomePage</title>

</head>
<body>
	<h1>MOUNTAINEERING SCHEDULE</h1>
	<hr>
	<div class="container">
		<div class="row">
			<div class="col-xs-4 col-sm-4 col-md-4">
				<div id="dashboard">
					<label>DashBoard</label><br> <a
						href="http://localhost:8080/Everest/mountaineer/viewMountaineerInfo">
						<button class="btn btn-info">Personal Information</button>
					</a><br> <a
						href="http://localhost:8080/Everest/mountaineer/addMountaineer">
						<button class="btn btn-info">Update Information</button>
					</a><br> <a
						href="http://localhost:8080/Everest/booking/viewBookingInfo">
						<button class="btn btn-info">Booking Information</button>
					</a><br> <a
						href="http://localhost:8080/Everest/address/addAddress">
						<button class="btn btn-info">Add Your Location</button>
					</a><br>
				</div>
				<div>
					<label>My Booking Information</label><br> <a
						href="http://localhost:8080/Everest/booking/cancelBooking">Cancel
						Booking</a>
				</div>
			</div>
			<div class="col-xs-8 col-sm-8 col-md-8"></div>
		</div>
</body>
</html>