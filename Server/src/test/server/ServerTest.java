package server;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import common.UserGameInfo;

public class ServerTest extends Assert {
	
	private final Server server = new Server();
    private static final Logger logger = LogManager.getLogger(ServerTest.class);

    @Before
	public void startServer() {
		server.start();
	}
	
	@Test
	public void testConnect() {
		TestClient client = new TestClient();
		WrongTestClient wClient = WrongTestClient.getInstance();
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setUserName(UUID.randomUUID().toString());
		userGameInfo.setAttack(12);
		assertEquals(Responce.OK, client.sendUserGameInfo(userGameInfo));
		assertEquals(Responce.FAIL, wClient.sendUserGameInfo(userGameInfo));
		client.close();
		wClient.close();
	}
	
	public void testBigClientsNumber() {
		int i = 0;
		List<TestClient> clients = new ArrayList<>();
		while (i < 50) {
			clients.add(new TestClient());
			i++;
			logger.info(i);
		}
		for (TestClient client : clients) {
			client.close();
		}
	}
	
}
