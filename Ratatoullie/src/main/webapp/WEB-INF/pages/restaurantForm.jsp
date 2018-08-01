<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#categorySelector').on('change', function() {
		var value = $(this).val();
		if(value == 'other'){
			if($("#theOtherCategory").val()!='1')//to avoid adding the element if it is already there
				$("#otherCategory").append('<td><input id="theOtherCategory1" type="hidden" value="1"></td><td id="theOtherCategory2"><input type="text"/></td>');
				//$("restaurantFormTable").append('<td></td><td><form:input path="categories"/></td>');
			}
		else{
			$("#otherCategory").empty();
		}
	});
});
</script>
</head>
<body>
	<center>
		<h1>FORMULARIO ALTA RESTAURANTE</h1>
		<form:form method="POST" action="/Ratatoullie/restaurant/restaurantForm" modelAttribute="restaurant">
		    <table id="restaurantFormTable">
		    	<tr>
		        	<td><form:label path="name">Name</form:label></td>
		            <td><form:input path="name"/></td>
		        </tr>
		        <!-- <tr>
		        	<td><form:label path="category">Category</form:label></td>
		            <td><form:select modelAttribute="restaurant" path="category" id="categorySelector">
			            	<form:options items="${categories}"></form:options>
			            	<form:option value="other">Other (Please Specify)</form:option>
		            	</form:select>
		            </td>
		        </tr>
		        <tr id="otherCategory"></tr> -->
		        
		        <tr>
		        	<td><form:label path="category">CategoLOCA</form:label></td>
		        	<td>
		        		<form:select modelAttribute="restaurant" path="category" id="categorySelector">
		        			<c:forEeach var="category" items="${categories}">
		        				<form:option value="${category.id}">${category.name}</form:option>
		        			</c:forEeach>
		        			<form:option value="other">Other (Please Specify)</form:option>
		        		</form:select>
		        	</td>
		        </tr>
		        <tr id="otherCategory"></tr>
		        
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
		    
		    <ul>
		    <c:forEach var="category" path="category" items="${categories}">
				<li>${category}</li>
			</c:forEach>
			</ul>
			
	    </form:form>
	</center>
<br><a href="/Ratatoullie/">Volver</a><br>
</body>
</html>