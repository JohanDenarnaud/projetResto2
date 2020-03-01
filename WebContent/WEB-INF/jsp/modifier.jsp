<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Modifier un Plat</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<main>
		<form class="form-row align-items-center" method="post" action="${ pageContext.request.contextPath }/ServletModifierPlat"">
			<div class="col-sm-12">
			<!-- AJOUTER DE NOUVEAUX PLATS -->
			<label class="liste" for="liste-entree">Modifier un plat</label>
			<div class="input-group">
				<input type="hidden" name="id" value="${plat.id }"/>
				<input type="text" class="form-control" placeholder="Nom" name="nom" value="${ plat.nom }" >
				<input type="text" class="form-control" name="prixVente" placeholder="Prix Vente" value="${ plat.prixDeVente }">
				<input type="text" class="form-control" placeholder="Prix Revient" name="prixRevient"value="${ plat.prixDeReviens }">
				<input type="text" class="form-control" placeholder="Quantite Stock" name="stock" value="${ plat.stock }">
				<input type="text" class="form-control" placeholder="categorie" name="categorie" value="${ plat.categorie }">
				<div class="input-group-append">
					<button class="btn btn-primary" type="submit" value="Modifier">+</button>
				</div>
			</div>	
		</form>
	</main>
</body>
</html>