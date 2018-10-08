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
    	<jsp:include page="navbar/navbar.jsp" />
	    <div class="container">
	    	<h3>Hello ${user}</h3>
	    </div>
    </body>
</html>