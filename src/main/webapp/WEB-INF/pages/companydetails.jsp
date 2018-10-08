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
         function show_company() {
         $(document).ready( function () {
         var table = $('#myTable_1').dataTable();
         $.get('/getAllCompany', function(company) {
         console.log(company);
        var unique_row  = [...new Set(company.map(item => item.companyName))];
         console.log(unique_row);
          $.get("/getByCompany?companyName="+unique_row, function(company_1) {
          console.log(company_1.user.length);
 		  table.api().row.add( [  1 , company_1.companyName , company_1.employeeCount , '<button type="button"  class="user" data-toggle="modal"  data-target="#myModal">View</button>']);
 		 table.api().draw();
 		 $(".user").click(user_list);
 		 function user_list(){
 		  var table_1 = $('#myTable_2').dataTable();
 		  table_1.api().clear();
 		 for(var i=0; i<company_1.user.length ; i++) {
 		table_1.api().row.add([company_1.user[i].userName ]); 
 		table_1.api().draw();
 		 var userName = company_1.user[i].userName;
 		 console.log(userName);
 		 }
 		 }
     });
     });
  } );
}
show_company();
</script>
 </head>
<body>
      <jsp:include page="navbar/navbar.jsp" />
      <table id="myTable_1" class="display" >
      <thead><tr><th scope="col"> #</th> 
       <th scope="col"> CompanyName</th>
      <th scope="col">employeeCount</th>
      <th scope="col">UserDetails</th>
      </tr></thead>
      <tbody>
      </tbody>
      </table>
      <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">ListOfUser</h4>
        </div>
         <div class="modal-body">
        <table id="myTable_2" class="display" >
      <thead><tr><th scope="col">ListOfUsers</th> 
      </thead><tbody>
      </tbody>
      </table>
        </div>
        
        
        <!-- Modal footer -->
        <div class="modal-footer">
          
             <button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
              </div>
        
      </div>
    </div>
  </div>
  
</div>
           
</body>
</html>
