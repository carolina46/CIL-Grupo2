<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
<body>
	<center>
		<h1>LISTA DE CATEGORIAS</h1>	
  		<c:if test="${not empty categories}">

		<ul>
			<c:forEach var="name" items="${categories}">
				<li>${name}</li>
			</c:forEach>
		</ul>

	</c:if>
	<a href="/Ratatoullie/">Volver</a>
	</center>
</body>
</html>