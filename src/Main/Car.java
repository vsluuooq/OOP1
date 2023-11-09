package Main;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private double x;
    private double y;
    private BufferedImage car;
    private int speed;

    public Car(double x, double y, Game game, String carImage, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;

        try {
            if (carImage.equals("c1")) {
                car = ImageIO.read(new File("res/car1.png"));
            } else if (carImage.equals("c2")) {
                car = ImageIO.read(new File("res/car2.png"));
            }
            else if (carImage.equals("c3")) {
                car = ImageIO.read(new File("res/car3.png"));
            }
            else if (carImage.equals("c4")) {
                car = ImageIO.read(new File("res/car4.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        x += speed;

        if (speed > 0 && x >= 1200) {
            x = -170; // Loop 
        } else if (speed < 0 && x <= -170) {
            x = 1200; // Loop 
        }
    }

    public void render(Graphics g) {
        g.drawImage(car, (int) x, (int) y, null);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    
    public double getWidth() {
		return car.getWidth();
	}
	public double getHeight() {
		return car.getHeight();
	}

	public void setSpeed(int speed) {
	    this.speed = speed;
	}
	
	public Rectangle getBounds() {
	    return new Rectangle((int) x, (int) y, (int) getWidth(), (int) getHeight());
	}

}
