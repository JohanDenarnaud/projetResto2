package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import bo.Plat;

public class PlatDAOJdbcImpl implements PlatDAO {
	private Session session;
	List<Plat> plats;

	public PlatDAOJdbcImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	@Override
	public List<Plat> selectAll() {
		return session.createQuery("from Plat").list();

	}

	@Override
	public List<Plat> selectByCategorie(String string) {

		Query query = session.createQuery("from Plat where categorie = : CATEGORIE");
		query.setParameter("CATEGORIE", string);
		List result = query.list();

		return result;
	}

	@Override
	public void insertPlat(Plat plat) {
		Transaction t = session.beginTransaction();
		session.save(plat);
		t.commit();
	}

	@Override
	public void update(Plat plat) {

		Plat platAModifier = selectById(plat.getId());
		platAModifier.setNom(plat.getNom());
		platAModifier.setPrixDeReviens(plat.getPrixDeReviens());
		platAModifier.setPrixDeVente(plat.getPrixDeVente());
		platAModifier.setStock(plat.getStock());
		platAModifier.setCategorie(plat.getCategorie());

		Transaction t = session.beginTransaction();
		session.update(platAModifier);
		t.commit();

	}

	@Override
	public Plat selectById(Integer idAsInt) {
		return (Plat) session.load(Plat.class, idAsInt);
	}

	@Override
	public void deleteById(Integer idPlatInt) {
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete Plat where id = :ID");
		query.setParameter("ID", idPlatInt);

		query.executeUpdate();
		t.commit();

	}
}