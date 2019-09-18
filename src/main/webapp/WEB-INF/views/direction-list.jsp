<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direction List | StockAgent</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container">
			<a class="navbar-brand" href="#">StockAgent</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/products">Product</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/manufacturers">Category</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}/directions">Direction</a>
						<span class="sr-only">(current)</span>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="pt-5 container">

		<h1>Directions Directory</h1>
		<hr />

		<c:choose>
			<c:when test="${notificationLabel=='success'}">
				<div class="alert alert-success" role="alert">
					<p>${notification}</p>
				</div>
			</c:when>
			<c:when test="${notificationLabel=='error'}">
				<div class="alert alert-danger" role="alert">
					<p>${notification}</p>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>


		<table class="table table-striped table-bordered">

			<tr class="thead-dark">
				<th>Street</th>
				<th>House Number</th>
				<th>Zip Code</th>
				<th>City</th>
				<th>Province</th>
				<th>Country</th>
			</tr>

			<c:forEach items="${directions}" var="direction">

				<tr>
					<td>${direction.address}</td>
					<td>${direction.houseNUmber}</td>
					<td>${direction.zipCode}</td>
					<td>${direction.city}</td>
					<td>${direction.province}</td>
					<td>${direction.country}</td>
				</tr>

			</c:forEach>

		</table>

	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>