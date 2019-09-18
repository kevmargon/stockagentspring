<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Edition | StockAgent</title>
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
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}/categories">Category</a>
						<span class="sr-only">(current)</span></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/directions">Direction</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="pt-5 container">
		<h2>Category ${category.id}</h2>
		<hr>
		<div class=" row justify-content-center">

			<div class="col-md-8">
				<form:form action="${pageContext.request.contextPath}/categories"
					method="POST" modelAttribute="category">

					<div class="form-group">
						<label for="name">Name</label>
						<form:input class="form-control" path="name" />
					</div>
					
					<form:hidden path="id" />
					<a class="btn btn-info"
						href="${pageContext.request.contextPath}/categories">Back
						list</a>
					<button class="btn btn-primary" type="submit">Save</button>
				</form:form>
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>