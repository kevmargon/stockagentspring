<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Edition | StockAgent</title>
<link rel="icon" type="image/ico"
	href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:set var="navigation" scope="session" value="product" />
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Recover session attributes -->
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	<c:if test="${Login == true }">
		<c:if test="${allowedall == true }">

			<div class="pt-5 container">
				<h2>Product ${product.id}</h2>
				<hr>
				<div class=" row justify-content-center">
					<div class="col-md-8">
						<form:form action="${pageContext.request.contextPath}/products"
							method="POST" modelAttribute="product">

							<div class="form-group">
								<label for="name">Name</label>
								<form:input class="form-control" path="name" />
							</div>

							<div class="form-group">
								<label for="price">Price</label>
								<form:input class="form-control" path="price" />
							</div>

							<div class="form-group">
								<label for="amount">Amount</label>
								<form:input class="form-control" path="amount" />
							</div>

							<div class="form-group">
								<label for="manufacturer">Manufacturer</label>
								<form:input class="form-control" path="manufacturer" />
							</div>

							<div class="form-group">
								<label for="category">Category</label><br>
								<form:select class="form-control" path="category"
									items="${categories}" itemLabel="name" itemValue="id" />
							</div>

							<form:hidden path="id" />
							<a class="btn btn-info"
								href="${pageContext.request.contextPath}/products">Back to
								list</a>
							<button class="btn btn-primary" type="submit">Save</button>
						</form:form>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${allowedall != true }">
			<div class="pt-5 container">
				<div class="row">
					<div class="col">
						<h1>Access denied. Sorry, you don't have permissions for this action.</h1>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/products/list">Go back to products list</a>
					</div>
				</div>
			</div>
		</c:if>
	</c:if>


	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>