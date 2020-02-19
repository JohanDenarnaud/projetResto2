package dal;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bo.Commande;
import bo.Plat;

public class CommandeDAOBouchonImpl implements CommandeDAO {
	List<Commande> commandes;
	List<Plat> plats;

	public CommandeDAOBouchonImpl() {
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

		Commande com1 = new Commande(1, 10, 55, false, LocalTime.now(), plats);
		Commande com2 = new Commande(2, 2, 60, false, LocalTime.now(), plats);
		commandes.add(com1);
		commandes.add(com2);
	}

	@Override
	public List<Commande> selectAllCommandes() {

		return commandes;
	}

}
