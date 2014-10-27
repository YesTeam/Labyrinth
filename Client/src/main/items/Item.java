package items;

import java.awt.Color;

public class Item {
	
	private char glyph;
	private Color color;
	private String name;
	private String appearance;
	private int foodValue;
	private int attackValue;
	private int defenseValue;
	private int thrownAttackValue;
	private int rangedAttackValue;
	
	public char getGlyph() {
		return glyph;
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAppearance() {
		return appearance;
	}
	
	public int getFoodValue() {
		return foodValue;
	}
	
	public int getAttacValue() {
		return attackValue;
	}
	
	public int getDefensevalue() {
		return defenseValue;
	}
	
	public int getThrownAttackvalue() {
		return thrownAttackValue;
	}
	
	public int getRangedAttackValue() {
		return rangedAttackValue;
	}
}
