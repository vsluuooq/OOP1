//package Main;
//
//
//import java.awt.*;
//import java.awt.event.*;
//
//import javax.swing.*;
//
//
//
//
//
//public class Menu extends JFrame{
//	
//	private Graphics screenGraphic;
//	
//	public ImageIcon exitButtonEntered = new ImageIcon("res/exitButton2.png");
//	public ImageIcon exitButtonBasic = new ImageIcon("res/exitButton1.png");
//	public ImageIcon startButtonEntered = new ImageIcon("res/startButton2.png");
//	public ImageIcon startButtonBasic = new ImageIcon("res/startButton1.png");
//	public JLabel menuBar = new JLabel(new ImageIcon("res/menubar.png"));
//	
//	private ImageIcon bgim = new ImageIcon("res/introbg.png");
//	
//	public JButton exitButton = new JButton(exitButtonBasic);
//	public JButton startButton = new JButton(startButtonBasic);
//	private JLabel bgimg = new JLabel(bgim);
//	
//	
//	private int mouseX,mouseY;
//	public Menu() {
//		setUndecorated(true);
//		
//	}
//	;
//	public void render(Graphics g) {
//		
//		
//		setSize(Game.WIDTH,Game.HEIGTH);
//		setResizable(false);
//		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setVisible(true);
//		setBackground(new Color(0,0,0,0));
//		setLayout(null);
//		
//		bgimg.setBounds(0,0,Game.WIDTH,Game.HEIGTH);
////		add(bgimg);
//		
//		
//		
//		//EXIT BUTTON
//		exitButton.setBounds(20,630,155,76);
//		exitButton.setBorderPainted(false);
//		exitButton.setContentAreaFilled(false);
//		exitButton.setFocusPainted(false);
//		exitButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				exitButton.setIcon(exitButtonEntered);
//				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				exitButton.setIcon(exitButtonBasic);
//				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//				System.exit(0);
//			}
//		});
//		add(exitButton);
//		
//		//START BUTTON
//		startButton.setBounds(180,630,155,76);
//		startButton.setBorderPainted(false);
//		startButton.setContentAreaFilled(false);
//		startButton.setFocusPainted(false);
//		startButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				startButton.setIcon(startButtonEntered);
//				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				startButton.setIcon(startButtonBasic);
//				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//			}
//			@Override
//			public void mousePressed(MouseEvent e) {
//				startButton.setVisible(false);
//				Game.state = Game.STATE.GAME;
//				
//				
//			} 
//		});
//		add(startButton);
//		
//		menuBar.setBounds(0,0,1200,30);
//		menuBar.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				mouseX = e.getX();
//				mouseY = e.getY();
//			}
//		});
//		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				int x = e.getXOnScreen();
//				int y = e.getYOnScreen();
//				setLocation(x-mouseX,y-mouseY);
//			}
//		});
//		add(menuBar);
//		
//		
//		
//	}
//
//}
