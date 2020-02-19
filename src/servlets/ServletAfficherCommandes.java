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

import bll.CommandeManager;
import bo.Commande;

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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
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
		 * TODO SELECTALL des commandes (toutes ou non r�gl� � voir)
		 */

		List<Commande> commandes = cm.selectAllCommandes();

		request.setAttribute("commandes", commandes);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("afficherCommandes");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
