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

import bll.CommandeManager;

/**
 * Servlet implementation class ServletGestionDeLaCarte
 */
@WebServlet("/ServletGestionDeLaCarte")
public class ServletGestionDeLaCarte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeManager cm;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
		cm = context.getBean("cm", CommandeManager.class);
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

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("gestionDeLaCarte");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * TODO récupérer les données du formulaire de création d'un plat et inserer le
		 * plat dans la BDD
		 */

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("gestionDeLaCarte");
		rd.forward(request, response);
	}

}
