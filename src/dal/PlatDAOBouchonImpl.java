package dal;

import java.util.ArrayList;
import java.util.List;

import bo.Plat;

public class PlatDAOBouchonImpl implements PlatDAO {
	List<Plat> plats;
	List<Plat> platsTries;

	public PlatDAOBouchonImpl() {
		plats = new ArrayList<Plat>();
		Plat plat1 = new Plat(1, "Foie Gras", 15, 5, "entree", 10);
		Plat plat2 = new Plat(2, "Salade", 10, 3, "entree", 10);
		Plat plat3 = new Plat(3, "Poisson", 25, 10, "plat", 10);
		Plat plat4 = new Plat(4, "Viande", 30, 15, "plat", 10);
		Plat plat5 = new Plat(5, "Tiramisu", 10, 5, "dessert", 10);
		Plat plat6 = new Plat(6, "Salade de fruit", 8, 2, "dessert", 10);

		plats.add(plat1);
		plats.add(plat2);
		plats.add(plat3);
		plats.add(plat4);
		plats.add(plat5);
		plats.add(plat6);

	}

	@Override
	public List<Plat> selectAll() {
		// TODO Auto-generated method stub
		return plats;
	}

	@Override
	public List<Plat> selectByCategorie(String string) {
		platsTries = new ArrayList<Plat>();
		for (Plat current : plats) {
			if (current.getCategorie() == string) {
				platsTries.add(current);
			}
		}
		return platsTries;
	}

	@Override
	public void insertPlat(Plat plat) {

		plats.add(plat);

	}

	@Override
	public void deleteById(Integer idPlatInt) {
		// TODO Auto-generated method stub

	}

}
