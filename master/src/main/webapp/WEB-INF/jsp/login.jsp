<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Semicolon (;)</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css" />
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans' />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
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
				class="fa fa-bars"></i></a> <a href="#"
				class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i
				class="fa fa-home w3-margin-right"></i>Semicolon (;)</a>
			<!--<a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="News"><i class="fa fa-globe"></i></a>-->
			<a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white"
				title="Account Settings"><i class="fa fa-user"></i></a>
			<!--<a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-envelope"></i></a>-->
			<div class="w3-dropdown-hover w3-hide-small">
				<button class="w3-button w3-padding-large" title="Notifications">
					<i class="fa fa-bell"></i><span
						class="w3-badge w3-right w3-small w3-green">3</span>
				</button>
				<div class="w3-dropdown-content w3-card-4 w3-bar-block"
					style="width: 300px">
					<a href="#" class="w3-bar-item w3-button">new jobs are
						available</a> <a href="#" class="w3-bar-item w3-button">oracle
						requires the java candidates</a> <a href="#"
						class="w3-bar-item w3-button">job status changed</a>
				</div>
			</div>
			<a href="#"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white"
				title="My Account"> <img src="/w3images/avatar2.png"
				class="w3-circle" style="height: 23px; width: 23px" alt="Avatar" />
			</a>
		</div>
	</div>



	<!-- Navbar on small screens -->
	<div id="navDemo"
		class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 1</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 2</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">Link 3</a>
		<a href="#" class="w3-bar-item w3-button w3-padding-large">My
			Profile</a>
	</div>

	<!-- Page Container -->
	<div class="w3-container w3-content w3-card " style="margin-top: 80px">

		<div class="w3-container w3-margin w3-blue">
			<h2 class="w3-center">Login</h2>
		</div>

		<form:form
			action="${pageContext.request.contextPath}/authenticateUser"
			method="post">

			<c:if test="${param.error != null}">
				<i>Wrong credentials</i>
			</c:if>

			<c:if test="${param.logout != null}">
				<i>You have been logged out</i>
			</c:if>
			<p>
				<label>Username</label> <input class="w3-input" type="text">
			</p>
			<p>
				<label>Password</label> <input class="w3-input" type="text">
			</p>
			<p class="w3-center w3-padding">
				<input class="w3-button w3-center w3-green" type="submit">
			</p>
		</form:form>

	</div>
	<br />

	<!-- Footer -->

	<footer class="w3-container w3-center w3-theme-d5">

		<p>Powered by - Semicolon (;)</p>

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
