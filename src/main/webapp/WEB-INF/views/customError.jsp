<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Error | StockAgent</title>
<link rel="icon" type="image/ico"
	href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<body>
	<!-- Recover session attributes -->
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	<c:if test="${Login == true }">
		<div class="container pt-5">
			<div class="row">
				<div class="col">
					<h1>Oops! Unexpected error happened.</h1>
					<br> <a class="btn btn-primary"
						href="${pageContext.request.contextPath}/products">Back to
						list</a>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${Login == false }">
		<div class="container pt-5">
			<div class="row">
				<div class="col">
					<h1>Oops! Unexpected error happened.</h1>
					<br> <a class="btn btn-primary"
						href="${pageContext.request.contextPath}/login">Log in</a>
				</div>
			</div>
		</div>
	</c:if>

	<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>