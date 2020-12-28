package com.kauescompany.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.kauescompany.entites.Enemy;
import com.kauescompany.entites.Player;

public class Game extends Canvas implements Runnable, KeyListener{
	
	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final int SCALE = 5;
	
	public static List<Enemy> enemies;
	
	private BufferedImage image;
	
	public static Player player;
	
	public static int cont;
	
	public Game() {
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		initFrame();
		
		//inicializando objetos
		
		enemies = new ArrayList<Enemy>();
		player = new Player(10, 10, 20, 20, null);
	}
	
	public void initFrame() {
		frame = new JFrame("Dodge!!");
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		Game game = new Game();
		game.start();
	}
	
	public void tick() {
		/*Lógica das Entidades*/
		
		player.tick();
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}
		
		/**/
		
		//cont++;
		cont = 1000;
		if(cont >= (60 * 2)) {
			if(new Random().nextInt(100) < 10) {
				enemies.add(new Enemy(new Random().nextInt(WIDTH * SCALE), new Random().nextInt(HEIGHT * SCALE),
							0, 0, null));
			}
			
			//cont = 0;
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		
		/*RENDERIZAÇÃO DO JOGO*/
		
		player.render(g);
		
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}
		
		/***/
		
		g.dispose();
		g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
		
		bs.show();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int frames = 0;
		double timer = System.currentTimeMillis();
		
		requestFocus();
		
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				frames++;
				delta--;
			}
			
			if(System.currentTimeMillis() - timer >= 1000) {
				System.out.println("FPS "+frames);
				frames = 0;
				timer += 1000;
			}
		}
		
		stop();
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W
			|| e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S
			|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D
			|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A
			|| e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W
			|| e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S
			|| e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_D
			|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A
			|| e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	}
	
}
