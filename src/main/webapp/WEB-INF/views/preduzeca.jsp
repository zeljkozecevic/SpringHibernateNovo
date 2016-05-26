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
		
				<form action="<spring:url value="/preduzece"/>" method="post" class="col-md-8 col-md-offset-2">
		
			<h2>Preduzeca</h2>
			<table id="myTable" class="table table-hover">
				<thead>
					<tr>
						<th>Naziv</th><th>Ulica</th><th>ID</th><th>Mesto</th><th>Kontakt Osoba</th>
					</tr>
				</thead>
				<tbody>	
					<c:forEach items="${preduzeca}" var="preduzece">
						<tr>
							<td><a href = "<spring:url
							value="/preduzece/${preduzece.preduzeceId}"/>">${preduzece.naziv}</a></td>
							<td>${preduzece.ulica}</td>
							<td>${preduzece.preduzeceId}</td>
							<td>${preduzece.mesto.nazivMesta}</td>
							<td>${preduzece.user.firstName} ${preduzece.user.lastName}</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
			
		
				<div class="form-group">
								<label for="preduzece-ime">Nadji preduzece</label>
								<input type="text" id="preduzece-ime" 
										class="form-control" name="naziv"/>
				</div>
	
			<button type="submit" class="btn btn-default">Pronadji</button>
			<button type="submit" class="btn btn-default" name="dodaj" value="Dodaj">Dodaj</button>
	
			</form>
	
		</div>
	</div>
</body>

</html>