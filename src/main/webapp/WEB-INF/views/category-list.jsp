<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<title>Category List | StockAgent</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<!-- Navigation -->
	<c:set var = "navigation" scope = "session" value = "category"/>
  	<jsp:include page="header.jsp"></jsp:include>
	
	<div class = "pt-5 container">
		
		<h1>Categories Directory</h1>
		<hr/>
		
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
			<a class = "btn btn-primary" href="${pageContext.request.contextPath}/categories/empty">Add Category</a>
			
		</p>
	
		<table class = "table table-striped table-bordered">
			<tr class = "thead-gd light">
				<th>Name</th>
				<th>Products</th>
				<th>Actions</th>
			</tr>			
			<c:forEach items="${categories}" var="category">			
				<tr>
					<td>${category.name}</td>
				
					
					<td><c:forEach items = "${category.products}"  var="product"> 
					<span class = "badge badge-light" ><a href = "${pageContext.request.contextPath}/products/${product.id}">${product.name}</a></span></c:forEach> </td>
					<td> 
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}/detail"><span class="fa fa-eye" style ="font-size:24px" title="Show details"></span></a>
						&nbsp;|&nbsp;
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}"><span class="fa fa-edit" style = "font-size:24px" title="Edit element"></span></a> 
						&nbsp;|&nbsp;
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}/delete"><span class="fa fa-trash"  style = "font-size:24px" title="Delete element"></span></a> 
						&nbsp;|&nbsp;
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}/deleteAll"><span class="fa fa-trash"  style = "font-size:24px;color:red" title="Delete element and associated children"></span></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>