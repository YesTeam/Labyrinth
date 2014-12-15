package screens;

import java.awt.event.KeyEvent;
import java.util.Random;

import main.UserGameInfo;
import asciiPanel.AsciiPanel;
import client.Client;
import entities.Creature;

public class LoseScreen implements Screen {
	private Creature player;
	private static final Random RANDOM = new Random();
	public LoseScreen(Creature player){
		this.player = player;
		Client client = Client.getInstance();
		UserGameInfo uInfo = new UserGameInfo();
		uInfo.setAttack(player.attackValue());
		uInfo.setDefense(player.defenseValue());
		uInfo.setFinished(false);
		uInfo.setExperience(player.xp());
		uInfo.setHp(player.hp());
		uInfo.setHpReg(player.hpRegenerationRate());
		uInfo.setLevel(player.level());
		uInfo.setMana(player.mana());
		uInfo.setManaReg(player.manaRegenRate());
		uInfo.setSatiety(player.food());
		uInfo.setUserName(String.valueOf(RANDOM.nextInt(1000000)));
		uInfo.setVision(player.visionRadius());
		client.sendUserGameInfo(uInfo);
	}
	
	//@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.writeCenter("R.I.P.", 3);
		terminal.writeCenter(player.causeOfDeath(), 5);
		terminal.writeCenter("-- press [enter] to restart --", 22);
	}

	//@Override
	public Screen respondToUserInput(KeyEvent key) {
		return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
	}
}
