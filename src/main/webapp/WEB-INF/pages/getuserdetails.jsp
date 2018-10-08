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
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css"> 		

<script type="text/javascript">
         function show_user() {
         $(document).ready( function () {
         var table = $('#myTable').DataTable();
         table.clear();
         $.get('/getAllUser', function(users) {
 		 for(var i=0; i<users.length;i++) {
 		  table.row.add( [  i , users[i].firstName ,users[i].lastName  , users[i].email, users[i].projectName , users[i].salary , users[i].experience, users[i].age  , users[i].maritalStatus  , users[i].contactNumber , '<button type="button"  class="delete_user" data-id="' + users[i].userName + '"  row="' + i + '">Delete</button>','<button type="button"  class="edit_user" data-id="' + users[i].userName + '"  row="' + i + '" data-toggle="modal" data-target="#myModal">Edit</button>']);
 		 }
 		 table.draw();
 		 $('#myTable').dataTable();
 		$(".delete_user").click(delete_item);
 		$(".edit_user").click(edit_item);
 		   
 	  });
  } );
}
function delete_item()  {
 		  var user = $(this).attr('data-id');
 		  $.ajax({
        url: "/deleteUser?username=" + user,
        type: 'DELETE',
        success: function() {
       show_user();
    }

});
}
function edit_item() {
         var user_edit = $(this).attr('data-id');
          $.get("/userDetails?username=" +user_edit, function(user) {
                 $('#firstname').val(user.firstName);
                 $('#lastname').val(user.lastName);
                 $('#age').val(user.age);
                 $('#email_1').val(user.email);
                 $('#maritalstatus').val(user.maritalStatus);
                 $('#projectname').val(user.projectName);
                 $('#salary').val(user.salary);
                 $('#experience').val(user.experience);
                 $('#contactnumber').val(user.contactNumber);
                 $('#myModal').on('input change', function() {
                    $('#update').attr('disabled', false);
                   });
                            $("#update").click(update_item);  
                 
                });
  function update_item() {
      var userName = user_edit;
		var firstName = $("#firstname").val();
		var lastName = $("#lastname").val();
		var age = $("#age").val();
		var projectName = $("#projectname").val();
		var salary = $("#salary").val();
		var experience = $("#experience").val();
		var contactNumber = $("#contactnumber").val();
		var Email = $("#email_1").val();
		var maritalStatus = $("#maritalstatus").val();
		$.post('/updateUser',jQuery.param ({username: userName, firstname: firstName, lastname : lastName, email : Email, contactnumber : contactNumber, maritalstatus : maritalStatus, age:age , projectname:projectName , salary:salary , experience:experience}),function(data){
             });
		  }
}       
show_user();
</script>
</head>

<body>
      <jsp:include page="navbar/navbar.jsp" />
      <table id="myTable" class="display" >
      <thead><tr><th scope="col"> #</th> 
      <th scope="col"> FirstName</th>
      <th scope="col">LastName  </th>
      <th scope="col">Email</th>
      <th scope="col">ProjectName</th>
      <th scope="col">Salary</th>
      <th scope="col">Exprience</th>
      <th scope="col">Age</th>
      <th scope="col"> MaritalStatus</th>
      <th scope="col">ContactNumber</th>
      <th scope="col">DeleteUser</th>
       <th scope="col">EditUser</th></tr></thead>
      <tbody>
      </tbody>
      </table>
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
					<td>ProjectName</td>
					<td><input type="text" name="projectname" id="projectname" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="text" name="salary" id="salary" /></td>
				</tr>
				<tr>
					<td>Experience</td>
					<td><input type="text" name="experience" id="experience" /></td>
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
          <button type="button" class="btn btn-info"  data-toggle="modal" data-target="#myModal_1" data-dismiss="modal" id="update" disabled>Update</button>
             
             <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
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
       <a href="/getuserdetails">
        <button type="button" class="btn btn-success" >Ok</button></a>
      </div>

    </div>
  </div>
</div>


     
      </body>
</html>