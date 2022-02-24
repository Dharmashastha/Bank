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
</style>
<title>Transfer Account</title>
</head>
<body>
<a href="CustomerOptions.jsp" style="float: right;">Home</a>
<label for="account">From AccountNo</label><br>
<input type="text" id="account" placeholder="AccountNo"><br>
<label for="account">To AccountNo</label><br>
<input type="text" id="account" placeholder="AccountNo"><br>
<label for="Amount">Transfer Amount</label><br>
<input type="text" id="Amount" placeholder="Amount"><br>
<input type="submit">
</body>
</html>