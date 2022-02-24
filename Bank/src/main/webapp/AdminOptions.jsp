<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="AdminOptions.css">
<style>
#CustomerDetails {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#CustomerDetails tr, #CustomerDetails th {
  border: 1px solid #ddd;
  padding: 8px;
}

#CustomerDetails th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #04AA6D;
  color: white;
}
</style>
<title>AdminOptions</title>
</head>
<body>
<div>
<a href="AddCustomer.jsp">Customer</a>
<a href="AddAccount.jsp" >Account</a>
<a href="Amount.jsp">Deposit</a>
<a href="Amount.jsp">Withdraw</a>
<a href="Transfer to Account.jsp">Transfer to Account</a>
<a href="BankLogin.jsp" style="float: right;">LogOut</a>

</div>
<table id="CustomerDetails">
<tr>
	<th>CustomerId</th>
	<th>CustomerName</th>
	<th>Date of Birth</th>
	<th>Address</th>
</tr>
<tr>
	<th>100001</th>
	<th>Dharma</th>
	<th>24/05/2000</th>
	<th>Chennai</th>
</tr>
<tr>
	<th>100002</th>
	<th>Bharath</th>
	<th>14/08/1997</th>
	<th>Tuticorin</th>
</tr>
</table>
</body>
</html>