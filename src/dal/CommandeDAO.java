package dal;

import java.util.List;

import bo.Commande;

public interface CommandeDAO {

	List<Commande> selectAllCommandes();

	void insertCommande(Commande commande);

}
