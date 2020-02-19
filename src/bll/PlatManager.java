package bll;

import java.util.List;

import bo.Plat;
import dal.PlatDAO;

public class PlatManager {
	private PlatDAO dao;
	private static PlatManager instance;

	public static PlatManager getInstance() {
		return instance;
	}

	public PlatManager() {
		PlatManager.instance = this;
	}

	public List<Plat> selectAll() {
		return dao.selectAll();
	}

	public PlatDAO getDao() {
		return dao;
	}

	public void setDao(PlatDAO dao) {
		this.dao = dao;
	}

	public List<Plat> selectByCategorie(String string) {
		// TODO Auto-generated method stub
		return dao.selectByCategorie(string);

	}

	public static Integer totalCommande(List<Plat> commandeEnCours) {

		Integer montantCommande = 0;
		for (Plat current : commandeEnCours) {
			montantCommande = montantCommande + current.getPrixDeVente();
		}
		return montantCommande;
	}

}