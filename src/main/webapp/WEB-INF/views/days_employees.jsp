<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

    ${employee.name}<br>

    <c:forEach items = "${days_employees}" var = "de">
        ${de.date}<br>
    </c:forEach>

    ${totalDays}

</body>
</head>