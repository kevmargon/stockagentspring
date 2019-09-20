<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Direction List | StockAgent</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:set var = "navigation" scope = "session" value = "direction"/>
  	<jsp:include page="header.jsp"></jsp:include>
	<div class="pt-5 container">

		<h1>Directions Directory</h1>
		<hr />

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

<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>