<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee List | StockAgent</title>
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
	<c:set var="navigation" scope="session" value="employee" />
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Recover session attributes -->
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	<c:if test="${Login == true }">
		<c:if test="${allowedall == true }">


			<div class="pt-5 container">

				<h1>Employees Directory</h1>
				<hr />

				<h3 style="text-align: center;">Employee List</h3>
				<c:set var="n" value="1" />
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

				<p>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/employees/empty">Add
						Employee</a>
				</p>

				<table class="table table-striped table-bordered">
					<tr class="thead-gd light">
						<th>Name</th>
						<th>Directions</th>
						<th>Roles</th>
						<th>Actions</th>
					</tr>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td>${employee.surname1}${employee.surname2},
								${employee.name}</td>
							<td style="min-width: 200px;">${employee.direction.address},
								${employee.direction.houseNumber},
								${employee.direction.zipCode}, ${employee.direction.city},
								${employee.direction.province}, ${employee.direction.country}</td>
							<td><c:forEach items="${employee.roles}" var="role">
									<span class="badge badge-light">${role.name}</span>
								</c:forEach></td>
							<td style="min-width: 200px;"><a
								href="${pageContext.request.contextPath}/employees/${employee.id}/detail"><span
									class="fa fa-eye" style="font-size: 24px" title="Show details"></span></a>
								&nbsp;|&nbsp; <a
								href="${pageContext.request.contextPath}/employees/${employee.id}"><span
									class="fa fa-edit" style="font-size: 24px" title="Edit element"></span></a>
								&nbsp;|&nbsp; <a
								href="${pageContext.request.contextPath}/employees/${employee.id}/delete"
								onclick="return confirm('${employee.name} will be removed');"><span
									class="fa fa-trash" style="font-size: 24px"
									title="Delete element"></span></a></td>
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
					<h1>Access denied. Sorry, you don't have permissions for this
						action.</h1>
					<a class="btn btn-primary"
						href="${pageContext.request.contextPath}/products/list">Go
						back to products list</a>
				</div>
			</div>
		</div>
	</c:if>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>