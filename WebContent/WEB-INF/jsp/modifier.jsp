<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="header.jsp" %>
<meta charset="UTF-8">
<title>modifier</title>
</head>
<body>
<form method="post" action="${ pageContext.request.contextPath }/ServletModifierPlat"class="form-row align-items-center">
					<div class="col-sm-12">
					<!-- AJOUTER DE NOUVEAUX PLATS -->
					<label class="liste" for="liste-entree">Ajouter un nouveau plat</label>
					<div class="input-group">
						
					<input type="text" class="form-control" placeholder="Nom" value="${ plat.nom }" >
								<input type="text" class="form-control" placeholder="Prix Vente" value="${ plat.prixDeVente }">
							<input type="text" class="form-control" placeholder="Prix Revient" value="${ plat.prixDeReviens }">
					<input type="text" class="form-control" placeholder="Quantite Stock" value="${ plat.stock }">
					  <select class="custom-select" id="inputGroupSelect04">
					    <option selected>Categorie</option>
									<option value="entree">Entree</option>
									<option value="plat">Plat</option>
									<option value="dessert">Dessert</option>
					  </select>
					  <div class="input-group-append">
					    <button class="btn btn-primary" type="submit" value="Modifier">+</button>
					  </div>
					</div>	
				</form>
				<hr/>
				
		
		
	
	
</body>
</html>