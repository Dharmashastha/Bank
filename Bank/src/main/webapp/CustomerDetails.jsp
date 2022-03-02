<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
a{
background-color: #4CAF04; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
}
button[type=submit]
{
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 2px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
#CustomerDetails {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#CustomerDetails td, #CustomerDetails th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

#CustomerDetails th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #04AA6D;
  color: white;
}
</style>
<title>CustomerDetails</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<a href="AddCustomer.jsp" style="float: right;">Add Customer</a>
<form action="action" method="post">
<table id="CustomerDetails">
<tr>
	
	<th>CustomerId</th>
	<th>CustomerName</th>
	<th>Date of Birth</th>
	<th>Address</th>
</tr>
<c:forEach items="${cusMap}" var="current">
<tr>
	
       <td><button type="submit" formaction="AddCustomer.jsp" name="id" value="<c:out value="${current.key}" ></c:out>">
<c:out value="${current.key}" ></c:out> </button></td>
       <td><c:out value="${current.value.getCustomerName()}"></c:out></td>
       <td><c:out value="${current.value.getDob()}" ></c:out></td>
       <td><c:out value="${current.value.getAddress()}" ></c:out></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>