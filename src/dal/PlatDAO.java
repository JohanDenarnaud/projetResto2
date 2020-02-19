package dal;

import java.util.List;

import bo.Plat;

public interface PlatDAO {

	public List<Plat> selectAll();

	public List<Plat> selectByCategorie(String string);

}
