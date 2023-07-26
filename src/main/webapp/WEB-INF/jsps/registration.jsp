<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">

<nav class="navbar navbar-expand-sm bg-light">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="login">LOGIN</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 2</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link 3</a>
    </li>
  </ul>
</nav>



  <h2>Registration form</h2>
  <form:form modelAttribute="employeeDTO" action="register" method="post">
   
   
    <div class="form-group">
      <label>employeeName:</label>
      <form:input path="employeeName" type="text" class="form-control"  />
    </div>
     <div class="form-group">
      <label >salary:</label>
     <form:input path="salary" type="number" class="form-control" />
    </div>
     <div class="form-group">
      <label>emailId:</label>
      <form:input path="emailId" type="text" class="form-control" />
      <form:errors path="emailId" cssClass="text-danger"/>
    </div>
     <div class="form-group">
      <label >Password:</label>
      <form:input path="password" type="password" class="form-control"/>
    </div>
   
    <button type="submit" class="btn btn-primary">Register</button>
  </form:form>
</div>





</body>
</html>