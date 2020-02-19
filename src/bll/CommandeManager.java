package bll;

import dal.CommandeDAO;

public class CommandeManager {
	private CommandeDAO dao;

	public CommandeDAO getDao() {
		return dao;
	}

	public void setDao(CommandeDAO dao) {
		this.dao = dao;
	}
}
