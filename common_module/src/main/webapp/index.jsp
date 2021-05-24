<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index page</title>
<link rel="stylesheet" href="css/Reg.css">
</head>
<body style="background-image: url('img/Register.jpg');">
	<header>
		<div class="name">Furnish Forest</div>
		<div>
			<a href="#">Sign-in</a>
		</div>
	</header>
	<form class="form" name="regform" action="register.do" method="post"
		onclick="return validate()">
		<h3>REGISTER HERE</h3>
		<h4>${msg}</h4>
		<input type="text" class="animate-input" name="fullName" placeholder="Full Name *" autocomplete="off" required> 
		<input type="email" class="animate-input" name="emailId" placeholder="Email-Id *" autocomplete="off" required> 
		<input type="text" class="animate-input" name="dob" placeholder="Date of birth *" onfocus="(this.type='date')"
			autocomplete="off" required> 
		<input type="number" class="animate-input" name="contact" placeholder="Contact *" autocomplete="off" required> 
		<input type="text" class="animate-input" name="address" placeholder="Address *" autocomplete="off" required> <br>  
		Gender : <input type="radio" name="gender" value="Male">Male 
				<input type="radio" name="gender" value="Female">Female 
				<input type="radio" name="gender" value="Others">Others 
		<input type="password" class="animate-input" name="password" placeholder="Password *" autocomplete="off" required>
		<button type="submit" class="register">Register</button>
		<button type="reset" class="reset">Reset</button>
	</form>
	<footer> &copy;AllRights 2021 </footer>
</body>
</html>