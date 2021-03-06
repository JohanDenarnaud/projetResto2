package servlets;

import java.io.IOException;

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
 * Servlet implementation class ServletModifierPlat
 */
@WebServlet("/ServletModifierPlat")
public class ServletModifierPlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlatManager pm;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		pm = context.getBean("pm", PlatManager.class);
		super.init();

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModifierPlat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println(id);
		Integer idAsInt = Integer.valueOf(id);

		Plat plat = pm.selectById(idAsInt);
		request.setAttribute("plat", plat);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("modifier");
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
		String id = request.getParameter("id");

		Integer prixVenteInt = Integer.valueOf(prixVente);
		Integer prixRevientInt = Integer.valueOf(prixRevient);
		Integer stockInt = Integer.valueOf(stock);

		Plat plat = new Plat();
		plat.setCategorie(categorie);
		plat.setNom(nomPlat);
		plat.setPrixDeReviens(prixRevientInt);
		plat.setPrixDeVente(prixVenteInt);
		plat.setStock(stockInt);
		Integer idAsInt = Integer.valueOf(id);

		pm.update(new Plat(idAsInt, nomPlat, prixVenteInt, prixRevientInt, categorie, stockInt));
		response.sendRedirect("ServletGestionDeLaCarte");
	}

}
