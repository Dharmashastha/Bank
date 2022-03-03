<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
button[type=submit]
{
  background-color: #4CAF04;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
#AccountDetails {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#AccountDetails td, #AccountDetails th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}

#AccountDetails th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #04AA6D;
  color: white;
}
</style>
<title>AccountDetails</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<a href="AddAccount.jsp" style="float: right;">Add Account</a>
<button type="submit" style="float: right;">Deactivated Account</button>
<form action="showdetails" method="post">
<table id="AccountDetails">
<tr>
	<th>Select</th>
	<th>AccountNo</th>
	<th>Balance</th>
	<th>CustomerId</th>
	<th>Status</th>
</tr>
<c:forEach items="${accMap}" var="current">
<c:forEach items="${current.value}" var="current1"> 
<tr>
      <td><input type="checkbox" name="accountNo" value="<c:out value="${current1.key}"></c:out>"/></td>
      <td><c:out value="${current1.key}"></c:out></td>
      <td><c:out value="${current1.value.getBalance()}"></c:out></td>
      <td><c:out value="${current.key}" ></c:out></td>
      <td><c:out value="${current1.value.isStatus()}" ></c:out></td>      
</tr>
</c:forEach>
</c:forEach> 
</table>
</form>
</body>
</html>