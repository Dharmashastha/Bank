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
input[type=number]
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
</style>
<title>AddAccount</title>
</head>
<body>
<form action="AddClient" method="post">
<%@include file="Menu.jsp" %>
<fieldset>
<label for="custId">CustomerId</label><br>
<input type="number" id="custId" name="customerId" placeholder="customerId" min="100001" max="200000" required="required"><br>
<!--label for="status">Status</label><br>
<input type="radio" name="yesno" id="status" value="true">Active
<input type="radio" name="yesno" id="status" value="false">InActived-->
<br><input type="submit" value="Register">
<input type="hidden" name="Details" value="account">
</fieldset>
</form>
</body>
</html>