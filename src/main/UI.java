package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

	GamePanel gp;
	Font arial_40;
	Font arial_60;
	Font arial_80;
	Font arial_96f;
	public boolean messageOn = false;
	public String message = "";
	public int commandNum = 0;
	
	public UI(GamePanel gp) {
		this.gp = gp;
		
		arial_40 = new Font("Arial", Font.PLAIN, 40);
		arial_60 = new Font("Arial", Font.PLAIN, 60);
		arial_80 = new Font("Arial", Font.PLAIN, 80);
		arial_96f = new Font("Arial", Font.BOLD, 90);
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void drawTitleScreen (Graphics2D g2) {
		
		g2.setColor(new Color(70,120,80));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		//TITLE NAME
		g2.setFont(arial_96f);
		String text = "Szybka Matematyka !";
		int x = (gp.screenWidth/2)-450;
		int y = gp.tileSize*3;
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		
		//MENU
		g2.setFont(arial_60);
		text = "GRAJ";
		x = (gp.screenWidth/2)-80;
		y = gp.tileSize*6;
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		text = "WYJDŹ";
		x = (gp.screenWidth/2)-100;
		y = gp.tileSize*8;
		g2.setColor(Color.black);
		g2.drawString(text, x+5, y+5);
		
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-gp.tileSize, y);
		}
		
	}
	
	public void drawPauseScreen(Graphics2D g2) {
		g2.setFont(arial_80);
		String text = "PAUZA";
		int x = (gp.screenWidth/2)-130;
		int y = gp.screenHeight/2;
		g2.setColor(Color.white);
		
		g2.drawString(text, x, y);
	}
	
	public void drawEndScreen(Graphics2D g2) {
		g2.setFont(arial_80);
		String text = "KONIEC GRY";
		int x = (gp.screenWidth/2)-260;
		int y = gp.tileSize*4;
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
		text = "Zdobyte punkty: "+ gp.player.points;
		x = (gp.screenWidth/2)-300;
		y = gp.tileSize*6;
		g2.setColor(Color.white);
		g2.drawString(text, x, y);
	}
	
	public void draw (Graphics2D g2) {
		
		if(messageOn == true && gp.gameState == gp.playState) {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawString("Punkty: "+gp.player.points, 60, 48);
		}
		
		//MESSAGE
		if(messageOn == true && gp.gameState == gp.playState) {
			g2.setFont(arial_80);
			g2.drawString(message, 330, 150);
		}
		
		if(gp.gameState == gp.titleState) {
			drawTitleScreen(g2);
		}
		
		if(gp.gameState == gp.pauseState) {
		    drawPauseScreen(g2);
		}
		
		if(gp.gameState == gp.endState) {
		    drawEndScreen(g2);
		}
		
		
	}
}
