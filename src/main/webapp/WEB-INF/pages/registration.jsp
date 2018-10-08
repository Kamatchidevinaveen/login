<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>${documentName}</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/samplejs.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/samplecss.css"></link>
</head>
<body>
 
   <form action="/newUser" method="post">
   	<input type="text" name="userName" />
   	<input type="text" name="password" />
   	<input type="text" name="firstName" />
   	<input type="text" name="lastName" />
   	<input type="text" name="email" />
   	<button type="submit">submit</button>
   </form>
</body>
</html>