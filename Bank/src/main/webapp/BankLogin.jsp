<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankLoginPage</title>
<link rel="stylesheet" type="text/css" href="BankLogin.css">
</head>
<body background="Login.png">
<div>
<form action="loginservlet" method="post" name="loginpage">
<fieldset>
<img src="profile.png" style="height: 200px; width: 200px;">
<br><br>
<label for="UserID">UserID</label><br>
<input type="text" name="UserId" id="UserID" maxlength=20 placeholder="UserID" required="required"><br>
<label for="password">Password</label><br>
<input type="password" name="Password" id="password" maxlength=10 placeholder="Password" required="required"><br>
<br><input type="submit" name="page" value="Login"><br>
<input type="reset">
</fieldset>
</form>
</div>
</body>
</html>