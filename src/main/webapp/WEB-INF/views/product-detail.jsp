<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<title>Product Edition | StockAgent</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<!-- Navigation -->
	<c:set var = "navigation" scope = "session" value = "product"/>
  	<jsp:include page="header.jsp"></jsp:include>

	<div style="" class="container">
		<div class="row bg-light grey"
			style="padding: 20px; margin-top: 20px;">
			<div style="height: 40%; width: 40%;" class="img-fluid">
				<!-- Nomeclatura para los nombres de las imagenes "ManufacturerName"-"ProductName".jpg Ejemplo: Adidas-Superstar.jpg-->
				<img style="width: 100%; height: 100%;"
					src="${pageContext.request.contextPath}/img/${product.manufacturer}-${product.name}.jpg" />
			</div>

			<div class="col-xs-5"
				style="border: 0px solid gray; margin: auto; padding-left: 20px;">
				<!-- Datos del vendedor y titulo del producto -->
				<h3>${product.name}</h3>
				<h5 style="color: #337ab7">
					Manufacturer <a href="#">${product.manufacturer}</a>
				</h5>

				<!-- Precios -->
				<h6 class="title-price">
					<small>PRICE</small>
				</h6>
				<h4 style="margin-top: 0px;">EUR ${product.price}</h4>

				<!-- Detalles especificos del producto -->

				<div class="section" style="padding-bottom: 5px;">
					<h6 class="title-price">
						<small>CATEGORY</small>
					</h6>
					<h4 style="margin-top: 0px;">${product.category.name}</h4>
				</div>
				<div class="section" style="padding-bottom: 20px;">
					<h6 class="title-attr">
						<small>QUANTITY</small>
					</h6>
					<div>
						<div class="btn-minus">
							<span class="glyphicon glyphicon-minus"></span>
						</div>
						<input id="amount" value="${product.amount}" />
						<div class="btn-plus">
							<span class="glyphicon glyphicon-plus"></span>
						</div>
					</div>
					<hr>
					<div class="section" style="padding-bottom: 20px;">
						<button style="marign-left: 200px;" class="btn btn-primary">
							<span style="text-align: center;"></span>Send
						</button>
					</div>
				</div>

				<!-- Botones de compra -->

			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>