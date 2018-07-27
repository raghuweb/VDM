<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to User Register Page</h1>
<form action="insertUser" method="post">
<pre>
Enter Id    :<input type="text" name="userId"/>
Enter Name  :<input type="text" name="userName"/>
Enter Email :<input type="text" name="userEmail"/>
Mobile Num  :<input type="text" name="mobileNum"/>
Address     :<textarea rows="2" cols="8" name="addr"></textarea> 
<input type="submit" value="Register"/><input type="reset" value="Clear"/>
</pre>
</form>
${msg}
</body>
</html>