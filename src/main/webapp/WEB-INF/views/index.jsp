<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/darkly/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<br>
<div class="container">
<h1 style="text-align: center">GC Coffee Shop</h1>
<br><br>
<h3><a href="shop">Click here to go to our coffee shop</a></h3>
<h3><a href="registration">Click here to go to our registration page</a></h3>
</div>
<br><br><br>
<div class="container">
<form action="/filter" method="post">
	<input type="text" name="filter" placeholder="filter"/>
	<input type="submit" value="Update"/>
</form>
<h2>List of items:</h2>
<c:forEach items="${items}" var="i">
	<p>
	${i} - <a href="purchase_item?name=${i.getName()}&desc=${i.getDescription()}&quantity=${i.getQuantity()}&price=${i.getPrice()}">PURCHASE</a>
	<br>
	<img src="${i.getImage()}" width=128 height=128></img>
	</p>
</c:forEach>
</div>
</body>
<footer>
${copyright}
</footer>
</html>