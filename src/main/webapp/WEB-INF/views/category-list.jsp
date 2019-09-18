<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List | StockAgent</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
      <a class="navbar-brand" href="#">StockAgent</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/products">Product</a>
          	
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="${pageContext.request.contextPath}/categories">Category</a>
            <span class="sr-only">(current)</span>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/directions">Direction</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
	
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
			<tr class = "thead-dark">
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
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/categories/${category.id}/detail">Details</a>
						<a class="btn btn-info" href = "${pageContext.request.contextPath}/categories/${category.id}">Edit</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/categories/${category.id}/delete">Delete</a> 
						<a class="btn btn-danger" href = "${pageContext.request.contextPath}/categories/${category.id}/deleteAll">DeleteALL</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<p>	* The option Delete, deletes only the category and the associated products will set their category field to null.</p>
		<p>	* The option DeleteALL, deletes the category and all the products from that category.</p>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>