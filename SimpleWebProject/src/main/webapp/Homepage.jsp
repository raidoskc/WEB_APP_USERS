<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Homepage</title>
<link href="./CSS/Homepage.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="flexbox-container">

		<a href="<%=request.getContextPath()%>/DisplayUsers.jsp?action=list">
			<div class="flexbox-item flexbox-User">
				<p>Users</p>
			</div>
		</a> 
		<a href="<%=request.getContextPath()%>/RegisterUser.jsp">
			<div class="flexbox-item flexbox-Register">
				<p>Register</p>
			</div>
		</a>

	</div>

</body>
</html>