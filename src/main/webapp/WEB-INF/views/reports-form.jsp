<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<title>Report Form</title>
</head>
<body>
<!-- Navigation -->
	<c:set var = "navigation" scope = "session" value = "report"/>
	<jsp:include page="header.jsp"></jsp:include>
<!-- Recover session attributes -->
	<c:set var="nameEmployee" scope="page" value="${sessionScope.nameEmployee}" />
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	<c:if test="${Login == true }">
	

	<div class="container">

		<h3 style="text-align: center;">Report Form</h3>
		<hr />

		<div style="margin: auto;" class="row">
			<div style="margin:auto; padding:20px;" class="col-md-5 bg-light text-dark">
				<form action="${pageContext.request.contextPath}/reports" method="POST">
					<div class="form-group">
						<textarea class="form-control" name="description" id="description" placeholder="Explain the situation" rows=10></textarea>
					</div>
					<input type="hidden" name="employeeid" id="employeeid" value="${idLogin}" />
					<button type="submit" class="btn btn-primary">Send</button>
				</form>
				<a href="${pageContext.request.contextPath}/reports">Back to List</a>
			</div>
		</div>
		
	</div>
	</c:if>
<jsp:include page="scripts.jsp"></jsp:include>

</body>
</html>