package client;

import java.util.UUID;

import main.UserGameInfo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ClientTest extends Assert {

	@Ignore
	@Test
	public void testSendUserGameInfo() {
		Client client = new Client();
		UserGameInfo uInfo = new UserGameInfo();
		uInfo.setUserName(UUID.randomUUID().toString());
		assertEquals(Responce.OK, client.sendUserGameInfo(uInfo));
	}

}
