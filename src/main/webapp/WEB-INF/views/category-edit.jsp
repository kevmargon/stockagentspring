<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<jsp:include page="scripts.jsp"></jsp:include>

</body>
</html>