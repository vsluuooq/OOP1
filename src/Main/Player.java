package Main;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;


public class Player {
	
	private double x;
	private double y;
	private double velX = 0;
	private double velY = 0;
	
	private Game game;
	private Controller con;

	
	private BufferedImage player;
	private BufferedImage win;
	
	private int collisionCount = 0;
	
	public Player(Game game) {
        this.game = game;
    }
	
	public Player(double x,double y,Game game) {
		this.x=x;
		this.y=y;
		
		try {
            player = ImageIO.read(new File("res/kiki1.png"));  
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void tick() {
	    x += velX;
	    y += velY;

	    if (x <= 10) {
	        x = 10;
	    }
	    if (x >= 1140) {
	        x = 1140;
	    }
	    if (y <= (-100)) {
	        y = (-100);
	    }
	    if (y >= 620) {
	        y = 620;
	    }

	    // WIN
	    if (y <= (-100) && x == Game.WIDTH / 2) {
            y = (-100);
            ((Controller) game.getController()).stopCars();
            y=-100;
            displayYouWin();
        }
	    
	}
	
	private void displayYouWin() {
	    Graphics g = game.getGraphics(); 
	    Font font = new Font("Arial", Font.BOLD, 30);
	    g.setFont(font);

	    g.setColor(Color.RED);

	    int messageX = Game.WIDTH / 2 - 50; 
	    int messageY = Game.HEIGHT / 2;
	    g.drawString("You Win", messageX, messageY);
	}

	
	
	public void render(Graphics g) {
		g.drawImage(player, (int)x, (int)y,null);
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x=x;
	}
	public void setVelX(double velX) {
		this.velX=velX;
	}
	public void setVelY(double velY) {
		this.velY=velY;
	}
	
	public double getWidth() {
		return player.getWidth();
	}
	public double getHeight() {
		return player.getHeight();
	}
	

	
}
