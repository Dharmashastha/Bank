<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CustomerAccountDetails</title>
<style>
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
</head>
<body>
<%@include file="CustomerOptions.jsp" %>
<form action="customeroptions" method="post">
<table id="AccountDetails">
<tr>
	<th>AccountNo</th>
	<th>Balance</th>
	<th>CustomerId</th>
</tr>
<c:forEach items="${accountMap}" var="current"> 
<tr>
      <td><c:out value="${current.key}"></c:out></td>
      <td><c:out value="${current.value.getBalance()}"></c:out></td>
      <td><c:out value="${current.value.getCustomerId()}"></c:out></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>