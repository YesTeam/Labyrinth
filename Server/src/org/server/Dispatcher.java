package server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dispatcher implements Runnable {

	private final Socket socket;
	private static final Logger logger = LogManager.getLogger(Dispatcher.class);
	private String name;
	
	public Dispatcher(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		name = socket.getInetAddress().getHostName() + ":" + socket.getPort();
		logger.info(name + " connected");
		try (Scanner scn = new Scanner(new InputStreamReader(socket.getInputStream()));){
			while (scn.hasNextLine()) {
				try {
					int type = Integer.parseInt(scn.nextLine());
					String messString = scn.nextLine();
					Processor processor = Processors.getProcessor(RequestType.fromInt(type));
					if (processor == null) {
						logger.error(name + ": no processor found for " + type + " request type");
						Responser.sendFail(socket);
						return;
					}
					processor.process(messString);
					logger.info(name + ": message processed: " + messString);
					Responser.sendOk(socket);
				} catch (Exception e) {
					logger.error(name, e);
					Responser.sendFail(socket);
				}
			}
		} catch (IOException e) {
			logger.error(name, e);
		} finally {
			logger.info(name + " disconnected");
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}

}
