package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import number.SuperNumber;
import tile.TileMenager;

public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	final int originalTileSize = 16; //16x16 tile
	final int scale = 4;
	
    public final int tileSize = originalTileSize*scale; ///64x64 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol; //1024px
    public final int screenHeight = tileSize*maxScreenRow; //768px
    
    
    int FPS = 60;
    
    TileMenager tileM = new TileMenager(this);
    
    KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public Player player = new Player(this,keyH);
    public SuperNumber num[] = new SuperNumber[10];
    
    //GAME STATE
    
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int questionState = 3;
    public final int endState = 4;

    
    //GAME LOGIC
    public String questions[] = new String [5]; 
    public Questions question1 = new Questions("4 + _ = 5", 1);
    public Questions question2 = new Questions("3 - _ = 0", 3);
    public Questions question3 = new Questions("_ - 1 = 5", 6);
    public Questions question4 = new Questions("8 / _ = 4", 2);
    public Questions question5 = new Questions("2 * _ = 16", 8);
    public int currentQuestion = 0;
    public int previousQuestion = -1;
   
     
    public GamePanel() {
    	this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    	this.setBackground(Color.black);
    	this.setDoubleBuffered(true);
    	this.addKeyListener(keyH);
    	this.setFocusable(true);
    }
    
    public void setupGame() {
    	gameState = titleState;
    }
    
    public void setupNumbers() {
    	questions[0] = question1.question;
    	questions[1] = question2.question;
    	questions[2] = question3.question;
    	questions[3] = question4.question;
    	questions[4] = question5.question;
    	// gameState = playState;
    	ui.showMessage(questions[currentQuestion]);
    	if(currentQuestion == 0) {
    		aSetter.setNumber();
    	} else if (currentQuestion == 1) {
    		aSetter.setNumber2();
    	} else if (currentQuestion == 2) {
    		aSetter.setNumber3();
    	} else if (currentQuestion == 3) {
    		aSetter.setNumber4();
    	} else if (currentQuestion == 4) {
    		aSetter.setNumber5();
    	}
    }
    
    public void startGameThread() {
    	gameThread = new Thread(this);
    	gameThread.start();
    }
   
    

	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS; // 0.01666666 second
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gameThread != null) {
			
			update();
			 
			repaint();
			
			if(previousQuestion != currentQuestion) {
				setupNumbers();
				previousQuestion++;
			}
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void update() {
		if(gameState == playState) {
			player.update();
	}
		if(gameState == pauseState) {
			//nothing
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		if(gameState == titleState) {
			
			ui.draw(g2);
			
		} else {
			tileM.draw(g2);
			player.draw(g2);
			for(int i=0;i<num.length;i++) {
				if(num[i]!= null) {
					num[i].draw(g2, this, num[i].worldX, num[i].worldY);
				}
			}
			ui.draw(g2);
		}
		
		g2.dispose();
	}
	
	public void playSoundEffect(int i) {
		sound.setFile(i);
		sound.play();
	}
	
}
