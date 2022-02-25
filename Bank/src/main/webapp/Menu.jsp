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
a{
  background-color: #4CAF04; 
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
<a href="CustomerDetails.jsp">CustomerDetails</a>
<a href="AccountDetails.jsp" >AccountDetails</a>
<a href="Amount.jsp">Deposit</a>
<a href="Amount.jsp">Withdraw</a>
<a href="Transfer to Account.jsp">Transfer to Account</a>
<a href="BankLogin.jsp" style="float: right;">LogOut</a>
</div>
</body>
</html>