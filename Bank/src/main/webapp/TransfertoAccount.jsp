<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>           
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
label{
  background-color: #f44336; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  text-decoration: none;
  font-family: sans-serif;
  font-style: italic;
}
input[type=text]
{
width:95%;
padding:10px;
border:0;
box-shadow:0 0 15px 4px rgba(0,0,0,0.06);	
font-style: italic;
}
input[type=submit]
{
cursor:pointer;
font-style: italic;
box-sizing: content-box;
background-color: #008CBA;
box-sizing: border-box;
font-size:20px;
border: infobackground;
padding:15px 32px;
margin-top: 5px;
display: inline-block;	
color: white;
}
fieldset
{	
	text-align: center;
	margin-left:800px;
	width:200px;
	height:150px;
	border:none;
}
input[type=number]
{
width:95%;
padding:10px;
border:0;
box-shadow:0 0 15px 4px rgba(0,0,0,0.06);	
font-style: italic;
}
</style>
<title>TransferAmount</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<fieldset>
<form action="transferamount" method="post">
<label for="account">From AccountNo</label><br>
<select id="account" name="fromacc" style="width: 100px;">
<c:forEach items="${accMap}" var="current">
<c:forEach items="${current.value}" var="current1">
<c:if test="${current1.value.isStatus()}">
<option value="<c:out value="${current1.key}" />"><c:out value="${current1.key}" /></option>
</c:if>
</c:forEach>
</c:forEach>
</select>
<label for="account">To AccountNo</label><br>
<select id="account" name="toacc" style="width: 100px;">
<c:forEach items="${accMap}" var="current">
<c:forEach items="${current.value}" var="current1">
<c:if test="${current1.value.isStatus()}">
<option value="<c:out value="${current1.key}" />"><c:out value="${current1.key}" /></option>
</c:if>
</c:forEach>
</c:forEach>
</select>
<label for="Amount">Transfer Amount</label><br>
<input type="number" id="Amount" placeholder="Amount" min="100" max="100000" required name="amount"><br>
<br><input type="submit" name="page" value="submit">
</form>
</fieldset>
</body>
</html>