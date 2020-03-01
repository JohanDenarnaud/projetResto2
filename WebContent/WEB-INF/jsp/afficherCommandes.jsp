<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="fr">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
		<meta charset="UTF-8">
		<title>Gestion des Commandes</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" type="" href="./style.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>	
	<body>
		<div class="container-fluid">
			<%@ include file="header.jsp" %>
			
			<main>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">N° Commande</th>
							<th scope="col">N°Table</th>
							<th scope="col">Montant</th>
							<th scope="col">Detail des Commandes</th>
							<th scope="col">Mode de Réglement</th>					
						</tr>
					</thead>
					<tbody>
						 <c:forEach var="current" items="${commandes}">
						 <tr <c:if test="${current.reglement}" >
							 style="background-color:lightgreen;"
							 </c:if> >
	
							<th scope="row">${current.id}</th>
							<td>${current.numTable}</td>
							<td>${current.montant }</td>
							
							<td><button type="button" class="btn btn-md btn-primary myPopover" data-toggle="popover" title="Détail Commande" 
                            data-content=" <c:forEach var="current2" items="${current.getPlats()}">
                                                -${current2.nom} 
                                            </c:forEach>
                            
                                ">Détails…</button></td>
							<td>
								<select class=form-control>
								<option value=false>Réglement par ¦</option>
								<option value=true_CB>CB</option>
								<option value=cheque>Cheque</option>
								<option value=especes>Espèces</option>
								<option value=cheque restaurant>Cheque Restaurant</option>
							   </select>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<hr />
				
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Montant de la Recette</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${recette}</td>
						</tr>
					</tbody>	
				</table>
			</main>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
		
		<script>
			$(document).ready(function(){
			  $('[data-toggle="popover"]').popover();   
			});
		</script>
	</body>	
</html>