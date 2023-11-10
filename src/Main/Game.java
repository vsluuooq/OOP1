package Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Game extends Canvas implements Runnable{
	
	
	public Game() {
	    super();
	}

//	private Menu menu; 
	
	public static final long serialVersionUID = 1L;
	public static final int WIDTH = 1200;
	public static final int HEIGTH = 720;
	public final String TITLE = "KIKI'S WAY HOME";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGTH,BufferedImage.TYPE_INT_RGB);
	private BufferedImage Kiki = null;
	private BufferedImage carObj = null;
	private BufferedImage background = null;
	private BufferedImage win = null;
	
	
	private Controller c;
	private Player p;
	
	private List<Car> cars = new ArrayList<>();
	
	
	public void init() {
		requestFocus();
		this.addKeyListener(new KeyInput(this));
		
		
		BufferedImageLoader loader = new BufferedImageLoader();
		background = loader.loadImage("/road1.png");
		win= loader.loadImage("/win.png");
		
		
		c = new Controller(this);
		p = new Player(570, 620,this);
//		menu = new Menu();
		
	}
	
	private synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amoutOfTicks = 60.0;
		double ns = 1000000000/amoutOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				delta--;
			}
			render();
			if(System.currentTimeMillis()-timer>1000) {
				timer += 1000;
			}
		}
		stop();
	}
	
	private void tick() {
		c.tick();
		p.tick();
		
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this);
		g.drawImage(background, 0, 0, null);
		
		c.render(g);
		p.render(g);
		g.dispose();
		bs.show();
				
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_D) {
			p.setVelX(5);
		}
		if(key == KeyEvent.VK_A) {
			p.setVelX(-5);
		}
		if(key == KeyEvent.VK_S) {
			p.setVelY(5);
		}
		if(key == KeyEvent.VK_W) {
			p.setVelY(-5);
		}	

		
	}
	
	public void keyReleased(KeyEvent e) {
	    int key = e.getKeyCode();
	    if (key == KeyEvent.VK_D || key == KeyEvent.VK_A) {
	        p.setVelX(0); 
	    }
	    if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
	        p.setVelY(0);
	    }
	}

	

	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		game.setMaximumSize(new Dimension(WIDTH,HEIGTH));
		game.setMinimumSize(new Dimension(WIDTH,HEIGTH));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
	
	public BufferedImage getKiki() {
		return Kiki;
	}
	
	public BufferedImage getCarObj() {
		return carObj;
	}

	public Object getController() {
		return null;
	}
	
	public List<Car> getCars() {
        return cars;
    }
	
	public void win() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(win, 0, 0, null);
		
		c.render(g);
		p.render(g);
		g.dispose();
		bs.show();
	}
}
