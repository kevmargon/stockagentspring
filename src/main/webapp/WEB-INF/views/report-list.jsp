<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report List | StockAgent</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<c:set var = "navigation" scope = "session" value = "report"/>
  	<jsp:include page="header.jsp"></jsp:include>
  	<!-- Recover session attributes -->
	<c:set var="idLogin" scope="page" value="${sessionScope.idLogin}" />
	<c:set var="Login" scope="page" value="${sessionScope.Login}" />
	<c:set var="allowedall" scope="session" value="${allowedall}" />
	
	<c:if test="${Login == true }">
  	

	<div style="margin-bottom: 100px;'"class="pt-5 container">

		<h1>Reports Directory</h1>
		<hr />
		
		<c:if test="${nameEmp.isEmpty() || nameEmp == null}">
			<h3 style="text-align: center;">Report List</h3>
			<c:set var="n" value="1"/>
			<hr />
		</c:if>

		<c:if test="${n!=1}">
			<h3 style="text-align: center;">Employee ${nameEmp}. Reports</h3>
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
			
			<p  style="text-align: left;">
			<button class = "btn btn-primary" onclick="window.location.href = '${pageContext.request.contextPath}/reports/empty'">Add Report</button>
		</p>
		<table class="table table-striped table-bordered">

			<tr class="thead-gd light">
				<th>ID</th>
				<th>Employee</th>
				<th>Date Time</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${reports}" var="report">
				<tr>
					<td>${report.id}</td>
					<td>${report.employee.name}</td>
					<td>${report.dateTime}</td>
					<td>${report.description}</td>
					<td><a href="${pageContext.request.contextPath}/reports/${report.id}/detail"><span class="fa fa-file-pdf-o" style ="font-size:24px" title="Download as PDF"></span></a>
						<c:if test="${allowedall == true }">
						&nbsp;|&nbsp;
						<a href="${pageContext.request.contextPath}/reports/${report.id}/delete" onclick="return confirm('Report from ${report.employee.name} will be removed');"><span class="fa fa-trash"  style = "font-size:24px" title="Delete element"></span></a>
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