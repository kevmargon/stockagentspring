<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direction List | StockAgent</title>
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
	<c:set var="navigation" scope="session" value="direction" />
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Recover session attributes -->
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	<c:if test="${Login == true }">
		<c:if test="${allowedall == true }">

			<div class="pt-5 container">
				<h1>Directions Directory</h1>
				<hr />

				<c:if test="${nameDir.isEmpty() || nameDir == null}">
					<h3 style="text-align: center;">Directory List</h3>
					<c:set var="n" value="1" />
					<hr />
				</c:if>

				<c:if test="${n!=1}">
					<h3 style="text-align: center;">Employee ${nameEmp}. Reports</h3>
					<hr />
				</c:if>
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

					<tr class="thead-gd light">
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
							<td>${direction.houseNumber}</td>
							<td>${direction.zipCode}</td>
							<td>${direction.city}</td>
							<td>${direction.province}</td>
							<td>${direction.country}</td>
						</tr>

					</c:forEach>

				</table>

			</div>
		</c:if>
	</c:if>


	<c:if test="${allowedall != true }">
		<div class="pt-5 container">
			<div class="row">
				<div class="col">
					<h1>Access denied. Sorry, you don't have permissions for
						this action.</h1>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/products/list">Go back to products list</a>
				</div>
			</div>
		</div>
	</c:if>


	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>