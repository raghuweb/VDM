<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<%@include file="Master.jsp"%>
	<div align="center">
		<h1>Welcome to vendor Page</h1>
		<form action="insertVen" method="post" name="venForm" onsubmit="return validateVenInput();" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="text" name="venId" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="venName" /></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><input type="text" name="venMail" /></td><td><span id="venMailErr" class="error"></span></td>
				</tr>
				<tr>
					<td>Location</td>
					<td><select name="loc.locId" id="locIdType">
					<option value="-1">--select--</option>
					<c:forEach items="${locListObj}" var="loc">
						<option value="${loc.locId}">${loc.locName}</option>
					</c:forEach>
					</select></td><td><span id="venLocErr" class="error"></span></td>
				</tr>
				<tr>
					<td>Select File</td><td><input type="file" name="fileinputs"> </td>
				</tr>
				<tr>
					<td><input type="submit" value="Insert"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
		${msg}<br /> <a href="viewAllVen">View All Records</a>
	</div>
</body>
</html>




