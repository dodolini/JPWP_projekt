package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

	GamePanel gp;
	Font arial_40;
	Font arial_80;
	public boolean messageOn = false;
	public String message = "";
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_80 = new Font("Arial", Font.PLAIN, 80);
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw (Graphics2D g2) {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("Punkty: "+gp.player.points, 60, 48);
		
		//MESSAGE
		if(messageOn == true) {
			g2.setFont(arial_80);
			g2.drawString(message, 330, 150);
		}
		
	}
}
