<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Edition | StockAgent</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">StockAgent</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/products">Product</a>
          	<span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/categories">Category</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/directions">Direction</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

	<div class="pt-5 container">
		<h2>Product ${product.id} Details</h2>
		<hr>


		<table class="table table-striped table-bordered">

			<tr class="thead-dark">
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Manufacturer</th>
			</tr>

			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.quantity}</td>
				<td>${product.getManufacturer().name}</td>
			</tr>
		</table>
		<a class="btn btn-info"
		href="${pageContext.request.contextPath}/products">Back list</a>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>