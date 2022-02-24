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
<title>Amount</title>
</head>
<body>
<a href="AdminOptions.jsp" style="float: right;">Home</a>
<label for="custId">CustomerId</label><br>
<input type="text" id="custId" placeholder="customerId"><br>
<label for="AccountNo">AccountNo</label><br>
<input type="text" id="AccountNo" placeholder="AccountNo"><br>
<label for="amount">Deposit/Withdraw</label><br>
<input type="radio" name="yesno" id="amount">Deposit
<input type="radio" name="yesno" id="amount">Withdraw<br>
<label for="amount">Amount</label><br>
<input type="text" id="amount" placeholder="Amount"><br>
<input type="submit">
</body>
</html>