<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="error.jsp"%>
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
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">

		<h3 style="text-align: center;">Report Form</h3>
		<hr />

		<div style="margin: auto;" class="row">
			<div style="margin:auto; padding:20px;" class="col-md-5 bg-light text-dark">
				<form action="${pageContext.request.contextPath}/AdminCategoryServ" method="POST">
					<div class="form-group">
						<textarea class="form-control" id="name" placeholder="Explain the situation" rows=10></textarea>
					</div>

					<input type="hidden" name="id" value="${category.id}" />

					<button type="submit" class="btn btn-primary">Send</button>
				</form>
				<a href="${pageContext.request.contextPath}/AdminCategoryServ?action=LIST">Back	to List</a>
			</div>
		</div>
		
	</div>
<jsp:include page="scripts.jsp"></jsp:include>

</body>
</html>