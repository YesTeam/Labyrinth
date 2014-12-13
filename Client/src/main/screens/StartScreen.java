package screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import java.io.IOException;

public class StartScreen implements Screen {

	//@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("INFINITE CAVY STORY", 10);
		terminal.writeCenter("-- press [enter] to start --", 32);
	}

	//@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
