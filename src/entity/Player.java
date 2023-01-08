package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.AssetSetter;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    
	GamePanel gp;
	KeyHandler keyH;
	public int points = 0;
	public AssetSetter aSetter = new AssetSetter(gp);
	
	public Player (GamePanel gp, KeyHandler keyH) {
		this.gp =gp;
		this.keyH = keyH;
	    int answerValue = 999;
	    
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues () {
		x = 475;
		y = 400;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true 
		|| keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";
			} else if (keyH.downPressed == true) {
				direction = "down";
			} else if (keyH.leftPressed == true) {
				direction = "left";
			} else if (keyH.rightPressed == true) {
				direction = "right";
			}
			
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			int numIndex = gp.cChecker.checkObject(this, true);
			pickUpNumber(numIndex);
			
			if(collisionOn == false) {
				switch(direction) {
				case "up":
					y -= speed;
					break;
				case "down":
					y += speed;
					break;
				case "left":
					x -= speed;
					break;
				case "right":
					x += speed;
					break;
				}
			}
			
			spriteCounter++;
			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if (spriteNum ==2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
			
		}
		
		
	}
	
	public void checkAnswer (int answerValue) {
		if(gp.currentQuestion == 0) {
			if(answerValue == gp.question1.solution) {
				System.out.println("Poprawna odpowiedz!");
				points++;
				gp.currentQuestion++;
				System.out.println(gp.currentQuestion);
				setDefaultValues();
			} else {
				System.out.println("Niepoprawna odpowiedz!");
				points--;
				gp.currentQuestion++;
				setDefaultValues();
			}
		} else if (gp.currentQuestion == 1) {
			if(answerValue == gp.question2.solution) {
				System.out.println("Poprawna odpowiedz!");
				points++;
				gp.currentQuestion++;
				System.out.println(gp.currentQuestion);
				setDefaultValues();
			} else {
				System.out.println("Niepoprawna odpowiedz!");
				points--;
				gp.currentQuestion++;
				setDefaultValues();
			}
		} else if (gp.currentQuestion == 2) {
			if(answerValue == gp.question3.solution) {
				System.out.println("Poprawna odpowiedz!");
				points++;
				gp.currentQuestion++;
				System.out.println(gp.currentQuestion);
				setDefaultValues();
			} else {
				System.out.println("Niepoprawna odpowiedz!");
				points--;
				gp.currentQuestion++;
				setDefaultValues();
			}
	}   else if (gp.currentQuestion == 3) {
		if(answerValue == gp.question4.solution) {
			System.out.println("Poprawna odpowiedz!");
			points++;
			gp.currentQuestion++;
			System.out.println(gp.currentQuestion);
			setDefaultValues();
		} else {
			System.out.println("Niepoprawna odpowiedz!");
			points--;
			gp.currentQuestion++;
			setDefaultValues();
		}
}       else if (gp.currentQuestion == 4) {
	if(answerValue == gp.question5.solution) {
		System.out.println("Poprawna odpowiedz!");
		points++;
		gp.currentQuestion++;
		System.out.println(gp.currentQuestion);
		setDefaultValues();
	} else {
		System.out.println("Niepoprawna odpowiedz!");
		points--;
		gp.currentQuestion++;
		setDefaultValues();
	}
}
		if(gp.currentQuestion == 5) {
			gp.gameState = gp.endState;
		}
	}
	
	public void pickUpNumber (int i) {
		if(i != 999) {
			String numberName = gp.num[i].name;
			int answerValue;
			switch(numberName) {
			case "First":
				gp.playSoundEffect(0);
				answerValue = 0;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Second":
				gp.playSoundEffect(0);
				answerValue = 1;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Third":
				gp.playSoundEffect(0);
				answerValue = 2;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Forth":
				gp.playSoundEffect(0);
				answerValue = 3;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Fifth":
				gp.playSoundEffect(0);
				answerValue = 4;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Sixth":
				gp.playSoundEffect(0);
				answerValue = 5;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Seventh":
				gp.playSoundEffect(0);
				answerValue = 6;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Eighth":
				gp.playSoundEffect(0);
				answerValue = 7;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			case "Ninth":
				gp.playSoundEffect(0);
				answerValue = 8;
				checkAnswer(answerValue);
				gp.num[i] = null;
				System.out.println(answerValue);
				break;
			}
		}
	};
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum ==1) {
			image = up1;
			}
			if(spriteNum ==2) {
			image = up2;
			}
			break;
		case "down":
			if(spriteNum ==1) {
			image = down1;
			}
			if(spriteNum ==2) {
			image = down2;
			}
			break;
		case "left":
			if(spriteNum ==1) {
			image = left1;
			}
			if(spriteNum ==2) {
			image = left2;
			}
			break;
		case "right":
			if(spriteNum ==1) {
			image = right1;
			}
			if(spriteNum ==2) {
			image = right2;
			}
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
		
	}
} 

