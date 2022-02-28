<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
#CustomerDetails {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#CustomerDetails tr, #CustomerDetails th {
  border: 1px solid #ddd;
  padding: 8px;
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
<table id="CustomerDetails">
<tr>
	
	<th>CustomerId</th>
	<th>CustomerName</th>
	<th>Date of Birth</th>
	<th>Address</th>
</tr>
<tr>
	<th>100001</th>
	<th>Dharma</th>
	<th>24/05/2000</th>
	<th>Chennai</th>
</tr>
<tr>
	<th>100002</th>
	<th>Bharath</th>
	<th>14/08/1997</th>
	<th>Tuticorin</th>
</tr>
</table>
</body>
</html>