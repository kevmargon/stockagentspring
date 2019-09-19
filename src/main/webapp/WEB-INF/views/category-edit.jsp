<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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