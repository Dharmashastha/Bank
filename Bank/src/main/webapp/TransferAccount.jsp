<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div{
text-align: center;
}
a{

  background-color: white; 
  border: 2px solid #008CBA;
  color: black;
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
a:hover
{
	background-color: #008CBA;
	color: white;
}
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
background-color: white;
box-sizing: border-box;
font-size:20px;
border: 2px solid #008CBA;
padding:15px 32px;
margin-top: 5px;
display: inline-block;	
color: black;
}
input[type=submit]:hover
{
	background-color: #008CBA;
	color : white;
}
fieldset
{	
	text-align: center;
	margin-left:750px;
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
<script>
function onTransaction() {
	   <% String transferAmount=(String)request.getAttribute("transferAmount");%>
	var msg="<%=transferAmount%>";
		if(msg != 'null'){
			alert(msg);  
		}
}
</script>
<title>TransferAmount</title>
</head>
<body onpageshow="onTransaction()">
<%if(session.getAttribute("userId")==null)
{
	RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
	req.forward(request, response);	
} %>
<%@include file="CustomerOptions.jsp" %>
<form action="transferamount" method="post">
<div>
<fieldset>
<label for="account">From AccountNo</label><br>
<select id="account" name="fromAccNo" style="width: 100px;">
<c:forEach items="${accountMap}" var="current">
<c:if test="${current.value.isStatus()}">
<option value="<c:out value="${current.key}" />"><c:out value="${current.key}" /></option>
</c:if>
</c:forEach>
</select>
<%long id= (long)session.getAttribute("customerId");%>

<label for="account">To AccountNo</label><br>
<select id="account" name="toAccNo" style="width: 100px;">
<c:forEach items="${accMap}" var="current">
<c:forEach items="${current.value}" var="current1">
<c:if test="${current1.value.isStatus() && current.key != id}">
<option value="<c:out value="${current1.key}" />"><c:out value="${current1.key}" /></option>
</c:if>
</c:forEach>
</c:forEach>
</select>
<label for="Amount">Transfer Amount</label><br>
<input type="number" id="Amount" placeholder="Amount" min="100" max="100000" required name="Amount"><br>
<br><input type="submit" name="page" value="Submit">
</fieldset>
</div>
</form>
</body>
</html>