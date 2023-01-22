<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>SET WORKING HOURS FOR EMPLOYEE ${employee.name.toUpperCase()}</title>

</head>
<body>

	<c:url value="/employees/by_id/${employee.employeeId}" var="employee"/>
	
	<spring_form:form action="${employee}" 
	modelAttribute = "newEmployee">
	
	<spring_form:hidden path="employeeId" value = "${newEmployee.employeeId}"/>
	
    <label for = "dayId">DATE</label>
    <datalist id = "daysList">
    	<c:forEach items = "${days}" var = "day">
    		<option value = "${day.dayId}"> - ${day.date}
    	</c:forEach>
    </datalist>
    <input type = "number" id = "dayId" name = "dayId" list = "daysList"><br>
    
    <input type="submit" value="Submit">
    
	</spring_form:form>

</body>
</html>