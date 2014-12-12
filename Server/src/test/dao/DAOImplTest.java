package dao;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import common.UserGameInfo;

public class DAOImplTest extends Assert {
	
	@Test
	public void testSaveGameInfo() {
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setAttack(11);
		userGameInfo.setExperience(1);
		userGameInfo.setUserName("dma");
		DAO dao = DAOFactory.getDAO();
		dao.saveGameInfo(userGameInfo);
		UserGameInfo restoredInfo = dao.getUserGameInfoById(userGameInfo.getId());
		assertEquals(userGameInfo.getId(), restoredInfo.getId());
		assertEquals(userGameInfo.getAttack(), restoredInfo.getAttack());
		assertEquals(userGameInfo.getExperience(), restoredInfo.getExperience());
		assertEquals(userGameInfo.getUserName(), restoredInfo.getUserName());
		dao.deleteUserGameInfo(userGameInfo.getId());
	}

	@Test
	public void testGetUserGameInfo() {
		DAO dao = DAOFactory.getDAO();
		UserGameInfo userGameInfo1 = new UserGameInfo();
		userGameInfo1.setUserName(UUID.randomUUID().toString());
		dao.saveGameInfo(userGameInfo1);
		UserGameInfo userGameInfo2 = new UserGameInfo();
		userGameInfo2.setUserName(userGameInfo1.getUserName());
		dao.saveGameInfo(userGameInfo2);
		assertEquals(2, dao.getUserGameInfo(userGameInfo1.getUserName()).size());
		dao.deleteUserGameInfo(userGameInfo1.getId());
		dao.deleteUserGameInfo(userGameInfo2.getId());
	}

}
