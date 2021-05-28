<%@page import="java.util.List"%>
<%@page import="com.student.demo.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>



<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<style type="text/css">

	body {
		padding: 25px;
	}
</style>

</head>
<body>

 <%
	//User user = (User) session.getAttribute("user");


	//List<User> userList = (List<User>) request.getAttribute("userList");

%>

<%-- <%
	if(user != null){
%>  --%>

<h1>Welcome ${ sessionScope.user.name } (${ sessionScope.user.phoneNo })     <a href="logout">Logout</a>  </h1>


<div class="panel panel-primary">
  <div class="panel-heading">User Entry</div>
  <div class="panel-body">
  
  	<form action="processUser" method="post">
  		
  		<input type="hidden" id="id" name="id" value="${requestScope.userData.id}"/>
  	
	  <div class="form-group">
	    <label for="name">Name:</label>
	    <input type="text" name="name" class="form-control" id="name" value="${requestScope.userData.name}">
	  </div>
	 <div class="form-group">
	    <label for="phoneNo">Phone No:</label>
	    <input type="text" name="phoneNo" class="form-control" id="PhoneNo" value="${requestScope.userData.phoneNo}">
	  </div>
	  <div class="form-group">
	    <label for="dob">DOB:</label>
	    <input type="text" name="dob" class="form-control" id="dob" value='<f:formatDate value="${requestScope.userData.dob}" pattern="MM/dd/yyyy"/>'>
	  </div>
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <input type="text" name="username" class="form-control" id="username" value="${requestScope.userData.username}">
	  </div>
	  <div class="form-group">
	    <label for="password">Pasword:</label>
	    <input type="text" name="password" class="form-control" id="password" value="${requestScope.userData.password}">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
  
  
  </div>
 </div>




<div class="panel panel-primary">
  <div class="panel-heading">User List</div>
  <div class="panel-body">
  	
  	
  	<table class="table">
  		<thead>
  			<tr>
  					<th>Name</th>
					<th>Phone No</th>
					<th>Dob</th>
					<th>Username</th>
					<th>Action</th>
  				
  			</tr>
  		</thead>
  		
  		<tbody>
  		
  			<%--  <%
  			
  				List<User> userList = request.getAttribute("userList");
  			
  				for(User obj : userList){
  			%>  --%>
  			<c:forEach items="${requestScope.userList}" var="row">
	  			<tr>
	  				<td>${row.name }</td>
	  				<td>${row.phoneNo }</td>
	  				<td> <f:formatDate value="${row.dob }" pattern="MM/dd/yyyy"/>  </td>
	  				<td>${row.username }</td>
	  				<td><a href="editUser?id=${row.id}">Edit</a> / <a href="deleteUser?id=${row.id}">Delete</a> </td>
	  			</tr>
	  		</c:forEach>
  			<%-- <%
  				}
  			%> --%>
  		</tbody>
  		
  	</table>
  	
  	
  
  </div>
</div>








</body>
</html>