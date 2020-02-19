<!DOCTYPE html>

<html lang="fr">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
		<meta charset="UTF-8">
		<title>Gestion des Commandes</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 
		<link rel="stylesheet" type="" href="./css/style.css"/>
		
		
	</head>
	<body>
		<div class="container-fluid">
			<header>
				<nav class="nav nav-pills flex-column flex-sm-row">
				  <a class="flex-sm-fill text-sm-center nav-link" href="#">Prise de Commande</a>
				  <a class="flex-sm-fill text-sm-center nav-link active" href="#">Gestion des Commandes</a>
				  <a class="flex-sm-fill text-sm-center nav-link" href="#">Gestion de la Carte</a>
				  <a class="flex-sm-fill text-sm-center nav-link" href="#">Mode de paiement</a>
				</nav>
			</header>
			
			<main>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">N° Commande</th>
							<th scope="col">N° Table</th>
							<th scope="col">Montant</th>
							<th scope="col">Détail des commandes</th>
							<th scope="col">Mode de paiement</th>
							
						</tr>
					</thead>
					<tbody>
						 <c:forEach var="current" items="${commandes}">
						<tr>
							<th scope="row">${current.id}</th>
							<td>${current.numTable}</td>
							<td>${current.montant }</td>
							
							<td><button type="button" class="btn btn-md btn-primary myPopover" data-toggle="popover" title="Popover title" data-content="And here's some amazing content. It's very engaging. Right?">Détails…</button></td>
							<td><select class=form-control>
								<option value=false>A régler</option>
								<option value=true_CB>CB</option>
								<option value=chèque>Chéque</option>
								<option value=espèces>Espèces</option>
								<option value=chèque restaurant>Chèque Restaurant</option>
							   </select></td>
						</tr>
						</c:forEach>


					</tbody>
				</table>
			</main>
			
			
						<footer>
						</footer>
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