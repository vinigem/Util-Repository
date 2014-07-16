<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body><center>
<form:form method="POST" modelAttribute="login" action="login.do">
<h1 align="center" style="color:#FF7F24;"><u>Login</u></h1>
<br></br>
<table border="3">
<tr>
<th><form:label path="loginID">Login ID</form:label></th><td><form:input path="loginID"/>
<form:errors path="loginID" cssStyle="color:red"/></td>
</tr>
<tr>
<th><form:label path="password">Password</form:label></th><td><form:password path="password"/>
<form:errors path="password" cssStyle="color:red"/></td>
</tr>
<tr><td colspan="2"><input type="submit" value="Login"/></td></tr>
</table>
<p align="center">${Message}</p>
</form:form>
</center>
</body>
</html>