<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.managementmodel.in.UserManagementModel" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "a" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management System</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">USER MANAGEMENT SYSTEM</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath()%>/usermanagementlist">USERS</a>
        </li>
       </ul>
      </div>
     </div>
    </nav>
<h1 style="color:blue" align="center">USER MANAGEMENT SYSTEM</h1>
<hr></hr>
<br><br>
	<div class="container">
		<a href="<%= request.getContextPath()%>/Add" class="btn btn-success">ADD USER</a>
		<br><br>
			<table class="table table-striped">
				<thead>
					<th>ID:</th>
					<th>NAME:</th>
					<th>EMAIL:</th>
					<th>CITY:</th>
					<th>ACTIONS:</th>
				</thead>
				<tbody>
				<a:forEach items="${display}" var="ums">
					<tr>
					<td><a:out value="${ums.id}"></a:out></td>
					<td><a:out value="${ums.name}"></a:out></td>
					<td><a:out value="${ums.email}"></a:out></td>
					<td><a:out value="${ums.city}"></a:out></td>
					<td><a href="Edit?id=<a:out value="${ums.id}"></a:out>">EDIT</a>&nbsp;&nbsp;<a href="Delete?id=<a:out value="${ums.id}"></a:out>">DELETE</a></td>
					</tr>
				</a:forEach>
				</tbody>
			</table>
	</div>
</body>
</html>