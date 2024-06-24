<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404</title>
<link href="${pageContext.request.contextPath}/CSS/NotFound.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="error-container"> 
        <h1> 404 </h1> 
        <p> 
            Oops! The page you're 
            looking for is not here. 
        </p> 
        <a href="<%=request.getContextPath()%>/Homepage.jsp"> 
            Go Back to Home 
        </a> 
    </div> 

</body>
</html>