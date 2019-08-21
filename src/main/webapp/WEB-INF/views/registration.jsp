<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<br><br>
<div class="container" style="border: 3px solid white;">
<h2>Coffee Shop Staff Registration</h2>
<h3><em>Please fill out the form below to register.</em></h3>
<br>
<div class="row">
	<div class="col">
		<form action="post_registration" method="post" onsubmit="return validate();">
		First Name:<input type="text" name="name1" id="name1" style="margin-left: 48px" value="" required><br>
		Last Name:<input type="text" name="name2" id="name2" style="margin-left: 50px" value="" required><br>
		City:<input type="text" name="city" id="city" style="margin-left: 92px" value="" required><br>
		Address:<input type="text" name="address" id="address" style="margin-left: 65px" value="" required><br>
		Phone #:<input type="text" name="phone" id="phone" style="margin-left: 63px" value="" required><br>
		Email:<input type="text" name="email" id="email" style="margin-left: 82px" value="" required><br><br>
		<input type="submit" value="Register!" class="btn btn-primary" style="color: #B3CBDD; margin-left: 50px"></input>
		</form>
		<br>
		<br>
	</div>
</div>
</div>
<script type="text/javascript" src="scripts/main.js"></script>
</body>
<footer>
${copyright}
</footer>
</html>