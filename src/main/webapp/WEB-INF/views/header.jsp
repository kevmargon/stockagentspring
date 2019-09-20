<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<c:set var="active1" scope="page" value="" />
<c:set var="active2" scope="page" value="" />
<c:set var="active3" scope="page" value="" />
<c:set var="active4" scope="page" value="" />
<c:set var="active5" scope="page" value="" />
<c:set var="active6" scope="page" value="" />
<c:set var="active7" scope="page" value="" />

<c:if test="${navigation =='home'}">
	<c:set var="active1" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='product'}">
	<c:set var="active2" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='category'}">
	<c:set var="active3" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='direction'}">
	<c:set var="active4" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='report'}">
	<c:set var="active5" scope="page" value="active" />
</c:if>
<c:if test="${navigation =='employee'}">
	<c:set var="active6" scope="page" value="active" />
</c:if>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#"><img
		src="${pageContext.request.contextPath}/img/logoheader.png"
		style="margin-left: 10px; position: relative;" width="70px"
		height="50px">&nbsp;StockAgent</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link ${active1}"
				href="${pageContext.request.contextPath}/products">Home <span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link ${active2}"
				href="${pageContext.request.contextPath}/products">Products</a></li>
			<li class="nav-item"><a class="nav-link ${active3}"
				href="${pageContext.request.contextPath}/categories">Categories</a>
			</li>
			<li class="nav-item"><a class="nav-link ${active4}"
				href="${pageContext.request.contextPath}/directions">Directions</a>
			</li>
			<li class="nav-item"><a class="nav-link ${active5}"
				href="${pageContext.request.contextPath}/reports">Reports</a></li>
			<li class="nav-item"><a class="nav-link ${active6}"
				href="${pageContext.request.contextPath}/employees">Employees</a></li>
			<li class="nav-item"><a class="nav-link ${active7}"
				href="${pageContext.request.contextPath}/login">Logout</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0" action="" method="POST">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search by Product" aria-label="Search">

			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>