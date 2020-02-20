<!DOCTYPE html>

<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Gestion de la Carte</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		
		<%@ include file="header.jsp" %>
	</head>
	<body>
		<div class="container-fluid">
			
			<main>
				<form class="form-row align-items-center" method="Post" action="${ pageContext.request.contextPath }/ServletGestionDeLaCarte">
                    <div class="col-sm-12">
                    <!-- AJOUTER DE NOUVEAUX PLATS -->
                    <label class="liste" for="liste-entree">Ajouter un nouveau plat</label>
                    <div class="input-group">
                    <input type="text" class="form-control" placeholder="Nom" name="nom">
                    <input type="text" class="form-control" placeholder="Prix Vente" name = "prixVente">
                    <input type="text" class="form-control" placeholder="Prix Revient" name="prixRevient">
                    <input type="text" class="form-control" placeholder="QtÃ© Stock" name="stock">
                      <select class="custom-select" id="inputGroupSelect04" name="categorie">
                        <option selected>CatÃ©gorie</option>
                                    <option value="entree">EntrÃ©e</option>
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
				<h2>Les plats Ã  la carte du restaurant</h2>
				<h3>Les Entrees</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Prix Vente â¬</th>
							<th scope="col">Prix Revient â¬</th>
							<th scope="col">Stock</th>
							<th scope="col">â¦</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach var="current" items="${entrees}">
						<tr>
							<th scope="row">${current.nom} </th>
							 
        				<form method="Post" action="${ pageContext.request.contextPath }/ServletPriseDeCommande">
           				
							
							<td>${current.prixDeReviens } </td>
							<td>${current.prixDeVente } </td>
							<td>${current.stock}</td>
							
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								<form method="post" action="${ pageContext.request.contextPath }/ServletGestionDeLaCarte">
								<input type="hidden" name="id" value="${current.id }" />
									<button type="submit" class="btn btn-danger">Supprimer</button>
								</form>
									<a class="flex-sm-fill text-sm-center nav-link" href="ServletModifierPlat">Modifier</a>
								
								  </div>
								  
							</td>
							</tr>
						</form>
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
							<th scope="col">Prix Vente</th>
							<th scope="col">Prix Revient</th>
							<th scope="col">Stock</th>
							<th scope="col">â¦</th>  
						</tr>
					</thead>
						<tbody>
						<tr>
						<c:forEach var="current" items="${plats}">
						<tr>
							<th scope="row">${current.nom} </th>
							 
        				<form method="Post" action="${ pageContext.request.contextPath }/ServletPriseDeCommande">
           				
							
							<td>${current.prixDeReviens } </td>
							<td>${current.prixDeVente } </td>
							<td>${current.stock}</td>
							
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								<form method="post" action="${ pageContext.request.contextPath }/ServletGestionDeLaCarte">
								<input type="hidden" name="id" value="${current.id }" />
									<button type="submit" class="btn btn-danger">Supprimer</button>
								</form>
									<a class="flex-sm-fill text-sm-center nav-link" href="ServletModifierPlat">Modifier</a>
								  </div>
							</td>
							</form>
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
							<th scope="col">â¦</th>  
						</tr>
					</thead>
						<tbody>
						<tr>
						<c:forEach var="current" items="${desserts}">
						<tr>
							<th scope="row">${current.nom} </th>
							 
        				<form method="Post" action="${ pageContext.request.contextPath }/ServletPriseDeCommande">
           				
							
							<td>${current.prixDeReviens } </td>
							<td>${current.prixDeVente } </td>
							<td>${current.stock}</td>
							
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								<form method="post" action="${ pageContext.request.contextPath }/ServletGestionDeLaCarte">
								<input type="hidden" name="id" value="${current.id }" />
									<button type="submit" class="btn btn-danger">Supprimer</button>
								</form>
									<a class="flex-sm-fill text-sm-center nav-link" href="ServletModifierPlat">Modifier</a>
								
								  </div>
							</td>
							</tr>
						</form>
							</c:forEach>	
		
        					</tr>
										
					</tbody>
				</table>
				
			</main>
			<footer>
			</footer>
		</div>
		
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	</body>	
</html>