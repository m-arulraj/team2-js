<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Admin Block</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
	crossorigin='anonymous'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}
</style>
<body class="w3-theme-l5">

	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> <a href="/admin"
				class="w3-bar-item w3-button w3-hover-black w3-padding-large "><i
				class="fa fa-home w3-margin-right"></i>Admin Home</a> <a
				href="/admin/requests"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green"
				title="Approval Requests"><i class="fa fa-plus"></i>&nbsp;&nbsp;Approval
				Requests</a> <a href="/admin/reports"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-indigo"
				title="Reports/Feedback"><i class="fa fa-comment"></i>&nbsp;&nbsp;Reports/Feedback</a>

			<a href="/admin/profile"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-blue"
				title="Profile"><i class="fa fa-user"></i>&nbsp;&nbsp;Profile</a> <a
				href="block"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-teal"
				title="Profile"><i class="material-icons"
				style="font-size: 22px">block</i>&nbsp;&nbsp;Block User</a> <a
				href="logout"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-red"
				title="Logout"><i class="material-icons">power_settings_new</i>&nbsp;&nbsp;Logout</a>

		</div>
	</div>

	<!-- Navbar on small screens -->
	<div id="navDemo"
		class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">


		<a href="/admin/requests"
			class="w3-bar-item w3-button w3-padding-large">Approval Requests</a>
		<a href="/admin/requests"
			class="w3-bar-item w3-button w3-padding-large">Approval Requests</a>
		<a href="/admin/reports"
			class="w3-bar-item w3-button w3-padding-large">Feedback / Reports</a>
		<a href="/admin/profile"
			class="w3-bar-item w3-button w3-padding-large">Update Profile</a> <a
			href="block" class="w3-bar-item w3-button w3-padding-large">block
			User</a> <a href="logout" class="w3-bar-item w3-button w3-padding-large">Logout</a>
	</div>

	<!-- Page Container -->
	<div class="w3-container w3-content"
		style="max-width: 1400px; margin-top: 80px">
		<!-- The Grid -->
		<div class="w3-row">
			<!-- Left Column -->
			<div class="w3-col m3">
				<!-- Profile -->
				<div class="w3-card w3-round w3-white">
					<div class="w3-container">
						<h4 class="w3-center">My Profile</h4>
						<p class="w3-center">
							<img
								src="data:image/jpeg;base64,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"
								class="w3-circle" style="height: 250px; width: 250px"
								alt="Avatar">
						</p>
						<hr>
						<p>
							<i class="fa fa-user fa-fw w3-margin-right w3-text-theme"></i>
							Admin
						</p>
						<p>
							<i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i>
							Designer, UI
						</p>
						<p>
							<i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i>
							London, UK
						</p>
						<p>
							<i
								class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i>
							April 1, 1988
						</p>

					</div>
				</div>
				<br>

				<!-- End Left Column -->
			</div>

			<!-- Middle Column -->
			<div class="w3-col m9">


				<div class="w3-container w3-card w3-white w3-round w3-margin">
					<br>
					<h3 class="w3-center w3-xxlarge w3-teal">Blocked User</h3>
					<hr class="w3-clear">


					<ul class="w3-ul w3-border">

						<c:forEach var="user" items="users">
							<li class="w3-bar"><a href="block"
								class="w3-button w3-red w3-right w3-margin w3-hover-green">Block</a>


								<div class="w3-bar-item">
									<span class="w3-large">Mike</span><br> <span>Web
										Designer</span>
								</div></li>
						</c:forEach>
					</ul>

					<br>
				</div>


				<!-- End Middle Column -->
			</div>


			<!-- End Grid -->
		</div>

		<!-- End Page Container -->
	</div>
	<br>

	<!-- Footer -->
	<footer class="w3-container w3-theme-d3 w3-padding-16 w3-bottom">
		<h5 class="w3-center">&copy Sem;colon</h5>
	</footer>



	<script>
		// Accordion
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-theme-d1";
			} else {
				x.className = x.className.replace("w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-theme-d1", "");
			}
		}

		// Used to toggle the menu on smaller screens when clicking on the menu button
		function openNav() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>

</body>
</html>
