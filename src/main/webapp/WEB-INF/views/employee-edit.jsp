<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Edition | StockAgent</title>
<link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/img/icon.ico">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<!-- Navigation -->
  	<c:set var = "navigation" scope = "session" value = "employee"/>
  	<jsp:include page="header.jsp"></jsp:include>
	
	<div class = "pt-5 container">
			<h2>Employee ${employee.id}</h2>
			<hr>
		<div class = " row justify-content-center">

			<div class = "col-md-8">
				<form:form action = "${pageContext.request.contextPath}/employees" method="POST" modelAttribute = "employee">
				
					<div class = "form-group">
					  <label for="user">User</label>
							<form:input class = "form-control"  path="user"/> 
					</div>
				
					<div class = "form-group">
						<label for="pass">Pass</label>
							<form:input class = "form-control"  path="pass"/> 
					</div>
					
					<div class="form-group">
						<label for="dni">DNI</label>
							<form:input class = "form-control"  path="dni"/> 
					</div>
					
				
					<div class="form-group">
						<label for="name">Name</label>
							<form:input class = "form-control"  path="name"/> 
					</div>
					
					<div class="form-group">
						<label for="surname1">Surname1</label>
							<form:input class = "form-control"  path="surname1"/> 
					</div>
					
					<div class="form-group">
						<label for="surname2">Surname2</label>
							<form:input class = "form-control"  path="surname2"/> 
					</div>
					
					<div class="form-group">
						<label for="phoneNumber">Phone</label>
							<form:input class = "form-control"  path="phoneNumber"/> 
					</div>
					<hr>	
					<b>Direction</b>
					<br>
					<br>	
					<div class="form-group">
						<label for="direction.country">Country</label>
							<form:input class = "form-control"  path="direction.country"/> 
					</div>
					
					<div class="form-group">
						<label for="direction.province">Province</label>
							<form:input class = "form-control"  path="direction.province"/> 
					</div>
					
					<div class="form-group">
						<label for="direction.city">City</label>
							<form:input class = "form-control"  path="direction.city"/> 
					</div>
					
					<div class="form-group">
						<label for="direction.adress">Address</label>
							<form:input class = "form-control"  path="direction.address"/> 
					</div>
					
					<div class="form-group">
						<label for="direction.zipCode">Zip Code</label>
							<form:input class = "form-control"  path="direction.zipCode"/> 
					</div>
					
					<div class="form-group">
						<label for="direction.houseNumber">House Number</label>
							<form:input class = "form-control"  path="direction.houseNumber"/> 
					</div>
					
					<div class="form-group">
						<label for="roles">Role</label><br>
					  	<form:select class = "form-control" path = "roles" items = "${roles}" itemLabel = "name" itemValue = "id"/>
					</div>
					
					<form:hidden path = "id"/>
					<a class = "btn btn-info" href = "${pageContext.request.contextPath}/employees" >Back to list</a>
					<button class = "btn btn-primary" type = "submit" >Save</button>
				</form:form>
			</div>
		</div>
	</div>
	
<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>