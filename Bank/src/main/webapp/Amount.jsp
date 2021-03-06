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
input[type=radio]
{	
font-style: italic;
}
input[type=number]
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
</style>
<script>
function onAmount() {
	   <%-- <% String deposit=(String)request.getAttribute("Deposit");%>
	var msg="<%=deposit%>";
		if(msg != 'null'){
			alert(msg);  
		}
		
		<% String withdraw=(String)request.getAttribute("Withdraw");%>
		var check="<%=withdraw%>";
			if(check != 'null'){
				alert(check);  
			} --%>
	}
</script>
<title>Amount</title>
</head>
<body>
<%if(session.getAttribute("userId")==null)
{
	RequestDispatcher req=request.getRequestDispatcher("BankLogin.jsp");
	req.forward(request, response);	
} %>
<%@include file="Menu.jsp" %>
<fieldset>
<form action="amount" method="post">
<label for="AccountNo">AccountNo</label><br>
<select id="account" name="accNo" style="width: 100px;">
<c:forEach items="${accMap}" var="current">
<c:forEach items="${current.value}" var="current1">
<c:if test="${current1.value.isStatus()}">
<option value="<c:out value="${current1.key}" />"><c:out value="${current1.key}" /></option>
</c:if>
</c:forEach>
</c:forEach>
</select>
<label for="amount">Deposit/Withdraw</label><br>
<input type="radio" name="yesno" id="amount" value="true" required><i>Deposit</i>
<input type="radio" name="yesno" id="amount" value="false" required><i>Withdraw</i><br>
<label for="amount">Amount</label><br>
<input type="number" id="amount" placeholder="Amount" name="amount" min="100" max="100000" required><br>
<br><input type="submit">
<% String deposit=(String)request.getAttribute("Deposit");
   if(deposit != null)
   {
	   out.print("<label style=text-align: center;>"+deposit+"</label>");
   }%>
<% String withdraw=(String)request.getAttribute("Withdraw");
   if(withdraw != null)
   {
	   out.print("<label style=text-align: center;>"+withdraw+"</label>");
   }%>    
</form>
</fieldset>
</body>
</html>