<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Employee Details</title>
</head>
<body><center>
<form:form name="form1" action="searchEmp.do" modelAttribute="employee" method="POST">
<h2>Search Employee</h2>
<br><br>
<table border="3">
<tr><th><form:label path="eid">EId:</form:label></th><td><form:input path="eid"/><form:errors path="eid"/></td>
</tr>
<tr><td colspan="2"><input type="submit" value="Search Employees"/></td></tr>
</table>
<c:if test="${Message!=null}">
<h3>${Message}</h3>
</c:if>
<c:if test="${empList!=null}">
<table border="2">
<tr><th>EID</th><th>First Name</th><th>Last Name</th><th>Dept No.</th><th>Salary</th></tr>
<c:forEach var="emp" items="${empList}">
<tr style="color: #FF4040"><td>${emp.eid}</td><td>${emp.fName}</td><td>${emp.lName}</td><td>${emp.deptNo}</td><td>${emp.salary}</td></tr>
</c:forEach>
</table>
</c:if>
</form:form>
</center>
</body>
</html>