<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="fr">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>
		<meta charset="utf-8" />
		<title>Prise de Commande</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" type="" href="./style.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body>
	    <div class="container-fluid">
	    	 <%@ include file="header.jsp" %>
	       
	        <main>
	            <!-- PARTIE GAUCHE - CHOIX CARTE-->
	            <div class = "row">
	            	<div class="col">
	
		                <!-- CHOIX DES ENTRÉES -->
		                <label class="liste" for="liste-entree">Les Entrées</label>
		
		                <c:forEach var="current" items="${entrees}">
			                <form method="Post" action="${ pageContext.request.contextPath }/ServletPriseDeCommande">
			                    <!-- CHAMPS VISIBLES -->
			                    <div class="input-group mb-2">
			                        <div class="input-group-prepend">
			                            <span class="input-group-text">${current.nom}</span>
			                        </div>
			
			                        <div class="input-group-append" id="button-addon3">
			                            <button class="btn btn-primary actionBtn" type="submit">+</button>
			                        </div>
		                        </div>
		                        <!-- CHAMPS MASQUÉS -->
								<input type="hidden" name="id" value="${current.id }">
								<input type="hidden" name="nom" value="${current.nom }">
								<input type="hidden" name="categorie" value="${current.categorie }">
								<input type="hidden" name="prixDeReviens" value="${current.prixDeReviens }">
								<input type="hidden" name="prixDeVente" value="${current.prixDeVente }">
	                            <input type="hidden" name="stock" value="${current.stock }">
                            
                   
                    </form>
                </c:forEach>
            

        <hr />
        <!-- CHOIX DES PLATS -->

      <label class="liste" for="liste-plat">Les Plats</label>
			        
			        <c:forEach var="current" items="${plats}">
			            <form method="Post" action="${ pageContext.request.contextPath }/ServletPriseDeCommande">
							<!-- CHAMPS VISIBLES -->
							<div class="input-group mb-2">
								<div class="input-group-prepend">
								    <span class="input-group-text">${current.nom}</span>
								</div>
								
								<div class="input-group-append" id="button-addon3">
								    <button class="btn btn-primary" type="submit">+</button>
								</div>	
							 </div>
							 <!-- CHAMPS MASQUÉS -->
							<input type="hidden" name="id" value="${current.id }">
							<input type="hidden" name="nom" value="${current.nom }">
							<input type="hidden" name="categorie" value="${current.categorie }">
							<input type="hidden" name="prixDeReviens" value="${current.prixDeReviens }">
							<input type="hidden" name="prixDeVente" value="${current.prixDeVente }">
							<input type="hidden" name="stock" value="${current.stock }">
			            </form>
		        	</c:forEach>
	
			        <hr />
        <!-- CHOIX DES DESSERTS     -->
        <label class="liste" for="liste-dessert">Les Desserts</label>

        <c:forEach var="current" items="${desserts}">
        <form method="Post"
                action="${ pageContext.request.contextPath }/ServletPriseDeCommande">
            <div class="input-group mb-2">
                <div class="input-group-prepend">
                    <span class="input-group-text">${current.nom}</span>
                </div>

                <div class="input-group-append" id="button-addon3">
                    <button class="btn btn-outline-secondary" type="submit">+</button>
                    <input type="hidden" name="id" value="${current.id }"> <input
                        type="hidden" name="nom" value="${current.nom }"> <input
                        type="hidden" name="categorie" value="${current.categorie }">
                    <input type="hidden" name="prixDeReviens"
                        value="${current.prixDeReviens }"> <input type="hidden"
                        name="prixDeVente" value="${current.prixDeVente }"> <input
                        type="hidden" name="stock" value="${current.stock }">
                        
                </div>
            </div>
            </form>
        </c:forEach>

    
        </div>    
            <!-- CENTRE - GOUTTIÈRE -->
        <div class="col-sm-1"></div>
        <!-- PARTIE DROITE - COMMANDE TABLE -->
        <form class="form-row align-items-center" method="Post" action="${ pageContext.request.contextPath }/ServletAfficherCommandes">
         <div class="col-sm-12">
                <!-- CHOIX DE LA TABLE -->
                <div class="input-group mb-2 mr-sm-2">
                    <div class="input-group-prepend">
                        <div class="input-group-text">N° de Table</div>
                    </div>
                    <select class="custom-select mr-sm-2" id="inlineFormTableSelect" name="table">
                        <option selected>##</option>
                        <option value="1">01</option>
                        <option value="2">02</option>
                        <option value="3">03</option>
                        <option value="4">04</option>
                        <option value="5">05</option>
                        <option value="6">06</option>
                        <option value="7">07</option>
                        <option value="8">08</option>
                    </select>
                    <c:if test="${!empty error }">
                    	<div>${error}</div>
                    </c:if>
                </div>
                <hr />
            </div>
            <div class="col-sm-6">
                <label class="liste" for="liste liste-dessert">Récapitulatif
                    de la Commande </label>

                <c:forEach var="current" items="${commandeEnCours }">
                    <div class="input-group mb-2">
                        <div class="input-group-prepend">
                            <span class="input-group-text">${current.nom }</span> <span
                                class="input-group-text">${current.prixDeVente }</span>
                                
                            <button class="btn btn-outline-secondary" type="button">-</button>
                        </div>
                    </div>
                  
                </c:forEach>
					<p> Montant total = ${montantCommande} </p>


                <button type="submit"
                    class="btn btn-lg btn-outline-primary col-sm-12">Envoyer
                    la Commande</button>
            </div>
            
        </form>
        </div>
        <hr />
    </div>
    </div>

    <footer> </footer>


    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>