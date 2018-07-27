<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Insert title here</title>


</head>
<body>
	<%@include file="Master.jsp"%>
	<div align="left">
		<h2>Welcome to Location Register</h2>
		<a href="locExcelExport">Export to Excel</a><br /> <a
			href="locPdfExport">Export to PDF</a>
		<form action="insertLoc" method="post" name="locForm"
			onsubmit="return validateLocInput();">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="text" name="locId" /></td>
					<td><span id="locIdErr" class="error"></span></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="locName" /></td>
					<td><span id="locNameErr" class="error"></span></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><input type="radio" name="locType" value="Urban">Urban<input
						type="radio" name="locType" value="Rural">Rural</td>
					<td><span id="locTypeErr" class="error"></span>
				</tr>
				<tr>
					<td><input type="submit" value="Insert"></td>
					<td><input type="reset" value="Clear"></td>
				</tr>
			</table>
		</form>
		${msg}<br /> <a href="viewAllLoc">View All Records</a>
	</div>
</body>
</html>




