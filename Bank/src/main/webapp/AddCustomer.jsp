<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddCustomer</title>
<style>
label {
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
input[type=date],input[type=text]
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
background-color: #f44336;
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
div
{
	text-align: center;
}

</style>
<script type="text/javascript">
/* function onTrim() {
	var a=document.getElementById("custName").value;
	a=a.trim();
		document.getElementById("custName").value=a;
	
} */

</script>
</head>
<body>
<div>
<%@include file="Menu.jsp" %>
<fieldset>
<form action="addclient" method="post">
<label for="custName">CustomerName</label><br>
<%String name=request.getParameter("name");
  String dob=request.getParameter("dob");
  String address=request.getParameter("address"); %>
<input type="text" id="custName" name="custName" placeholder="customerName" required="required" value="<%if(name != null){out.print(name);}%>"><br>
<label for="dob">Date of Birth</label><br>
<input type="date" id="dob" name="dob" required="required" value="<%if(dob != null){out.print(dob);}%>"><br>
<label for="address">Address</label><br>
<input type="text" id="address" name="address" required="required" value="<%if(address != null){out.print(address);}%>"><br><br>
<input type="submit" value="Register">
<input type="hidden" name="id" value="<% String s=request.getParameter("id");%><% out.print(s);%>">
<input type="hidden" name="Details" value="customer">
</form>
</fieldset>
</div>
</body>
</html>