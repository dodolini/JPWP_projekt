package main;

import number.NUM_eighth;
import number.NUM_fifth;
import number.NUM_first;
import number.NUM_forth;
import number.NUM_ninth;
import number.NUM_second;
import number.NUM_seventh;
import number.NUM_sixth;
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
	
	public void setNumber2() {
		gp.num[0] = new NUM_fifth();
		gp.num[0].worldX = 2 * gp.tileSize;
		gp.num[0].worldY = 4 * gp.tileSize;
		
		gp.num[1] = new NUM_ninth();
		gp.num[1].worldX = 13 * gp.tileSize;
		gp.num[1].worldY = 4 * gp.tileSize;
		
		gp.num[2] = new NUM_third();
		gp.num[2].worldX = 2 * gp.tileSize;
		gp.num[2].worldY = 9 * gp.tileSize;
		
		gp.num[3] = new NUM_forth();
		gp.num[3].worldX = 13 * gp.tileSize;
		gp.num[3].worldY = 9 * gp.tileSize;
	}
	
	public void setNumber3() {
		gp.num[0] = new NUM_sixth();
		gp.num[0].worldX = 2 * gp.tileSize;
		gp.num[0].worldY = 4 * gp.tileSize;
		
		gp.num[1] = new NUM_ninth();
		gp.num[1].worldX = 13 * gp.tileSize;
		gp.num[1].worldY = 4 * gp.tileSize;
		
		gp.num[2] = new NUM_seventh();
		gp.num[2].worldX = 2 * gp.tileSize;
		gp.num[2].worldY = 9 * gp.tileSize;
		
		gp.num[3] = new NUM_forth();
		gp.num[3].worldX = 13 * gp.tileSize;
		gp.num[3].worldY = 9 * gp.tileSize;
	}
	
	public void setNumber4() {
		gp.num[0] = new NUM_third();
		gp.num[0].worldX = 2 * gp.tileSize;
		gp.num[0].worldY = 4 * gp.tileSize;
		
		gp.num[1] = new NUM_eighth();
		gp.num[1].worldX = 13 * gp.tileSize;
		gp.num[1].worldY = 4 * gp.tileSize;
		
		gp.num[2] = new NUM_second();
		gp.num[2].worldX = 2 * gp.tileSize;
		gp.num[2].worldY = 9 * gp.tileSize;
		
		gp.num[3] = new NUM_fifth();
		gp.num[3].worldX = 13 * gp.tileSize;
		gp.num[3].worldY = 9 * gp.tileSize;
	}
	
	public void setNumber5() {
		gp.num[0] = new NUM_fifth();
		gp.num[0].worldX = 2 * gp.tileSize;
		gp.num[0].worldY = 4 * gp.tileSize;
		
		gp.num[1] = new NUM_ninth();
		gp.num[1].worldX = 13 * gp.tileSize;
		gp.num[1].worldY = 4 * gp.tileSize;
		
		gp.num[2] = new NUM_first();
		gp.num[2].worldX = 2 * gp.tileSize;
		gp.num[2].worldY = 9 * gp.tileSize;
		
		gp.num[3] = new NUM_sixth();
		gp.num[3].worldX = 13 * gp.tileSize;
		gp.num[3].worldY = 9 * gp.tileSize;
	}
	
}


