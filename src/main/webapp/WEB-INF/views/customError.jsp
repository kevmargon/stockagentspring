<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Error | TheProductApp</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
	<div class="container pt-5">
		<div class="row">
			<div class="col">
				<h1>Unexpected error happened!</h1>
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/products">Back to
					list</a>
			</div>

		</div>


	</div>
<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>