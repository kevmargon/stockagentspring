<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
<c:set var="Login" scope="page" value="${sessionScope.Login}" />
<c:set var="rolesEmployeeArray" scope="page" value="${sessionScope.rolesEmployeeArray}" />
<c:set var="allowedall" scope="page" value="" />
<c:forEach var="emprole" items="${rolesEmployeeArray}">
	<c:if test="${emprole =='Do All Master/ Admin'}">
		<c:set var="allowedall" scope="page" value="true" />
	</c:if>
</c:forEach>


<c:set var="active1" scope="page" value="" />
<c:set var="active2" scope="page" value="" />
<c:set var="active3" scope="page" value="" />
<c:set var="active4" scope="page" value="" />
<c:set var="active5" scope="page" value="" />
<c:set var="active6" scope="page" value="" />


<c:if test="${navigation =='product'}">
	<c:set var="active1" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='category'}">
	<c:set var="active2" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='direction'}">
	<c:set var="active3" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='report'}">
	<c:set var="active4" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='employee'}">
	<c:set var="active5" scope="page" value="active" />
</c:if>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/products"><img
		src="${pageContext.request.contextPath}/img/logoheader.png"
		style="margin-left: 10px; position: relative;" width="70px"
		height="50px">&nbsp;StockAgent</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<c:if test="${Login =='true'}">
		<c:if test="${allowedall =='true'}">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link ${active3}"
						href="${pageContext.request.contextPath}/products">Products</a></li>
					<li class="nav-item"><a class="nav-link ${active4}"
						href="${pageContext.request.contextPath}/categories">Categories</a></li>
					<li class="nav-item"><a class="nav-link ${active3}"
						href="${pageContext.request.contextPath}/directions">Directions</a></li>
					<li class="nav-item"><a class="nav-link ${active4}"
						href="${pageContext.request.contextPath}/reports">Reports</a></li>
					<li class="nav-item"><a class="nav-link ${active5}"
						href="${pageContext.request.contextPath}/employees">Employees</a></li>
					<li class="nav-item"><a class="nav-link ${active6}"
						href="${pageContext.request.contextPath}/login">Logout</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0"
					action="${pageContext.request.contextPath}/search" method="POST">
					<input class="form-control mr-sm-2" name="name" type="search"
						placeholder="Search by Product" aria-label="Search" required>
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</c:if>
		<c:if test="${allowedall !='true'}">
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link ${active3}"
						href="${pageContext.request.contextPath}/products">Products</a></li>
					<li class="nav-item"><a class="nav-link ${active4}"
						href="${pageContext.request.contextPath}/categories">Categories</a></li>
					<li class="nav-item"><a class="nav-link ${active4}"
						href="${pageContext.request.contextPath}/reports">Reports</a></li>
					<li class="nav-item"><a class="nav-link ${active6}"
						href="${pageContext.request.contextPath}/login">Logout</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0"
					action="${pageContext.request.contextPath}/search" method="POST">
					<input class="form-control mr-sm-2" name="name" type="search"
						placeholder="Search by Product" aria-label="Search" required>
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</c:if>
	</c:if>
	<c:if test="${Login =='false'}">
		<li class="nav-item"><a class="nav-link ${active6}"
						href="${pageContext.request.contextPath}/login">Log In</a></li>
	</c:if>

</nav>

<c:if test="${Login =='false'}">
		<br>
		<h1>Sorry. You are not logged</h1>
		<br>
</c:if>