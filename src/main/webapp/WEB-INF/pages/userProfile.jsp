<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
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
         <script type="text/javascript">
 		$(document).ready(function() {
        $('#edit').click(function(event) {
        		var userName = $("#username").val();
                $.get("/userDetails?username=" +userName, function(user) {
                 $('#firstname').val(user.firstName);
                 $('#lastname').val(user.lastName);
                 $('#age').val(user.age);
                 $('#email_1').val(user.email);
                 $('#maritalstatus').val(user.maritalStatus);
                 $('#contactnumber').val(user.contactNumber);
                 
                });
        });
});
</script>
		<script type ="text/javaScript">
		$(document).ready(function() {
		$('#update').click(function(event) {
		var userName = $("#username").val();
		var firstName = $("#firstname").val();
		var lastName = $("#lastname").val();
		var age = $("#age").val();
		var contactNumber = $("#contactnumber").val();
		var Email = $("#email_1").val();
		var maritalStatus = $("#maritalstatus").val();
		$.post('/updateUser',jQuery.param ({username: userName, firstname: firstName, lastname : lastName, email : Email, contactnumber : contactNumber, maritalstatus : maritalStatus, age:age}),function(data){
             });
		});
});
</script>
 		
</head>

<body>
      <jsp:include page="navbar/navbar.jsp" />
		
<div class="container">
  <!-- Button to Open the Modal -->
  <table style="with: 50%" align="center">
				
				<tr>
					<td>UserName</td>
					<td><input type="text" id="username"/>
					
					</td>
				</tr>
				<td><tr><td>
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="edit">
    Edit
  </button></td></tr></table>

  <!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Edit</h4>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          	<table style="with: 50%" align="center">
          
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" id="firstname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" id="lastname" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" id="email_1" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" id="age"/></td>
				</tr>
				<tr>
					<td>MaritalStatus</td>
					<td><input type="text" name="maritalstatus" id="maritalstatus" /></td>
				</tr>
				<tr>
					<td>ContactNumber</td>
					<td><input type="text" name="contactnumber" id="contactnumber" /></td>
				</tr>
				<tr>
				<td></table>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-info"  data-toggle="modal" data-target="#myModal_1" data-dismiss="modal" id="update">Update</button>
             <a href="/userprofile">
             <button type="button" class="btn btn-danger">Cancel</button></a>
              </div>
        
      </div>
    </div>
  </div>
  
</div>
<div class="modal fade" id="myModal_1">
  <div class="modal-dialog modal-dialog-centered modal-sm">
    <div class="modal-content">
    <!-- Modal body -->
      <div class="modal-body">
      <center>
       Updated Successfully!</center>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
       <a href="/userprofile">
        <button type="button" class="btn btn-success" >Ok</button></a>
      </div>

    </div>
  </div>
</div>


  </body>
</html>