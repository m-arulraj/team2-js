<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>Posted Jobs</title>
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

.expand {
	display: block;
	color: RoyalBlue;
}

.active, .collapsible:hover {
	
}

.content {
	padding: 0 18px;
	display: none;
	overflow: hidden;
}
</style>
<body>
	<!-- class="w3-theme-l5" onload="startTime()" -->
	>



	<!-- Navbar -->
	<div class="w3-top">
		<div class="w3-bar w3-theme-d2 w3-left-align w3-large">
			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2"
				href="javascript:void(0);" onclick="openNav()"><i
				class="fa fa-bars"></i></a> <a href="/employer"
				class="w3-bar-item w3-button w3-hover-black w3-padding-large "><i
				class="fa fa-home w3-margin-right"></i>Employer Home</a> <a
				href="profile"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-green"
				title="Update profile"><i class="fa fa-arrow-up"></i>&nbsp;&nbsp;Update
				Profile</a> <a href="jobs"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-indigo"
				title="Posted Jobs"><i class='fab fa-black-tie'
				style='font-size: 20px'></i> &nbsp;&nbsp;Posted Jobs</a> <a
				href="report"
				class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-blue"
				title="Report"><i class="	fas fa-thumbs-down"></i>&nbsp;&nbsp;Reports
				Something</a> <a href="/logout"
				class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-red"
				title="Logout"> <i class="material-icons">power_settings_new</i>&nbsp;&nbsp;Logout
			</a>
		</div>
	</div>

	<!-- Navbar on small screens -->
	<div id="navDemo"
		class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
		<a href="profile" class="w3-bar-item w3-button w3-padding-large">Update
			Profile</a> <a href="profile"
			class="w3-bar-item w3-button w3-padding-large">Update Profile</a> <a
			href="jobs" class="w3-bar-item w3-button w3-padding-large">Posted
			Jobs</a> <a href="report" class="w3-bsar-item w3-button w3-padding-large">Report
			Something</a> <a href="/logout"
			class="w3-bar-item w3-button w3-padding-large">Logout</a>
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

						<a href="seeker/profile" style="width: 90%"
							class="w3-bar-item w3-button w3-green  w3-margin ">Update
							Profile</a>
					</div>
				</div>
				<br> <br>
				<!-- End Left Column -->
			</div>

			<!-- Middle Column -->
			<div class="w3-col m7">

				<div class="w3-content">
					<a href="#" class="expand">Post A Job</a>
					<div class="content" >
						<div id="postedJobsList" class="w3-container postjob">
							<form:form action="postjob" method="post"
								modelAttribute="postedjobs">
								
								<div class="container">
								<div class="w3-row ">
								
									<label>Job Title:</label> <form:input
										class="w3-input w3-border w3-round-large" name="JobTitle"
										type="text"  path="jobTitle"/>
								</div>
								<br>
								<div class=" w3-row">
									<label>Job Id:</label> <form:input
										class="w3-input w3-border w3-round-large" name="JobId"
										type="text"  path="jobId"/>
								</div>
							<br>
								<div class="w3-row ">
								
									<label>Job Type:</label> <form:input
										class="w3-input w3-border w3-round-large" name="JobType"
										type="text"  path="jobType"/>
								</div>
								<br>
								<div class=" w3-row">
									<label>JobDescription:</label> <form:input
										class="w3-input w3-border w3-round-large" name="jobDescription"
										type="text"  path="jobDescription"/>
								</div>
							<br>
								<div class="w3-row ">
								
									<label>Required	Skills:</label> <form:input
										class="w3-input w3-border w3-round-large" name="requiredSkills"
										type="text"  path="requiredSkills"/>
								</div>
								<br>
								<div class=" w3-row">
									<label>Number of
											vacancies:</label> <form:input
										class="w3-input w3-border w3-round-large" name="numberOfVacancies"
										type="text"  path="numberOfVacancies"/>
								</div>
								<br>
									<div class="w3-row ">
								
									<label>Salary:</label> <form:input
										class="w3-input w3-border w3-round-large" name="salary"
										type="text"  path="salary"/>
								</div>
								<br>
								<div class="w3-center">
									<button type="submit" class="postjobbtn">Post Job</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="w3-container ">
					<br>
					<h3 class="w3-center w3-indigo w3-xxlarge ">Posted Jobs</h3>
					<hr class="w3-clear">
					<br>
					<ul class="w3-ul w3-border">
						<c:forEach items="${postedjobList}" var="postedjobs">
							<li class="w3-bar"><span
								onclick="this.parentElement.style.display='none'"
								class="w3-bar-item w3-button w3-white w3-xlarge w3-right">×</span>
								<img
								src="data:image/png;base64,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"
								class="w3-bar-item w3-circle w3-hide-small" style="width: 85px">
								<div class="w3-bar-item">
									<span class="w3-large">${postedjobs} </span><br> <span>${postedjobs}</span>
								</div></li>
						</c:forEach>
					</ul>
					<br> <br> <br>
				</div>


				<!-- End Middle Column -->
			</div>


			<!-- Right Column -->
			<div class="w3-col m2 w3-margin-top">
				<div class="w3-card w3-round w3-white w3-center">
					<div class="w3-container">
						<p>Have A Good Day :)</p>


						<p id="txt" class="w3-black w3-container w3-padding">Time</p>

					</div>
				</div>
				<br>
				<!-- End Right Column -->
			</div>

			<!-- End Grid -->
		</div>
		<br>

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

		//time
		function startTime() {
			var today = new Date();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			m = checkTime(m);
			s = checkTime(s);
			document.getElementById('txt').innerHTML = h + ":" + m + ":" + s;
			var t = setTimeout(startTime, 500);
		}
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i
			}
			; // add zero in front of numbers < 10
			return i;
		}

		var coll = document.getElementsByClassName("expand");
		var i;

		for (i = 0; i < coll.length; i++) {
			coll[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var content = this.nextElementSibling;
				if (content.style.display === "block") {
					content.style.display = "none";
				} else {
					content.style.display = "block";
				}
			});
		}
	</script>

</body>
</html>
