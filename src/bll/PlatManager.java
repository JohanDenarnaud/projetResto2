package bll;

import java.util.List;

import bo.Plat;
import dal.PlatDAO;

public class PlatManager {
	private PlatDAO dao;

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

	public void insertPlat(Plat plat) {
		// TODO Auto-generated method stub
		dao.insertPlat(plat);
	}

	public void update(Plat plat) {
		dao.update(plat);

	}

	public Plat selectById(Integer idAsInt) {

		return dao.selectById(idAsInt);
	}

	public void deleteById(Integer idPlatInt) {
		dao.deleteById(idPlatInt);

	}

	public static Integer CalculMontantInventaire(List<Plat> inventaire) {
		Integer montantPlat = 0;
		for (Plat current : inventaire) {
			montantPlat = montantPlat + current.getPrixDeReviens() * current.getStock();
		}
		System.out.println(montantPlat);
		return montantPlat;
	}

}