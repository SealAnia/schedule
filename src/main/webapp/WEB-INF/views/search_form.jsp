<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEARCHFORM</title>
</head>
<body>

	<form action = "days/days_in_month/" method = "get">
			<p><input type="text" name = "date" placeholder = "input date">
    		<input type="number" name = "employeeId" placeholder = "input employee id">
            <input type="submit" value="SEARCH">
            </p>
		</form>

</body>
</head>