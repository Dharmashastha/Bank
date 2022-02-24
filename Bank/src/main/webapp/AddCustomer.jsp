<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddCustomer</title>
<style>
label {
  background-color: #4CAF04; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
}
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
div
{
	text-align: center;
}
</style>
</head>
<body>
<div>
<a href="AdminOptions.jsp" style="float: right;">Home</a>
<label for="custName">CustomerName</label><br>
<input type="text" id="custName" placeholder="customerName"><br>
<label for="dob">Date of Birth</label><br>
<input type="date" id="dob"><br>
<label for="address">Address</label><br>
<input type="text" id="address"><br>
<input type="submit" value="Register">
</div>
</body>
</html>