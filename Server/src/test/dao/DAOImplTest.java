package dao;

import org.junit.Test;

import common.UserGameInfo;

import junit.framework.TestCase;

public class DAOImplTest extends TestCase {

	@Test
	public void testSaveGameInfo() {
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setAttack(12);
		userGameInfo.setUserName("dima");
		DAO dao = DAOFactory.getDAO();
		dao.saveGameInfo(userGameInfo);
	}

	@Test
	public void testGetUserGameInfo() {
	}

}
