<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<form action="/newUser" method="post">
  
			<table style="with: 50%" align="center">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>ProjectName</td>
					<td><input type="text" name="projectName" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="text" name="salary" /></td>
				</tr>
				<tr>
					<td>Experience</td>
					<td><input type="text" name="experience" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" /></td>
				</tr>
				<tr>
					<td>MaritalStatus</td>
					<td><input type="text" name="maritalStatus" /></td>
				</tr>
				<tr>
					<td>ContactNumber</td>
					<td><input type="text" name="contactNumber" /></td>
				</tr>
				<tr>
				<td>
				<button type="submit" class="btn btn-block btn-primary btn-default submit-button"  >Submit</button>
</td></tr></table></form>
</body>
</html>