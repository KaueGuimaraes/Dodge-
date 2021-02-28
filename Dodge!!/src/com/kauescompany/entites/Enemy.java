package com.kauescompany.entites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.kauescompany.main.Game;

public class Enemy extends Entity {
	
	private int direction;
	private int speed;
	private int rand;
	private boolean value;
	
	public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		if(new Random().nextInt(100) < 80) {
			rand = new Random().nextInt(100);
			
			if(rand < 25) {
				//Baixo
				this.y = new Random().nextInt(Game.HEIGHT);
				this.x = new Random().nextInt(105 / Game.SCALE);
				
				rand = new Random().nextInt(3);
				if(rand == 0) {
					this.direction = 1;
				}else if(rand == 1) {
					this.direction = 5;
				}else if(rand == 2) {
					this.direction = 7;
				}
			}else if(rand >= 25 && rand < 50) {
				//Cima
				this.y = new Random().nextInt(105 / Game.SCALE);
				this.x = new Random().nextInt(Game.WIDTH * Game.SCALE);
				
				rand = new Random().nextInt(3);
				if(rand == 0) {
					this.direction = 0;
				}else if(rand == 1) {
					this.direction = 4;
				}else if(rand == 2) {
					this.direction = 6;
				}
			}else if(rand >= 50 && rand < 75) {
				//Direita
				this.y = new Random().nextInt(Game.HEIGHT * Game.SCALE);
				
				this.x = new Random().nextInt(Game.WIDTH * Game.SCALE);
				while(this.x <= Game.WIDTH - (105 / Game.SCALE)) {
					this.x = new Random().nextInt(Game.WIDTH * Game.SCALE);
				}
				
				rand = new Random().nextInt(3);
				if(rand == 0) {
					this.direction = 2;
				}else if(rand == 1) {
					this.direction = 4;
				}else if(rand == 2) {
					this.direction = 5;
				}
			}else if(rand >= 75 && rand < 100) {
				//Esquerda
				this.y = new Random().nextInt(Game.HEIGHT * Game.SCALE);
				while(this.y <= Game.HEIGHT - (105 / Game.SCALE)) {
					this.y = new Random().nextInt(Game.HEIGHT * Game.SCALE);
				}
				
				this.x = new Random().nextInt(Game.WIDTH * Game.SCALE);
				
				rand = new Random().nextInt(3);
				if(rand == 0) {
					this.direction = 3;
				}else if(rand == 1) {
					this.direction = 6;
				}else if(rand == 2) {
					this.direction = 7;
				}
			}
			
		}else {
			this.y = new Random().nextInt(Game.HEIGHT);
			this.x = new Random().nextInt(Game.WIDTH);
		}/*else {
			this.y = Game.player.getX() - Random().nextInt(45);
			this.x = Game.player.getY() - Random().nextInt(45);
		}*/
		
		while(this.width < 30) {
			this.width = new Random().nextInt(65);
		}
		
		while(this.height < 30){
			this.height = new Random().nextInt(65);
		}
		
		if(new Random().nextInt(100) < 50) {
			value = true;
		}else {
			value = false;
		}
		
		if(Game.level == 2) {
			while(this.speed < 2) {
				this.speed = new Random().nextInt(3);
			}
		}else if(Game.level >= 4) {
				while(this.speed < 2) {
					this.speed = new Random().nextInt(4);
				}
			}else {
			while(this.speed < 1) {
				this.speed = new Random().nextInt(3);
			}
		}
		
		//this.direction = new Random().nextInt(8);
		
	}
	
	private Random Random() {
		// TODO Auto-generated method stub
		return null;
	}

	public void tick() {
		if(direction == 0) {
			//Baixo
			
			y += speed;
		}
		
		else if(direction == 1) {
			//Cima
			
			y -= speed;
		}
		
		else if(direction == 2) {
			//Direita
			
			x += speed;
		}
		
		else if(direction == 3) {
			//Esquerda
			
			x -= speed;
		}
		
		else if(direction == 4) {
			//Baixo Direita
			
			y += speed;
			x += speed;
		}
		
		else if(direction == 5) {
			//Cima Direita
			
			y -= speed;
			x += speed;
		}
		
		else if(direction == 6) {
			//Baixo Esquerda
			
			y += speed;
			x -= speed;
		}
		
		else if(direction == 7) {
			//Cima Esquerda
			
			y -= speed;
			x -= speed;
		}
		
		if(y < 0 || y > Game.HEIGHT * Game.SCALE
			|| x < 0 || x > Game.WIDTH * Game.SCALE) {
			Game.enemies.remove(this);
			
			System.out.println("ENIMIGO REMOVIDO!!!");
		}
	}
	
	public void render(Graphics g) {
		if(value) {
			g.setColor(Color.GREEN);
			
		}else {
			g.setColor(Color.RED);
		}
		
		g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.setFont(new Font("arial", Font.BOLD, this.getWidth() + this.getHeight() / 2));
		
		if(value) {
			g.drawString("1", this.getX(), this.getY() + (10 * Game.SCALE));
		}else {
			g.drawString("0", this.getX(), this.getY() + (10 * Game.SCALE));
		}
	}
	
}
