<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.List" %>
<%@page import="net.java.registration.model.User" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/User.css" /> 
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>A/A</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Gender</th>
				<th>Birthday</th>
				<th>Work Address</th>
				<th>Home Address</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i =  Integer.parseInt(request.getAttribute("id").toString());
				List<User> list = (List) request.getSession().getAttribute("USERS");
			%>			
			
			<tr>
				<td><%=i %></td>
				<td><%=list.get(i-1).getName() %></td>
				<td><%=list.get(i-1).getSurname() %></td>
				<td><%=list.get(i-1).getGender() %></td>
				<td><%=list.get(i-1).getBirthday() %></td>
				<td><%=list.get(i-1).getWorkAddress() %></td>
				<td><%=list.get(i-1).getHomeAddress() %></td>
			</tr>
					
			
		</tbody>
	</table>

</body>
</html>