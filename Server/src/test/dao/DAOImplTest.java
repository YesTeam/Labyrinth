package dao;

import org.junit.Test;

import common.UserGameInfo;

import junit.framework.TestCase;

public class DAOImplTest extends TestCase {

	@Test
	public void testSaveGameInfo() {
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setAttack(11);
		userGameInfo.setExperience(1);
		userGameInfo.setUserName("dma");
		DAO dao = DAOFactory.getDAO();
		dao.saveGameInfo(userGameInfo);
		userGameInfo.setId(0);
		dao.saveGameInfo(userGameInfo);
	}

	@Test
	public void testGetUserGameInfo() {
		DAO dao = DAOFactory.getDAO();
		System.out.println(dao.getUserGameInfo("dma"));
	}

}
