package main;

import number.NUM_first;
import number.NUM_forth;
import number.NUM_second;
import number.NUM_third;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		
		this.gp = gp;
		
	}
	
	public void setNumber() {
		gp.num[0] = new NUM_first();
		gp.num[0].worldX = 2 * gp.tileSize;
		gp.num[0].worldY = 4 * gp.tileSize;
		
		gp.num[1] = new NUM_second();
		gp.num[1].worldX = 13 * gp.tileSize;
		gp.num[1].worldY = 4 * gp.tileSize;
		
		gp.num[2] = new NUM_third();
		gp.num[2].worldX = 2 * gp.tileSize;
		gp.num[2].worldY = 9 * gp.tileSize;
		
		gp.num[3] = new NUM_forth();
		gp.num[3].worldX = 13 * gp.tileSize;
		gp.num[3].worldY = 9 * gp.tileSize;
	}
	
}


