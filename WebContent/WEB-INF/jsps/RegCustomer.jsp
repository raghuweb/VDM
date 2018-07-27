<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<h1>welcome to Customer Register Page</h1>
<form action="insertCust" method="post">
<pre>
Id : <input type="text" name="custId"/>
Name : <input type="text" name="custName"/>
Email : <input type="text" name="custEmail"/>
Select Type : <select name="custType">
	<option value="-1">--select--</option>
	<option value="Seller">Seller</option>
	<option value="Consumer">Consumer</option>
</select>
Address : <textarea rows="2" cols="10" name="custAddr"></textarea>
<input type="submit" value="Register"/><input type="reset" value="Clear"/>
</pre>
</form>
${msg}
</body>
</html>