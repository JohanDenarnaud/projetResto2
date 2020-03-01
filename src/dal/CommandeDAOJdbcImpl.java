package dal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bo.Commande;
import bo.Plat;

public class CommandeDAOJdbcImpl implements CommandeDAO {
	List<Commande> commandes;
	List<Plat> plats;

	public CommandeDAOJdbcImpl() {
		commandes = new ArrayList<Commande>();

		plats = new ArrayList<Plat>();
		Plat plat1 = new Plat(1, "Salade", 15, 2, "entree", 10);
		Plat plat2 = new Plat(2, "Blanquette de veau", 18, 8, "plat", 12);
		Plat plat3 = new Plat(3, "Sabayon", 9, 3, "dessert", 5);
		Plat plat4 = new Plat(4, "tartare", 15, 2, "plat", 15);

		plats.add(plat1);
		plats.add(plat2);
		plats.add(plat3);
		plats.add(plat4);

		Commande com1 = new Commande(1, 10, true, LocalDateTime.now(), 55, plats);
		Commande com2 = new Commande(2, 2, true, LocalDateTime.now(), 60, plats);
		Commande com3 = new Commande(1, 10, true, LocalDateTime.now(), 55, plats);
		Commande com4 = new Commande(1, 10, false, LocalDateTime.now(), 55, plats);
		commandes.add(com1);
		commandes.add(com2);
		commandes.add(com3);
		commandes.add(com4);
	}

	@Override
	public List<Commande> selectAllCommandes() {

		return commandes;
	}

	@Override
	public void insertCommande(Commande commande) {

		commandes.add(commande);

	}

}
