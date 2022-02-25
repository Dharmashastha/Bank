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
#AccountDetails {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#AccountDetails tr, #AccountDetails th {
  border: 1px solid #ddd;
  padding: 8px;
}

#AccountDetails th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #04AA6D;
  color: white;
}
</style>
<title>AccountDetails</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<a href="AddAccount.jsp" style="float: right;">Add Account</a>
<a href="" style="float: right;">Deactivated Account</a>
<table id="AccountDetails">
<tr>
	<th>AccountNo</th>
	<th>Balance</th>
	<th>CustomerId</th>
	<th>Status</th>
</tr>
<tr>
	<th>20001</th>
	<th>2000.00</th>
	<th>100001</th>
	<th>Active</th>
</tr>
<tr>
	<th>20002</th>
	<th>5000.00</th>
	<th>100002</th>
	<th>Active</th>
</tr>
</table>
</body>
</html>