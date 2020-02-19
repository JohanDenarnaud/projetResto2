<!DOCTYPE html>

<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Gestion de la Carte</title>

		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<link rel="stylesheet" type="" href="./css/style.css"/>
	</head>
	<body>
		<div class="container-fluid">
			<header>
				<nav class="nav nav-pills flex-column flex-sm-row">
				  <a class="flex-sm-fill text-sm-center nav-link" href="#">Prise de Commande</a>
				  <a class="flex-sm-fill text-sm-center nav-link" href="#">Gestion des Commandes</a>
				  <a class="flex-sm-fill text-sm-center nav-link active" href="#">Gestion de la Carte</a>
				</nav>
			</header>
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
									<option value="1">Entrée</option>
									<option value="2">Plat</option>
									<option value="3">Dessert</option>
					  </select>
					  <div class="input-group-append">
					    <button class="btn btn-primary" type="submit">+</button>
					  </div>
					</div>	
				</form>
				<hr/>
				<!-- CARTE DU RESTAURANT -->		
				<h2>Les plats à la carte du restaurant</h2>
				<h3>Les Entrées</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Prix Vente</th>
							<th scope="col">Prix Revient</th>
							<th scope="col">Stock</th>
							<th scope="col">…</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Entrée #1</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>##</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								    <button type="button" class="btn btn-info">Modifier</button>
								    <button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
						</tr>
							<tr>
							<th scope="row">Entrée #2</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>##</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
									<button type="button" class="btn btn-info">Modifier</button>
									<button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
						</tr>
						<tr>
							<th scope="row">Entrée #3</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>##</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
									<button type="button" class="btn btn-info">Modifier</button>
									<button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
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
							<th scope="col">…</th>  
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Plat #1</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>##</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
									<button type="button" class="btn btn-info">Modifier</button>
									<button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
						</tr>
							<tr>
							<th scope="row">Plat #2</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>##</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
									<button type="button" class="btn btn-info">Modifier</button>
									<button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
						</tr>
						<tr>
							<th scope="row">Plat #3</th>
							<td>##.## €</td>
      					  	<td>##.## €</td>
							<td>###</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
									<button type="button" class="btn btn-info">Modifier</button>
									<button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
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
							<th scope="col">…</th>  
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">Dessert #1</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>###</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								    <button type="button" class="btn btn-info">Modifier</button>
								    <button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
						</tr>
							<tr>
							<th scope="row">Dessert #2</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>##</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								    <button type="button" class="btn btn-info">Modifier</button>
								    <button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
						</tr>
						<tr>
							<th scope="row">Dessert #3</th>
							<td>##.## €</td>
							<td>##.## €</td>
							<td>###</td>
							<td>
								<div class="btn-group mr-2" role="group" aria-label="First group">
								    <button type="button" class="btn btn-info">Modifier</button>
								    <button type="button" class="btn btn-danger">Supprimer</button>
								  </div>
							</td>
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