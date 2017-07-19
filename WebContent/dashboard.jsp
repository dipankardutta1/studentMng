<%@page import="java.util.List"%>
<%@page import="com.student.demo.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  
  
  <script type="text/javascript">
  
  	$(document).ready(function(){
  		 $( "#dob" ).datepicker(
  				{ dateFormat: 'dd/mm/yy' }		 
  		 );
	});
  
  
  
  </script>
  
  
  
  

<style type="text/css">

	body {
		padding: 25px;
	}

</style>

</head>
<body>


<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Student Entry</h3>
  </div>
  <div class="panel-body">


	<form action="processUser.do" method="post">
		
		<input type="hidden" id="id" name="id" value="${requestScope.user.id}"/> 
	
	
	  <div class="form-group">
	    <label for="name">Name</label>
	    <input type="text" class="form-control" name="name" id="name" placeholder="Name" value="${requestScope.user.name}">
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone No</label>
	    <input type="text" class="form-control" name="phoneNo" id="phoneNo" placeholder="Phone No" value="${requestScope.user.phoneNo}">
	  </div>
	   <div class="form-group">
	    <label for="dob">DOB</label>
	    <input type="text" class="form-control" name="dob" id="dob" placeholder="DOB" value="<fmt:formatDate value="${requestScope.user.dob}" pattern="dd/MM/yyyy"/>" readonly="readonly">
	  </div>
	  <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" name="username" id="username" placeholder="Username" value="${requestScope.user.username}">
	  </div>
	   <div class="form-group">
	    <label for="password">Password</label>
	    <input type="text" class="form-control" name="password" id="password" placeholder="Password" value="${requestScope.user.password}">
	  </div>

	  <button type="submit" class="btn btn-default">Submit</button>
	</form>




	
  </div>
  
</div>




<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Student List</h3>
  </div>
  <div class="panel-body">
  
  	<table class="table">
  		<thead>
  			<tr>
  				<th>ID</th>
  				<th>Name</th>
  				<th>Phone No</th>
  				<th>DOB</th>
  				<th>Edit</th>
  				<th>Delete</th>
  			</tr>
  		</thead>
  		
  		<tbody>
  			<%-- <%
  				List<User> userList = (List<User>) request.getAttribute("userList");
  				
  				
  				for(User user : userList){
  					
  				
  			%>
  				<tr>
  					<td> <%=user.getId() %> </td>
  					<td> <%=user.getName() %> </td>
  					<td> <%=user.getPhoneNo() %> </td>
  					<td> <%=user.getDob() %> </td>
  				</tr>
  		
  			<%
  				}
  			%> --%>
  			
  			<c:forEach items="${requestScope.userList}" var="row">
  				
  				<tr>
  					<td> ${row.id}  </td>
  					<td> ${row.name} </td>
  					<td> ${row.phoneNo} </td>
  					<td> <fmt:formatDate value="${row.dob}" pattern="MM/dd/yyyy"/>  </td> 
  					<td> <a href="edit.do?id=${row.id}">Edit</a>  </td>
  					<td> <a href="delete.do?id=${row.id}">Delete</a> </td>
  				</tr>
  			
  			</c:forEach>
  		
  		
  		
  			
  		</tbody>
  		
  		
  	</table>
  
  
  
    
  </div>
</div>





</body>
</html>