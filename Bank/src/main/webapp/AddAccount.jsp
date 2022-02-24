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
<title>AddAccount</title>
</head>
<body>
<a href="AdminOptions.jsp" style="float: right;">Home</a>
<label for="AccNo">AccountNo</label><br>
<input type="text" id="AccNo" placeholder="AccountNo"><br>
<label for="balance">Balance</label><br>
<input type="text" id="balance" placeholder="Balance"><br>
<label for="custId">customerId</label><br>
<input type="text" id="custId" placeholder="customerId"><br>
<label for="status">Status</label><br>
<input type="radio" name="yesno" id="status">Active
<input type="radio" name="yesno" id="status">InActived
<br><input type="submit" value="Register">
</body>
</html>