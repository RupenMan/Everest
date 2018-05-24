<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Mountaineer HomePage</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${tagline}</p>
			</div>

			<div class="container">
				<div class="row">
					<div class="col-xs-3 col-sm-3 col-md-3">
						<div id="dashboard">
							<table>
								<thead>
									<label>DashBoard</label>
								</thead>
								<tbody>
									<tr>
										<td><a
											href="http://localhost:8080/Everest/mountaineer/viewMountaineerInfo">
												<button class="btn btn-info">Personal Information</button>
										</a></td>
									</tr>

									<tr>
										<td><a
											href="http://localhost:8080/Everest/mountaineer/addMountaineer">
												<button class="btn btn-info">Update Information</button>
										</a></td>
									</tr>
									<tr>
										<td><a
											href="http://localhost:8080/Everest/booking/viewBookingInfo">
												<button class="btn btn-info">Booking Information</button>
										</a></td>
									</tr>

									<tr>
										<td><a
											href="http://localhost:8080/Everest/address/addAddress">
												<button class="btn btn-info">Add Your Location</button>
										</a></td>
									</tr>
								</tbody>
							</table>
						</div>

						<div>
							<label>My Booking Information</label><br> <a
								href="http://localhost:8080/Everest/booking/cancelBooking">Cancel
								Booking</a>
						</div>
					</div>
					<div class="col-xs-9 col-sm-9 col-md-9">
						<img src="https://s.hswstatic.com/gif/mt-everest-tourism-171676392.jpg" alt="Everest Image" 
							style="width:900px; margin-top: -20px; margin-left: -20px;"
						/>
					</div>
				</div>
			</div>
	</section>
</body>
</html>
