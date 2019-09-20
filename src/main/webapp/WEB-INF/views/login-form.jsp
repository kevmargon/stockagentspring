<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/ico" href="../img/icon.ico">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/loginstyle.css">
    <title>StockAgent Login</title>

  </head>
  <body class="text-center">
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="${pageContext.request.contextPath}/img/logo.png" style="width:50%; height:50%;" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action="${pageContext.request.contextPath}/login" method = "POST"> <!-- ModelAttribute = "employee" -->
      <input type="text" id="login" class="fadeIn second" name="user" placeholder="login" required />
      <input type="password" id="password" class="fadeIn third" name="pass" placeholder="password" required />
      <input type="submit" class="fadeIn fourth" value="Log In" />
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>
<jsp:include page="scripts.jsp"></jsp:include>
</body>
</html>

