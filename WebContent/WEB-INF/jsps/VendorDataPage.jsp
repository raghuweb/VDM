<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
table tr th {
	color: white;
	background-color: black;
}
</style>
</head>
<body>
	<%@include file="Master.jsp"%>
	<div align="center">
		<h1>Welcome to data page</h1>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Location Name</th>
				<th>Location Type</th>
			</tr>
			<c:forEach items="${venListObj}" var="ven">
				<tr>
					<td><c:out value="${ven.venId}" /></td>
					<td><c:out value="${ven.venName}" /></td>
					<td><c:out value="${ven.venMail}" /></td>
					<td><c:out value="${ven.loc.locName}" /></td>
					<td><c:out value="${ven.loc.locType}" /></td>


					<td><a href='deleteVen?id=<c:out value="${ven.venId}"/>'>Delete</a></td>
					<td><a href='editVen?id=<c:out value="${ven.venId}"/>'>Edit</a></td>






				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>