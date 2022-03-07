<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
a{
  background-color: white; 
  border: 2px solid #f44336;
  color: black;
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
a:hover
{
	background-color: #f44336;
	color: white;
}
button[type=submit]
{
  background-color: white;
  border: 2px solid #f44336;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
button[type=submit]:hover
{
	background-color:#f44336;
	color: white; 
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
<form action="showdetails" method="post">
<button type="submit" formaction="deactivated" formmethod="post" style="float: right;">Deactivated Account</button>

<table id="AccountDetails">
<tr>
	<th>Select</th>
	<th>AccountNo</th>
	<th>Balance</th>
	<th>CustomerId</th>
</tr>
<c:forEach items="${accMap}" var="current">
<c:forEach items="${current.value}" var="current1"> 
<tr>
	  
      <td><input type="checkbox"  name="accountNo" value="${current1.key}"/></td>
      <td><c:out value="${current1.key}"></c:out></td>
      <td><c:out value="${current1.value.getBalance()}"></c:out></td>
      <td><c:out value="${current.key}" ></c:out></td>
      
</tr>
</c:forEach>
</c:forEach> 
</table>
</form>
</body>
</html>