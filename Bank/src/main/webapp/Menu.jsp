<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div
{
	text-align: center;	
}
input[type=submit]{
  background-color: #008CBA; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin :4px 2px;	
  cursor: pointer;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
  background-color: white;
  color: black;
  border: 2px solid #008CBA;
}
input[type=submit]:hover
{
	background-color: #008CBA;
 	color: white;
}
a{
  background-color: #008CBA; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin :4px 2px;	
  cursor: pointer;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
}
</style>
<title>Menu</title>
</head>
<body>
<div>
<form action="showdetails" method="post">
<input type="submit" value="CustomerDetails" name="page">
<input type="submit" value="AccountDetails" name="page">
<input type="submit" value="Deposit/WithDraw" name="page">
<input type="submit" value="TransferAmount" name="page">
<a href="BankLogin.jsp" style="float: right;">LogOut</a>
</form>
</div>
</body>
</html>