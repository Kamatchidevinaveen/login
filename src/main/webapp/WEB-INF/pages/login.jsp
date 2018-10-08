<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login page</title>
        
        <link rel="shortcut icon" href="img/favicon.ico" />
       	<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet"></link>
       	<link href="css/font-awesome/webfonts/fontawesome-all.min.css" rel="stylesheet"></link>
       	
       	<link href="css/helloworld-common.css" rel="stylesheet"></link>
       	<link href="css/login.css" rel="stylesheet"></link>
        
        <script src="js/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
 		<script src="js/popper/popper.min.js" type="text/javascript"></script>
 		<script src="js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
    </head>
 
    <body> 
	    <div class="container">
	    	<div class="login-section login-center">
			     <form action="<%=request.getContextPath()%>/j_spring_security_check" method="post" class="form-horizontal" accept-charset="UTF-8">
			         <c:if test="${param.error != null}">
			             <div class="alert alert-danger inputdiv-placing">
			                 <p class="login-alert-message">Invalid username or password.</p>
			             </div>
			         </c:if>
			         <c:if test="${param.logout != null}">
			             <div class="alert alert-success inputdiv-placing">
			                 <p class="login-alert-message">You have been logged out successfully.</p>
			             </div>
			         </c:if>
			         <div class="form-group">
				         <div class="input-group inputdiv-placing">
				             <span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
				             <input type="text" class="form-control" id="username" name="username" placeholder="Username" required>
				         </div>
			         </div>
			         <div class="form-group">
				         <div class="input-group inputdiv-placing">
				             <span class="input-group-addon"><i class="fa fa-lock" aria-hidden="true"></i></span> 
				             <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
				             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				         </div>
			         </div>
			         <div class="form-group">
			         	<button type="submit" class="btn btn-block btn-primary btn-default login-button">Log in</button>
			         </div>
			     </form>
	     </div>
	    </div>
    </body>
</html>