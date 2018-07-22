<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		<h1>FORMULARIO ALTA RESTAURANTE</h1>
		<form:form method="POST" action="/Ratatoullie/restaurant/restaurantForm" modelAttribute="restaurant">
		    <table>
		    	<tr>
		        	<td><form:label path="name">Name</form:label></td>
		            <td><form:input path="name"/></td>
		        </tr>
		        <tr>
		        	<td><form:label path="category">Category</form:label></td>
		            <td><form:select modelAttribute="restaurant" path="category">
			            	<form:options items="${categories}"></form:options>
			            	<form:option value="NONE">Other (Please Specify)</form:option>
			            	<form:input path="category"/>
		            	</form:select>
		            </td>
		        </tr>
		        <tr>
		        	<td><form:label path="location.latitude">Location Latitude</form:label></td>
		            <td><form:input path="location.latitude"/></td>
		        </tr>
		        <tr>
		        	<td><form:label path="location.longitude">Location Longitude</form:label></td>
		            <td><form:input path="location.longitude"/></td>
		        </tr>
		        <tr>
		        	<td><input type="submit" value="Submit"/></td>
		        </tr>
		    </table>
	    </form:form>
	</center>
<br><a href="/Ratatoullie/">Volver</a><br>
</body>
</html>