<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
	<script src="<spring:url value="/resources/js/jquery.tablesorter.js"/>"></script>

	<script src="<spring:url value="/resources/js/slimtable.js"/>"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function() 
		    {
			//	alert("proba");
		        $("#myTable").tablesorter({sortMultiSortKey: 'altKey'}); 
			        
		    } 
		);
	
	

	</script>




</head>
<body>
	
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>			

	<div class="container">
		<div class="row">
		
				<form action="<spring:url value="/vozilo"/>" method="post" class="col-md-8 col-md-offset-2">
		
				<div class="form-group">
					<input type="hidden" id="preduzece-id" 
							class="form-control" name="preduzeceId" value="${predId}"/>
				</div>
				<div class="form-group">
					<input type="text" id="preduzece-id" 
							class="form-control" name="predid" value="${predId}"/>
				</div>
			<h2>Vozila preduzeca ${preduzece.naziv}</h2>
			<table id="myTable" class="table table-hover">
				<thead>
					<tr>
						<th>Marka</th><th>Model</th><th>Godiste</th><th>Emisiona Klasa</th><th>Kubikaza</th>
					</tr>
				</thead>
				<tbody>	
					<c:forEach items="${vozila}" var="vozilo">
						<tr>
							<td><a href = "<spring:url
							value="/vozilo/${vozilo.voziloId}"/>">${vozilo.marka}</a></td>
							<td>${vozilo.model}</td>
							<td>${vozilo.godiste}</td>
							<td>${vozilo.emisionaKlasa}</td>
							<td>${vozilo.kubikaza}</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			
	
			<button type="submit" class="btn btn-default" name="nazad">Nazad</button>
			<button type="submit" class="btn btn-default" name="dodaj_vozilo">Dodaj</button>
	
			</form>
	
		</div>
	</div>
</body>

</html>