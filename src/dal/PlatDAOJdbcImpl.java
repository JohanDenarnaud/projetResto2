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

}
