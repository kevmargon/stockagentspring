<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List | StockAgent</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
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
		
		<c:if test="${nameCat.isEmpty() || nameCat == null}">
			<h3 style="text-align: center;">Category List</h3>
			<c:set var="n" value="1"/>
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
					<td style="min-width:200px;"> 
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}/detail"><span class="fa fa-eye" style ="font-size:24px" title="Show details"></span></a>
						&nbsp;|&nbsp;
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}"><span class="fa fa-edit" style = "font-size:24px" title="Edit element"></span></a> 
						&nbsp;|&nbsp;
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}/delete" onclick="return confirm('${category.name} will be removed');"><span class="fa fa-trash"  style = "font-size:24px" title="Delete element"></span></a> 
						&nbsp;|&nbsp;
						<a  href = "${pageContext.request.contextPath}/categories/${category.id}/deleteAll" onclick="return confirm('${category.name} and all its associated products will be removed');"><span class="fa fa-trash"  style = "font-size:24px;color:red" title="Delete element and associated children"></span></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		</div>

<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>