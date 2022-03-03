<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div{
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
  margin: 4px 2px;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
  font-style: italic;
}
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
input[type=number]
{
width:95%;
padding:10px;
border:0;
box-shadow:0 0 15px 4px rgba(0,0,0,0.06);	
font-style: italic;
}
</style>
<title>TransferAccount</title>
</head>
<body>
<div>
<a href="TransferAccount.jsp">Transfer to Account</a><br>
</div>
<fieldset>
<label for="account">From AccountNo</label><br>
<input type="text" id="account" placeholder="AccountNo" required><br>
<label for="customer">To CustomerId</label><br>
<input type="text" id="customer" placeholder="customerid" required><br>
<label for="account">To AccountNo</label><br>
<input type="text" id="account" placeholder="AccountNo" required><br>
<label for="Amount">Transfer Amount</label><br>
<input type="number" id="Amount" placeholder="Amount" min="100" maxlength="100000" required><br>
<input type="submit">
</fieldset>
</body>
</html>