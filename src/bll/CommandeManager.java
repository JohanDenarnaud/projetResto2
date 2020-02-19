package bll;

import java.util.List;

import bo.Commande;
import dal.CommandeDAO;

public class CommandeManager {
	private CommandeDAO dao;
	private static CommandeManager instance;

	public static CommandeManager getInstance() {
		return instance;
	}

	public CommandeDAO getDao() {
		return dao;
	}

	public void setDao(CommandeDAO dao) {
		this.dao = dao;
	}

	public List<Commande> selectAllCommandes() {

		return dao.selectAllCommandes();
	}

	public void insertCommande(Commande commande) {

		dao.insertCommande(commande);
		System.out.println();

	}
}
