<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body><center>
<h2>Delete Employee Details</h2>
<br><br>
<table border="3">
<tr><th>EID</th><th>First Name</th><th>Last Name</th><th>Dept No.</th><th>Salary</th><th></th></tr>
<c:if test="${empList!=null}">
<c:forEach var="emp" items="${empList}">
<tr style="color: #000000;font-weight: bold"><td>${emp.eid}</td><td>${emp.fName}</td><td>${emp.lName}</td><td>${emp.deptNo}</td><td>${emp.salary}</td>
<td><input type="button" value="Delete" onclick="location.href='delEmp.do?eid=${emp.eid}'"/></td></tr>
</c:forEach>
</c:if>
</table>
<c:if test="${Message!=null}">
<h4>${Message}</h4>
</c:if>
</center>
</body>
</html>