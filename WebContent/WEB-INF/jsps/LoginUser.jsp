<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Enter Details to Login...</h1>
<form action="login" method="post">
<pre>
UserName : <input type="text" name="un"/>
Password : <input type="password" name="pwd"/>
<input type="submit" value="Login"/><input type="reset" value="Clear"/>
</pre>
</form>
${msg}
</body>
</html>