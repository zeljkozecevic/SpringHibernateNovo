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
		
			<form action="<spring:url value="/preduzece/azuriranje"/>" method="post" class="col-md-8 col-md-offset-2">
			
				<div class="form-group">
					<input type="hidden" id="preduzece-id" 
							class="form-control" name="preduzeceId" value="${preduzece.preduzeceId}"/>
				</div>
				<h2>Preduzece ${preduzece.naziv}</h2>			
				<button type="submit" class="btn btn-default" name="dodaj_vozilo">Dodaj Vozilo</button>
				<button type="submit" class="btn btn-default" name="prikazi_vozila" >Prikazi Vozila</button>				
				
				<div class="form-group">
					<label for="preduzece-ime">Naziv</label>
					<input type="text" id="preduzece-ime" 
							class="form-control" name="naziv" value="${preduzece.naziv}"/>
				</div>
				
				<div class="form-group">
					<label for="ulica">Ulica</label>
					<input type="text" id="ulica" 
							class="form-control" name="ulica" value="${preduzece.ulica}"/>
				</div>

				<div class="form-group">
					<label for="ulica-broj">Ulicni broj</label>
					<input type="text" id="ulica-broj" 
							class="form-control" name="ulicniBroj" value="${preduzece.ulicniBroj}"/>
				</div>
				
				<div class="form-group">
					<label for="vlasnistvo">Vlasnistvo</label>
					<input type="text" id="vlasnistvo" 
							class="form-control" name="vlasnistvo" value="${preduzece.vlasnistvo}"/>
				</div>
 
				<div class="form-group">
					<label for="project_type">Mesto</label>
					<select name="type" class="selectpicker">
							<option value="${preduzece.mesto.mestoId}">${preduzece.mesto.nazivMesta}</option>
						<c:forEach items="${mesta}" var="mesto">
							<c:if test="${preduzece.mesto.mestoId ne mesto.mestoId}">
							<option value="${mesto.mestoId}">${mesto.nazivMesta}</option>
							</c:if>
						</c:forEach>
					</select>
				</div>
				
				<div class="form-group">
					<input type="hidden" id="user-Id" 
							class="form-control" name="userId" value="${preduzece.user.userId}"/>
				</div>
				
				<div class="form-group">
					<label for="firstName">Ime</label>
					<input type="text" id="firstName" 
							class="form-control" name="firstName" value="${preduzece.user.firstName}"/>
				</div>
				
				<div class="form-group">
					<label for="lastName">Prezime</label>
					<input type="text" id="lastName" 
							class="form-control" name="lastName" value="${preduzece.user.lastName}"/>
				</div>
				
				<div class="form-group">
					<label for="zanimanje">Zanimanje</label>
					<input type="text" id="zanimanje" 
							class="form-control" name="zanimanje" value="${preduzece.user.zanimanje}"/>
				</div>
				
				<div class="form-group">
					<label for="telefon">Telefon</label>
					<input type="text" id="telefon" 
							class="form-control" name="telefon" value="${preduzece.user.telefon}"/>
				</div>
				
				<div class="form-group">
					<label for="fax">Fax</label>
					<input type="text" id="fax" 
							class="form-control" name="fax" value="${preduzece.user.fax}"/>
				</div>
				
				<div class="form-group">
					<label for="mobilni">Mobilni</label>
					<input type="text" id="mobilni" 
							class="form-control" name="mobilni" value="${preduzece.user.mobilni}"/>
				</div>
				
				<div class="form-group">
					<label for="emailAddress">Email</label>
					<input type="text" id="emailAddress" 
							class="form-control" name="emailAddress" value="${preduzece.user.emailAddress}"/>
				</div>
				
<!--  				
				<div class="form-group">
					<label for="naziv-mesta">Naziv Mesta</label>
					<input type="text" id="naziv-mesta" 
							class="form-control" name="nazivMesta"/>
				</div>
				
				<div class="form-group">
					<label for="zip">ZIP</label>
					<input type="text" id="zip" 
							class="form-control" name="zip"/>
				</div>

				<div class="form-group">
					<label for="okrug">Okrug</label>
					<input type="text" id="okrug" 
							class="form-control" name="okrug"/>
				</div>
				
				<div class="form-group">
					<label for="opstina">Opstina</label>
					<input type="text" id="opstina" 
							class="form-control" name="opstina"/>
				</div>
-->
<!--  				
				<div class="form-group">
					<label for="project_type">Type</label>
					<select name="type" class="selectpicker">
						<option></option>
						<option value="single">Single Year</option>
						<option value="multi">Multi-Year</option>
					</select>
				</div>
							
				<div class="form-group">
					<label for="sponsor">Sponsor</label>
					<input id="sponsor" type="text" 
							class="form-control" name="sponsor"/>
				</div>
			
				<div class="form-group">
					<label for="funds">Authorized Funds</label>
					<input id="funds" type="text"
						class="form-control" name="authorizedFunds"/>
				</div>
			
				<div class="form-group">
					<label for="hours">Authorized Hours</label>
					<input id="hours" type="text"
						class="form-control" name="authorizedHours"/>
				</div>
			
				<div class="form-group">
					<label for="project-name">Description</label>
					<textarea class="form-control" name="description" rows="3"></textarea>
				</div>
				
				<div class="form-group">
					<label for="special">Special</label>
					<input id="special" name="special" type="checkbox"/>
				</div>
-->			
				<button type="submit" class="btn btn-default" name="obrisi">Obrisi</button>
				<button type="submit" class="btn btn-default" name="sacuvaj">Sacuvaj</button>
				<button type="submit" class="btn btn-default" name="odustani">Odustani</button>
	
			</form>
			
		</div>
	</div>
</body>
</html>