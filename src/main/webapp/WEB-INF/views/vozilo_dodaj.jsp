<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	
	<div class="container">
		<div class="row">
		
			<form action="<spring:url value="/vozilo/dodaj"/>" method="post" class="col-md-8 col-md-offset-2">
			
				<div class="form-group">
					<input type="text" id="preduzece-id" 
							class="form-control" name="preduzeceId" value="${predId}"/>
				</div>
			
				<div class="form-group">
					<label for="vozilo-tip">Marka</label>
					<input type="text" id="vozilo-tip" 
							class="form-control" name="marka" value=""/>
				</div>
				
				<div class="form-group">
					<label for="model">Model</label>
					<input type="text" id="model" 
							class="form-control" name="model" value=""/>
				</div>

				<div class="form-group">
					<label for="godiste">Godiste</label>
					<input type="text" id="godiste" 
							class="form-control" name="godiste" value=""/>
				</div>
				<div class="form-group">
					<label for="project_type">Emisiona Klasa</label>
					<select name="emisionaKlasa" class="selectpicker">
							<option value="EURO 1">EURO 1</option>
							<option value="EURO 2">EURO 2</option>
							<option value="EURO 3">EURO 3</option>
							<option value="EURO 4">EURO 4</option>
							<option value="EURO 5">EURO 5</option>
							<option value="EURO 6">EURO 6</option>
					</select>
				</div>
				
				<div class="form-group">
					<label for="project_type">Energent</label>
					<select name="energetici" class="selectpicker">
							
						<c:forEach items="${energenti}" var="energent">
							
							<option value="${energent.energentId}">${energent.naziv}</option>
							
						</c:forEach> 
					</select>
				</div>
<!--  				
				<div class="form-group">
					<label for="emisiona-klasa">Emisiona Klasa</label>
					<input type="text" id="emisiona-klasa" 
							class="form-control" name="emisionaKlasa" value=""/>
				</div>
-->				
				<div class="form-group">
					<label for="kubikaza">Kubikaza</label>
					<input type="text" id="kubikaza" 
							class="form-control" name="kubikaza" value=""/>
				</div>
 
						
				<button type="submit" class="btn btn-default" name= "sacuvaj">Sacuvaj</button>
				<button type="submit" class="btn btn-default" name= "odustani">Odustani</button>
				
	
			</form>
			
		</div>
	</div>
</body>
</html>