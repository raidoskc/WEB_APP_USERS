<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register new user</title>
<link href="./CSS/RegisterUser.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="<%= request.getContextPath() %>/RegisterUser.jsp" method="post">
<ul class="form-style-1">
    <li><label>Your Name <span class="required">*</span></label>
    	<input type="text" name="name" required class="field-long" placeholder="Name" /></li>
    <li>
        <label>Surname <span class="required">*</span></label>
        <input type="text" name="surname" required class="field-long" placeholder="Surnmae"/>
    </li>
    <li>
        <label>Gender <span class="required">*</span></label>
        <select name="gender" required class="field-select">
        <option value="" selected>--Select Gender--</option>
        <option value="M" >Male</option>
        <option value="F">Female</option>
        </select>
    </li>
    <li>
        <label>Birthday <span class="required">*</span></label>
        <input type="date" name="birthday" required class="field-long">
    </li>
    
    <li>
        <label>Work Address</label>
        <input type="text" name="workaddress" class="field-long" placeholder="Work Address"/>
    </li>
    <li>
        <label>Home Address</label>
        <input type="text" name="homeaddress" class="field-long" placeholder="Home Address"/>
    </li>
    
    
    <li>
        <input type="submit" value="register" />
    </li>
</ul>
</form>

</body>
</html>