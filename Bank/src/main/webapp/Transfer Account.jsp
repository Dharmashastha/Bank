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
  cursor: pointer;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
}
</style>
<title>Transfer Account</title>
</head>
<body>
<div>
<a href="Transfer Account.jsp">Transfer to Account</a><br>
</div>
<label for="account">From AccountNo</label><br>
<input type="text" id="account" placeholder="AccountNo"><br>
<label for="account">To AccountNo</label><br>
<input type="text" id="account" placeholder="AccountNo"><br>
<label for="Amount">Transfer Amount</label><br>
<input type="text" id="Amount" placeholder="Amount"><br>
<input type="submit">
</body>
</html>