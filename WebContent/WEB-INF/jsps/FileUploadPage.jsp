<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<%@include file="Master.jsp"%>
	<h1>Upload File here...</h1>
	<form action="insertFile" method="post" enctype="multipart/form-data">
		<pre>
Id:<input type="text" name="fid" />
File:<input type="file" name="fileObjss" />
<input type="submit" value="Insert" />
</pre>
	</form>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name(click on file name to download)</th>
		</tr>
		<c:forEach items="${fileListData}" var="fObj">
			<tr>
				<td><c:out value="${fObj[0]}" /></td>
				<td><a href='fileDownload?id=<c:out value="${fObj[0]}"/>'><c:out
							value="${fObj[1]}" /></a></td>
			</tr>
		</c:forEach>
	</table>







</body>
</html>





