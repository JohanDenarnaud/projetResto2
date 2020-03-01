package bll;

import java.util.List;

import bo.Commande;
import dal.CommandeDAO;

public class CommandeManager {
	private CommandeDAO dao;

	public CommandeDAO getDao() {
		return dao;
	}

	public void setDao(CommandeDAO dao) {
		this.dao = dao;
	}

	public List<Commande> selectAllCommandes() {
		// TODO Auto-generated method stub
		return dao.selectAllCommandes();
	}

	public void insertCommande(Commande commande) {
		dao.insertCommande(commande);

	}

	public static Integer calculRecette(List<Commande> commandes) {

		Integer recette = 0;
		for (Commande current : commandes) {

			recette = recette + current.getMontant();
		}
		return recette;
	}
}
