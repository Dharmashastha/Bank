<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
label{
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
  font-style: italic;
}
input[type=text]
{
width:95%;
padding:10px;
border:0;
box-shadow:0 0 15px 4px rgba(0,0,0,0.06);	
font-style: italic;
}
input[type=radio]
{	
font-style: italic;
}
input[type=submit]
{
cursor:pointer;
font-style: italic;
box-sizing: content-box;
background-color: #4CAF04;
box-sizing: border-box;
font-size:20px;
border: infobackground;
padding:15px 32px;
margin-top: 5px;
display: inline-block;	
color: white;
}
fieldset
{	
	text-align: center;
	margin-left:800px;
	width:200px;
	height:150px;
	border:none;
}
</style>
<title>Amount</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<fieldset>
<label for="custId">CustomerId</label><br>
<input type="text" id="custId" placeholder="customerId" name="custId"><br>
<label for="AccountNo">AccountNo</label><br>
<input type="text" id="AccountNo" placeholder="AccountNo" name="accNo"><br>
<label for="amount">Deposit/Withdraw</label><br>
<input type="radio" name="yesno" id="amount"><i>Deposit</i>
<input type="radio" name="yesno" id="amount"><i>Withdraw</i><br>
<label for="amount">Amount</label><br>
<input type="text" id="amount" placeholder="Amount" name="amount"><br>
<input type="submit">
</fieldset>
</body>
</html>