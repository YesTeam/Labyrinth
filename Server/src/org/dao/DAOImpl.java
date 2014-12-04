package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.UserGameInfo;

public class DAOImpl implements DAO {

	private static final Logger logger = LogManager.getLogger(DAOImpl.class);
	private static final Session SESSION = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public DAOImpl() {
	}
	
	@Override
	public void saveGameInfo(UserGameInfo userGameInfo) {
		Transaction transaction = SESSION.beginTransaction();
		SESSION.persist(userGameInfo);
		transaction.commit();
	}

	@Override
	public List<UserGameInfo> getUserGameInfo(String userName) {
		// TODO Auto-generated method stub
		logger.warn("dao.DAOImpl.getUserGameInfo(String userName) is not implemented");
		return null;
	}

}
