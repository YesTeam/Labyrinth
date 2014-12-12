package common;

import org.junit.Test;

import junit.framework.TestCase;

public class UserGameInfoTest extends TestCase {

	@Test
	public void testFromJson() {
		UserGameInfo userGameInfo = UserGameInfo.fromJson("{\"userName\":\"test\",\"finished\":false,\"level\":234}");
		assertEquals("test", userGameInfo.getUserName());
		assertEquals(false, userGameInfo.isFinished());
		assertEquals(234, userGameInfo.getLevel());
	}
	
	@Test
	public void testToJson() {
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setId(12);
		userGameInfo.setUserName("alena");
		userGameInfo.setFinished(true);
		assertEquals("{\"id\":12,\"userName\":\"alena\",\"finished\":true,\"level\":0,\"hp\":0,\"mana\":0,\"satiety\":0,\"attack\":0,\"defense\":0,\"vision\":0,\"hpReg\":0.0,\"manaReg\":0.0,\"experience\":0}", userGameInfo.toJson());
		UserGameInfo restoredInfo = UserGameInfo.fromJson(userGameInfo.toJson());
		assertEquals(userGameInfo.getId(), restoredInfo.getId());
		assertEquals(userGameInfo.getUserName(), restoredInfo.getUserName());
		assertEquals(userGameInfo.isFinished(), restoredInfo.isFinished());
	}

}
