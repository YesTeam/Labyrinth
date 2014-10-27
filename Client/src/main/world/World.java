package world;

import items.Item;

public class World {
	
	private Tile [][][] tiles;
	private Item [][][] items;
	
	public Tile tile (int x, int y, int z){
		return tiles[x][y][z];
	}
	
	public Item item (int x, int y, int z){
		return items[x][y][z];
	}
}
