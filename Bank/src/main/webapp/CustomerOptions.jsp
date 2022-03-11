<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CustomerOptions.css">
<title>CustomerOptions</title>
</head>
<body>
<%if(session.getAttribute("userId")==null)
{
	RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
	req.forward(request, response);	
} %>
<div>
<form action="customeroptions" method="post">
<input type="submit" value="AccountDetails" name="page">
<input type="submit" value="TransferAmount" name="page">
<input type="submit" value="LogOut" name="page" style="float: right;">
</form>
</div>
</body>
</html>