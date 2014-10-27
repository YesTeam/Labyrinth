package entities;

import java.awt.Color;
import world.World;
import items.Item;

public class Creature {
	private World world;
	
	public int x;
	public int y;
	public int z;
	
	private char glyph;	
	private int maxHp;
	private int hp;
	private int attackValue;
	private int defenseValue;
	private int visionRadius;
	private String name;
	private int maxFood;
	private int food;
	private Item weapon;
	private Item armor;
	private int xp;
	private int level;
	private int maxMana;
	private int regenHpCooldown;
	private int regenHpPer1000;
	private int mana;
	private int regenManaCooldown;
	private int regenManaPer1000;
	private String causeOfDeath;
	private Color color;
	
	public char glyph() {
		return glyph;
	}
	
	public Color color() {
		return color;
	}
	
	public int maxHp() {
		return maxHp;
	}
	
	public int hp() {
		return hp;
	}
	
	public String name() {
		return name;
	}
	
	public int maxFood() {
		return maxFood;
	}
	
	public int food() {
		return food;
	}
	
	public Item weapon() {
		return weapon;
	}
	
	public Item armor() {
		return armor;
	}
	
	public int xp() {
		return xp;
	}
	
	public int level() {
		return level;
	}
	
	public int maxMana() {
		return maxMana;
	}
	
	public int mana() {
		return mana;
	}
	
	public String causeOfDeath() {
		return causeOfDeath;
	}
}
