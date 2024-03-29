<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List | StockAgent</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
<!-- Navigation -->
	<c:set var = "navigation" scope = "session" value = "product"/>
  	<jsp:include page="header.jsp"></jsp:include>
<!-- Recover session attributes -->
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	<c:if test="${Login == true }">

	<div class="pt-5 container">
		<h1>Products Directory</h1>
		<hr />
		
		<c:if test="${nameCat.isEmpty() || nameCat == null}">
			<h3 style="text-align: center;">Product List</h3>
			<c:set var="n" value="1"/>
			<hr />
		</c:if>

		<c:if test="${n!=1}">
			<h3 style="text-align: center;">Category ${nameCat}. Products</h3>
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

			<div class="btn-group">
				<div class="dropdown">

					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<c:forEach items="${categories}" var="category">
							<a class="dropdown-item"
								href="${pageContext.request.contextPath}/categories/${category.id}/productslist">${category.name}</a>
						</c:forEach>
					</div>

				</div>

				<c:if test="${allowedall == true }">
					<p style="text-align: right; margin-left: 10px;">
						<button class="btn btn-primary"
							onclick="window.location.href = '${pageContext.request.contextPath}/products/empty'">Add
							Product</button>
					</p>
				</c:if>
			</div>


			<table class="table table-striped table-bordered">

			<tr class="thead-gd light">
				<th>Name</th>
				<th>Price</th>
				<th>Amount</th>
				<th>Manufacturer</th>
				<th>Category</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${products}" var="product">
				<tr class="thead-gd light">
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.amount}</td>
					<td>${product.manufacturer}</td>
					<td><span class = "badge badge-light" ><a href="${pageContext.request.contextPath}/categories/${product.category.id}">${product.category.name}</a></span>
					</td>
					<td style="min-width:200px;"> <a href="${pageContext.request.contextPath}/products/${product.id}/detail"><span class="fa fa-eye" style ="font-size:24px" title="Show details"></span></a>
						<c:if test="${allowedall == true }">
						&nbsp;|&nbsp;
						<a href="${pageContext.request.contextPath}/products/${product.id}"><span class="fa fa-edit" style = "font-size:24px" title="Edit element"></span></a>
						&nbsp;|&nbsp;
						<a href="${pageContext.request.contextPath}/products/${product.id}/delete" onclick="return confirm('${product.name} will be removed');"><span class="fa fa-trash"  style = "font-size:24px" title="Delete element"></span></a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	</c:if>

<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>