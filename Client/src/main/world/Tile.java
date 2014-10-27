package world;

import java.awt.Color;


public enum Tile {
	FLOOR(),
    WALL(),
    BOUNDS(),
    STAIRS_DOWN(),
    STAIRS_UP(),
    UNKNOWN();
	
	private char glyph;
	private Color color;
	private String description;
	
	public char glyph(){
		return glyph;
	}
	
	public Color color(){
		return color;
	}
	
	public String description(){
		return description;
	}
}
