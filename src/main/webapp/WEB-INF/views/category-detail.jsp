<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<title>Category Edition | StockAgent</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<!-- Navigation -->
		<c:set var = "navigation" scope = "session" value = "category"/>
  	<jsp:include page="header.jsp"></jsp:include>

	<div class="pt-5 container">
		<h2>Category ${category.id}: ${category.name} </h2>
		<hr>


		<table class="table table-striped table-bordered">

			<tr class="thead-gd light">
				<th>Listado de productos de "${category.name}"</th>

			</tr>

			<tr>
				<td>crear un listado de productos (solo nombre con link y acciones de eliminado,etc)</td>
			</tr>
		</table>


		<a class="btn btn-info"
			href="${pageContext.request.contextPath}/categories">Back list</a>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>