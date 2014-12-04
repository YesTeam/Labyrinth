package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import common.UserGameInfo;

public class DAOImpl implements DAO {

	private final SessionFactory sessionFactory;
	
	DAOImpl() {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
    	        .applySettings(configuration.getProperties()).build();
    	sessionFactory = configuration
    	        .buildSessionFactory(serviceRegistry);
	}
	
	@Override
	public void saveGameInfo(UserGameInfo userGameInfo) {
		getSession().beginTransaction();
		getSession().persist(userGameInfo);
		getSession().getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGameInfo> getUserGameInfo(String userName) {
		getSession().beginTransaction();
		List<UserGameInfo> retValue = getSession().createCriteria(UserGameInfo.class).add(Restrictions.eq("userName", userName)).list();
		getSession().getTransaction().commit();
		return retValue;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
