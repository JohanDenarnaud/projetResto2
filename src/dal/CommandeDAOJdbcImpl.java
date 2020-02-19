package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bo.Commande;

public class CommandeDAOJdbcImpl implements CommandeDAO {
	private Session session;

	public CommandeDAOJdbcImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	@Override
	public List<Commande> selectAllCommandes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCommande(Commande commande) {
		Transaction t = session.beginTransaction();
		session.save(commande);
		t.commit();
	}

}
