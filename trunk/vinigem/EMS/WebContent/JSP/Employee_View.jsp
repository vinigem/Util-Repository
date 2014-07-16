<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee Details</title>
</head>
<body ><center>
<form:form name="form1" action="getEmployee.do" modelAttribute="employee" method="POST">
<h2>Update Employee Details</h2>
<br><br>
<table border="3">
<tr><th><form:label path="eid">EId:</form:label></th><td><form:input path="eid"/><form:errors path="eid"/></td>
</tr>
<tr><td colspan="2"><input type="submit" value="Get Employee"/></td></tr>
</table>
</form:form>
<form:form name="form2" modelAttribute="employee" method="POST">
<table border="2">
<tr>
<th><form:label path="eid">EId:</form:label></th><td><form:input path="eid" readonly="true"/></td>
</tr>
<tr>
<th><form:label path="fName">First Name:</form:label></th><td><form:input path="fName" readonly="true"/></td>
</tr>
<tr><th><form:label path="lName">Last Name:</form:label></th><td><form:input path="lName" readonly="true"/></td>
</tr>
<tr>
<th><form:label path="deptNo">Dept No:</form:label></th><td><form:input path="deptNo" readonly="true"/></td>
</tr>
<tr>
<th><form:label path="salary">Salary</form:label></th><td><form:input path="salary" readonly="true"/></td>
</tr>
</table>
<h3>${Message}</h3>
</form:form>
</center>
</body>
</html>