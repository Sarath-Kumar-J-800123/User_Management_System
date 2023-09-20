<%@page import="com.managementmodel.in.UserManagementModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER MANAGEMENT SYSTEM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body style="background-color:cyan">
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
   <c:if test="${usermanagementlist==null}">
   		<form action="Insert" method="post">
   </c:if>
   <c:if test="${usermanagementlist!=null}">
   		<form action="Update" method="post">
   </c:if>
   
   <h2 align="center">
   <c:if test="${usermanagementlist==null}">
   		ADD USER
   </c:if>
   <c:if test="${usermanagementlist!=null}">
   		EDIT USER
   </c:if>
   </h2>
   <div class="mb-3 container" align="center">
   <input type="hidden" class="form-control" id="exampleFormControlInput5" value="${usermanagementlist.id}" placeholder="Enter Your Id" name="id" style="width:300px">
   </div>
   <div class="mb-3 container" align="center">
    <label for="exampleFormControlInput1" class="form-label" style="color:blue">Full_Name:</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" value="${usermanagementlist.name}" placeholder="Enter Your Name" name="name" style="width:300px">
   </div>
<div class="mb-3 container" align="center">
  <label for="exampleFormControlInput2" class="form-label" style="color:blue">Email_Id:</label>
  <input type="email" class="form-control" id="exampleFormControlInput2" value="${usermanagementlist.email}" placeholder="Enter Your Email_Id" name="email" style="width:300px">
</div>
<div class="mb-3 container" align="center">
  <label for="exampleFormControlInput3" class="form-label" style="color:blue">City_Name:</label>
  <input type="text" class="form-control" id="exampleFormControlInput3" value="${usermanagementlist.city}" placeholder="Enter Your City" name="city" style="width:300px">
</div>
<div class="mb-3 container" align="center">
  <input type="submit" class="btn btn-success" value="Save" style="width:150px">
</div>
</form>
</body>
</html>