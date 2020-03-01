package servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bll.CommandeManager;
import bo.Commande;
import bo.Plat;

/**
 * Servlet implementation class ServletAfficherCommandes
 */
@WebServlet("/ServletAfficherCommandes")
public class ServletAfficherCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeManager cm;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		cm = context.getBean("cm", CommandeManager.class);
		super.init();

	}

	public ServletAfficherCommandes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * TODO SELECTALL des commandes (toutes ou non réglé à voir)
		 */

		List<Commande> commandes = cm.selectAllCommandes();
		for (Commande current : commandes) {
			System.out.println(current.getPlats());
		}

		request.setAttribute("commandes", commandes);

		Integer recette = cm.calculRecette(commandes);

		request.setAttribute("recette", recette);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("afficherCommandes");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Plat> platsCommandes = new ArrayList<Plat>();
		platsCommandes = (List<Plat>) session.getAttribute("commandeEnCours");
		Integer montantCommande = (Integer) session.getAttribute("montantCommande");
		String numTable = request.getParameter("table");

		LocalDateTime dateCommande = LocalDateTime.now();
		Commande commande = new Commande();

		if (numTable.equals("##")) {
			session.setAttribute("error", "Veuillez saisir un numéro de table");
			response.sendRedirect("ServletPriseDeCommande");
		} else {
			session.setAttribute("error", null);
			Integer numTableInt = Integer.valueOf(numTable);
			commande.setNumTable(numTableInt);
			commande.setMontant(montantCommande);
			commande.setHeureDeCommande(dateCommande);
			commande.setPlats(platsCommandes);
			commande.setReglement(false);

			cm.insertCommande(commande);
			session.removeAttribute("commandeEnCours");
			session.removeAttribute("montantCommande");

			doGet(request, response);
		}

	}

}
