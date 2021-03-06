package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import common.UserGameInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestClient {
	
	public static final int PORT = 7777;
    private static final Logger logger = LogManager.getLogger(TestClient.class);

	private Socket client;
	private PrintStream ps;
	private InputStream is;
	
	public TestClient() {
		this(null);
	}
	
	public TestClient(String host) {
        try {
        	if (host == null) {
        		host = InetAddress.getLocalHost().getHostAddress();
        	}
            client = new Socket(host, PORT);
            ps = new PrintStream(new BufferedOutputStream(client.getOutputStream()),true);
            is=new BufferedInputStream(client.getInputStream());
        } catch (UnknownHostException e) {
        	logger.error("Connection error: unknown host.\n");
        } catch (IOException e) {
        	logger.error("Connection error: can't connect to server.\n");
        }
	}
	
	public Responce sendUserGameInfo(UserGameInfo userGameInfo) {
		if (client.isClosed()) {
			return Responce.FAIL;
		}
    	ps.println(RequestType.PUSH_USER_GAME_INFO.toInt());
    	ps.println(userGameInfo.toJson());
    	try {
			return Responce.fromByte(is.read());
		} catch (IOException e) {
			logger.error(e);
			return Responce.FAIL;
		}
	}
	
	public void close() {
		try {
			ps.close();
			is.close();
			client.close();
		} catch (Exception e) {
		}
	}

	public static void main(String[]args) {
		TestClient client = new TestClient();
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setUserName("test");
		userGameInfo.setAttack(12);	
		logger.info(client.sendUserGameInfo(userGameInfo));
	}

}
