package servlets;

import java.io.IOException;
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

/**
 * Servlet implementation class ServletGestionDeLaCarte
 */
@WebServlet("/ServletGestionDeLaCarte")
public class ServletGestionDeLaCarte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Plat> inventaire;
	private PlatManager pm;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		pm = context.getBean("pm", PlatManager.class);
		super.init();

	}

	public ServletGestionDeLaCarte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Plat> entrees = pm.selectByCategorie("entree");
		List<Plat> plats = pm.selectByCategorie("plat");
		List<Plat> desserts = pm.selectByCategorie("dessert");

		// autre idée : selectALL puis création des 3 listes avec boucle for

		request.setAttribute("entrees", entrees);
		request.setAttribute("plats", plats);
		request.setAttribute("desserts", desserts);

		Integer montantEntree = pm.CalculMontantInventaire(entrees);
		request.setAttribute("montantEntree", montantEntree);

		Integer montantPlat = pm.CalculMontantInventaire(plats);
		request.setAttribute("montantPlat", montantPlat);

		Integer montantDessert = pm.CalculMontantInventaire(desserts);
		request.setAttribute("montantDessert", montantDessert);

		Integer inventaireTotal = montantDessert + montantEntree + montantPlat;

		request.setAttribute("inventaireTotal", inventaireTotal);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("gestionDeLaCarte");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomPlat = request.getParameter("nom");
		String prixVente = request.getParameter("prixVente");
		String prixRevient = request.getParameter("prixRevient");
		String stock = request.getParameter("stock");
		String categorie = request.getParameter("categorie");

		Integer prixVenteInt = Integer.valueOf(prixVente);
		Integer prixRevientInt = Integer.valueOf(prixRevient);
		Integer stockInt = Integer.valueOf(stock);

		Plat plat = new Plat();
		plat.setCategorie(categorie);
		plat.setNom(nomPlat);
		plat.setPrixDeReviens(prixRevientInt);
		plat.setPrixDeVente(prixVenteInt);
		plat.setStock(stockInt);

		pm.insertPlat(plat);

		doGet(request, response);
	}

}
