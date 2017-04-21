<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
div {
	text-align: center;
	background-color: lavender;
	color: navy;
}
table{
text-align: center;
border-spacing: 2px;
}
</style>
<title>Jms Reciver</title>
</head>
<body>
	<div>
		<h1>The below data fetch from Other Application using JMS
			communication.</h1>
	</div>
	<table align="center">
		<tr>
			<th>Name</th>
			<th>Location</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${persons}" var="persons">
			<tr>
				<td>${persons.name}</td>
				<td>${persons.location}</td>
				<td>${persons.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>