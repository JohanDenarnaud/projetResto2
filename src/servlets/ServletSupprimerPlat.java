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

/**
 * Servlet implementation class ServletSupprimerPlat
 */
@WebServlet("/ServletSupprimerPlat")
public class ServletSupprimerPlat extends HttpServlet {
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
	public ServletSupprimerPlat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idPlat = request.getParameter("id");
		Integer idPlatInt = Integer.valueOf(idPlat);

		pm.deleteById(idPlatInt);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("gestionDeLaCarte");
		rd.forward(request, response);
	}

}
