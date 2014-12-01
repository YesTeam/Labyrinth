package server;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import common.UserGameInfo;

public class ServerTest extends TestCase {

	private final Server server = new Server();
    private static final Logger logger = LogManager.getLogger(ServerTest.class);
	
	@Test
	public void testConnect() {
		server.start();
		Client client = new Client();
		WrongClient wClient = WrongClient.getInstance();
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setUserName("test");
		userGameInfo.setAttack(12);
		assertEquals(Responce.OK, client.sendUserGameInfo(userGameInfo));
		assertEquals(Responce.FAIL, wClient.sendUserGameInfo(userGameInfo));
	}
	
	public void testBigClientsNumber() {
		server.start();
		int i = 0;
		List<Client> clients = new ArrayList<>();
		while (true) {
			clients.add(new Client());
			i++;
			logger.info(i);
		}
	}

}
