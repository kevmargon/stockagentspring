<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Edition | StockAgent</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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

	<jsp:include page="scripts.jsp"></jsp:include>

</body>
</html>