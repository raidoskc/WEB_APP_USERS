<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.List" %>
<%@page import="net.java.registration.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users</title>
<link href="${pageContext.request.contextPath}/CSS/DisplayUsers.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<th>A/A</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Delete User</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 0;
				List<User> list = (List) request.getAttribute("list");
				request.getSession().setAttribute("USERS", list);
			%>
			
			<%
				for(User u : list){
			%>
			
				
				<tr>
					<td><a href="<%= request.getContextPath() %>/DisplayUsers/User.jsp?id=<%=++i %>" target="_blank"><%=i %></a></td>
					<td><a href="<%= request.getContextPath() %>/DisplayUsers/User.jsp?id=<%=i %>" target="_blank"><%=u.getName() %></a></td>
					<td><a href="<%= request.getContextPath() %>/DisplayUsers/User.jsp?id=<%=i %>" target="_blank"><%=u.getSurname() %></a></td>
					<td><form action="<%= request.getContextPath() %>/DisplayUsers.jsp" method="post">
							<input type="hidden" value="<%=u.getId() %>" name="userID" />
							<input class="deleteButton" class="kati" type="submit" value="Delete " />
						</form>
					</td>
				</tr>
				
			<% 	} %>						
			
			
		</tbody>
	</table>

</body>
</html>