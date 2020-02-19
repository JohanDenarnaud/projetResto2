package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bll.PlatManager;
import bo.Plat;

@WebServlet("/ServletPriseDeCommande")
public class ServletPriseDeCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlatManager pm;
	private List<Plat> commandeEnCours;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		pm = context.getBean("pm", PlatManager.class);
		super.init();

	}

	public ServletPriseDeCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Plat> entrees = pm.selectByCategorie("entree");
		List<Plat> plats = pm.selectByCategorie("plat");
		List<Plat> desserts = pm.selectByCategorie("dessert");

		// autre idée : selectALL puis création des 3 listes avec boucle for

		request.setAttribute("entrees", entrees);
		request.setAttribute("plats", plats);
		request.setAttribute("desserts", desserts);

		request.setAttribute("commandeEnCours", commandeEnCours);
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("priseDeCommande");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//if (liste de plat commande existe) {
//	ajouter dans la liste  commande sur la jsp prise de commande
//}else {
//	creer la liste et ajouter le plat dans la liste 
//}			
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String categorie = request.getParameter("categorie");
		String prixDeRevient = request.getParameter("prixDeReviens");
		String prixDeVente = request.getParameter("prixDeVente");
		String stock = request.getParameter("stock");

		Integer idInt = Integer.valueOf(id);
		Integer prixDeRevientInt = Integer.valueOf(prixDeRevient);
		Integer prixDeVenteInt = Integer.valueOf(prixDeVente);
		Integer stockInt = Integer.valueOf(stock);

		Plat platAjouter = new Plat(idInt, nom, prixDeVenteInt, prixDeRevientInt, categorie, stockInt);

		if (commandeEnCours == null) {
			commandeEnCours = new ArrayList<Plat>();
			commandeEnCours.add(platAjouter);
		} else {
			commandeEnCours.add(platAjouter);
		}

		Integer montantCommande = PlatManager.totalCommande(commandeEnCours);
		request.setAttribute("montantCommande", montantCommande);
		request.setAttribute("commandeEnCours", commandeEnCours);
		response.sendRedirect("ServletPriseDeCommande");
		System.out.println(commandeEnCours);
		System.out.println(montantCommande);
		/*
		 * TODO récuperer les données du formulaire de prise de commande et INSERER la
		 * commande valider
		 */

	}

}
