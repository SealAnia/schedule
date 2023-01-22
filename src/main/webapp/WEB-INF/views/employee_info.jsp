<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SCHEDULE</title>
</head>
<body>

	WORKING DAYS FOR ${employee.name.toUpperCase()}<br>
	
	<c:forEach items = "${days}" var = "day">
	    <fmt:formatDate type = "date" value = "${day.date}"/>
		<br>
	</c:forEach>

</body>
</html>