<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Gestion de la Carte</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" type="" href="./style.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	<body>
		<div class="container-fluid">
			<%@ include file="header.jsp" %>
			
			<main>
				<form class="form-row align-items-center" method="Post" action="${ pageContext.request.contextPath }/ServletGestionDeLaCarte">
                    <div class="col-sm-12">
                    <!-- AJOUTER DE NOUVEAUX PLATS -->
                    <label class="liste" for="liste-entree">Ajouter un nouveau plat</label>
                    <div class="input-group">
                    <input type="text" class="form-control" placeholder="Nom" name="nom">
                    <input type="text" class="form-control" placeholder="Prix Vente" name = "prixVente">
                    <input type="text" class="form-control" placeholder="Prix Revient" name="prixRevient">
                    <input type="text" class="form-control" placeholder="Qté Stock" name="stock">
                      <select class="custom-select" id="inputGroupSelect04" name="categorie">
                        <option selected>Catégorie</option>
                                    <option value="entree">Entrée</option>
                                    <option value="plat">Plat</option>
                                    <option value="dessert">Dessert</option>
                      </select>
                      <div class="input-group-append">
                        <button class="btn btn-primary" type="submit">+</button>
                      </div>
                    </div>    
                </form>
				<hr/>
				<!-- CARTE DU RESTAURANT -->		
				<h2>Les plats à la carte du restaurant</h2>
				<h3>Les Entrées</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Prix de Revient</th>
							<th scope="col">Prix de Vente</th>
							<th scope="col">Stock</th>
							<th scope="col">Modifier ou Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="current" items="${entrees}">
								<tr>
									<th scope="row">${current.nom} </th>	
		           				
										
											<td>${current.prixDeReviens } </td>
											<td>${current.prixDeVente } </td>
											<td>${current.stock}</td>
											
											<td>
											<div class="btn-group mr-2" role="group" aria-label="First group">
												<form method="get" action="${ pageContext.request.contextPath }/ServletModifierPlat">
													
														<input type="hidden" name="id" value="${current.id }" />
														<button type="submit" class="btn btn-info">Modifier</button>
													
														</form>
																								
											
											<form method="post" action="${ pageContext.request.contextPath }/ServletSupprimerPlat">
														
														<input type="hidden" name="id" value="${current.id }" />
														<button type="submit" class="btn btn-danger">Supprimer</button>
															</form>	
												</div>
											
											</td>
									</tr>
								</c:forEach>	
	       					</tr>			
						</tbody>
					</table>
				
				<hr />
				
				<h3>Les Plats</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Prix de Vente</th>
							<th scope="col">Prix de Revient</th>
							<th scope="col">Stock</th>
							<th scope="col">Modifier ou Supprimer</th>  
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="current" items="${plats}">
							<tr>
								<th scope="row">${current.nom} </th>	
	           				
									
										<td>${current.prixDeReviens } </td>
										<td>${current.prixDeVente } </td>
										<td>${current.stock}</td>
										
										<td>
										<div class="btn-group mr-2" role="group" aria-label="First group">
												<form method="get" action="${ pageContext.request.contextPath }/ServletModifierPlat">
													
														<input type="hidden" name="id" value="${current.id }" />
														<button type="submit" class="btn btn-info">Modifier</button>
													
														</form>
																								
											
											<form method="post" action="${ pageContext.request.contextPath }/ServletSupprimerPlat">
														
														<input type="hidden" name="id" value="${current.id }" />
														<button type="submit" class="btn btn-danger">Supprimer</button>
															</form>	
												</div>
										</td>
									
								</tr>
							</c:forEach>	
       					</tr>			
					</tbody>
				</table>
				
				<hr />
				
				<h3>Les Desserts</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Prix Vente</th>
							<th scope="col">Prix Revient</th>
							<th scope="col">Stock</th>
							<th scope="col">Modifier ou Supprimer</th>  
						</tr>
					</thead>
					<tbody>
					<tr>
					<c:forEach var="current" items="${desserts}">
					<tr>
								<th scope="row">${current.nom} </th>	
	           				
									
										<td>${current.prixDeReviens } </td>
										<td>${current.prixDeVente } </td>
										<td>${current.stock}</td>
										
										<td>
											<div class="btn-group mr-2" role="group" aria-label="First group">
												<form method="get" action="${ pageContext.request.contextPath }/ServletModifierPlat">
													
														<input type="hidden" name="id" value="${current.id }" />
														<button type="submit" class="btn btn-info">Modifier</button>
													
														</form>
																								
											
											<form method="post" action="${ pageContext.request.contextPath }/ServletSupprimerPlat">
														
														<input type="hidden" name="id" value="${current.id }" />
														<button type="submit" class="btn btn-danger">Supprimer</button>
															</form>	
												</div>
										</td>
									
								</tr>
							</c:forEach>	
       					</tr>			
					</tbody>
				</table>
				
				<hr />
				
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Inventaire</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${inventaireTotal}</td>
						</tr>
					</tbody>
				
				</table>
				<%-- <form class="form-row align-items-center" method="Post" action="${ pageContext.request.contextPath }/ServletGestionDeLaCarte">
					<p> Inventaire  = ${inventaireTotal} </p>	
				</form> --%>
				
			</main>
		</div>
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	</body>	
</html>