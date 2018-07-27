<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<div align="center">
<h2>Welcome to Location Edit Page</h2>
<form action="updateLoc" method="post">
<table>
<tr>
<td>Id</td><td><input type="text" name="locId" value="${locObj.locId}" readonly="readonly"/></td>
</tr>
<tr>
<td>Name</td><td><input type="text" name="locName" value="${locObj.locName}"/></td>
</tr>
<tr>
<td>Type</td>
<c:choose>
<c:when test="${'Urban' eq locObj.locType}">
<td><input type="radio" name="locType" value="Urban" checked="checked">Urban
<input type="radio" name="locType" value="Rural">Rural</td>
</c:when>
<c:otherwise>
<td><input type="radio" name="locType" value="Urban">Urban
<input type="radio" name="locType" value="Rural" checked="checked">Rural</td>
</c:otherwise>
</c:choose>

</tr>
<tr>
<td><input type="submit" value="Update"></td>
</tr>
</table>
</form>
</div>
</body>
</html>




