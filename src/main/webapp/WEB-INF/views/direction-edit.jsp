<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direction Edition | StockAgent</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
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
						href="${pageContext.request.contextPath}/categories">Category</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath}/directions">Direction</a>
						<span class="sr-only">(current)</span>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class = "pt-5 container">
			<h2>Direction ${direction.id}</h2>
			<hr>
		<div class = " row justify-content-center">

			<div class = "col-md-8">
				<form action = "${pageContext.request.contextPath}/directions" method="POST">
				
					<div class = "form-group">
					  <label for="street">Address</label>
						<input type = "text" class = "form-control" name = "address" placeholder = "Enter Street Adress" value = "${direction.address}"/>
					</div>
					
					<div class = "form-group">
					  <label for="street">House Number</label>
						<input type = "number" class = "form-control" name = "houseNumber" placeholder = "Enter the house Number" value = "${direction.houseNumber}"/>
					</div>
					
					<div class = "form-group">
					  <label for="street">Zip Code</label>
						<input type = "number" class = "form-control" name = "zipCode" placeholder = "Enter the Zip Code" value = "${direction.zipCode}"/>
					</div>
					
					<div class="form-group">
						<label for="city">City</label>
					  	<input type = "text" class = "form-control" name = "city" placeholder = "Enter City" value = "${direction.city}"/>
					</div>
					
					<div class="form-group">
						<label for="city">Province</label>
					  	<input type = "text" class = "form-control" name = "province" placeholder = "Enter Province or Council" value = "${direction.province}"/>
					</div>
					
					<div class="form-group">
						<label for="country">Country</label>
					  	<input type = "text" class = "form-control" name = "country" placeholder = "Enter Country" value = "${direction.country}"/>
					</div>
					
					<input type = "hidden" name = "id" value = "${direction.id}"/>
				
					<a class = "btn btn-info" href = "${pageContext.request.contextPath}/products" >Back to products list</a>
					<button class = "btn btn-primary" type = "submit" >Save</button>
				</form>
			</div>
		</div>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>