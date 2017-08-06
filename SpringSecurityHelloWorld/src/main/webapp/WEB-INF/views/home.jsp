<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>hi welcome to SpringSecurity applicaton<br>this is the home page without any authenticaton and authorization.</h2>
		<h3><a href = "<c:url value = "/user"/> ">user</a></h3><br>
		<h3><a href = "<c:url value= "/user/info" />" >user > info</a></h3><br>
		<h3><a href = "<c:url value = "/admin"/> ">admin</a></h3><br>
		<h3><a href = "<c:url value = "/dba"/> ">dba</a></h3><br>
</body>
</html>