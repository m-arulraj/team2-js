<!DOCTYPE html>
<html>
<title>Semicolon (;)</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}


/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
 
  border: none;
  cursor: pointer;
 
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Semicolon (;)</a>
  <!--<a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="News"><i class="fa fa-globe"></i></a>-->
  <!--<a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-envelope"></i></a>-->
  
 
 </div>
</div>

<!-- Navbar on small screens -->
<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
  <a href="#" class="w3-bar-item w3-button w3-padding-large"/>Link 1</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large"/>Link 2</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large"/>Link 3</a>
  <a href="#" class="w3-bar-item w3-button w3-padding-large"/>My Profile</a>
</div>

<!-- Page Container -->
<div class="w3-container w3-content w3-center" style="max-width:1400px;margin-top:80px " >    
  <!-- The Grid -->
  <div class="w3-row w3-center" align ="center">
    <!-- Left Column -->
    <div class="w3-col m3">
	</div>
    <div align ="center">
    <!-- Middle Column -->
    <div class="w3-col m7  w3-card w3-round w3-white w3-center" align ="center" style ="margin-left: 20%">
	 
	 <div class="w3-container w3-theme-l4 " align ="center">
	 <h4> SEMICOLON(;)</h4>
	 </div>
	 <div class=" w3-bar w3-block ">
  <button class="w3-bar-item w3-button" onclick="registration('jobSeeker')">Job seeker</button>
  <button class="w3-bar-item w3-button" onclick="registration('employer')">Employer</button>
  
</div>
<div id="employer" class="w3-container registration">
  <h6> Employer Registration Form</h6>
 <form action="/admin"  method="post">
 <div class="container">
   
    <label for="User Name"><b>User Name</b></label><br>
    <input type="text" placeholder="EnterUser Name" name="userName" required><br>

    <label for="psw"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
<input type="hidden" id="authorities"  value="ROLE_JOBSEEKER"/>
   
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Create Account</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="login">Sign in</a>.</p>
  </div>
    </form>
			
</div>

<div id="jobSeeker" class="w3-container registration" style="display:none">
 <h6> Job-Seeker Registration Form</h6>
 <form action="admin"  method="post">
	 <div class="container">
    <label for="User Name"><b>User Name</b></label><br>
    <input type="text" placeholder="EnterUser Name" name="userName" required><br>

    <label for="psw"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
<input type="hidden" id="authorities"  value="ROLE_JOBSEEKER"/>
   
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Create Account</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="login">Sign in</a>.</p>
  </div>
    </form>
</div>

	</div> 
	</div>

    <!-- </div>	 End Middle Column -->
    
    
    <!-- Right Column -->
 
    
  <!-- End Grid -->
  </div>
  
<!-- End Page Container -->
</div>
<br>

<!-- Footer -->

<footer class="w3-container w3-theme-d5">
 <center> <p>Powered by - Semicolon (;)</p></center>
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
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
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
function registration(RegistrationType){
var i;
  var x = document.getElementsByClassName("registration");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  document.getElementById(RegistrationType).style.display = "block";  
}


</script>

</body>
</html> 
