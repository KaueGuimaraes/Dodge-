package com.kauescompany.entites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.kauescompany.main.Game;

public class Enemy extends Entity {
	
	private int direction;
	private int speed;
	
	public Enemy(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
		while(this.width < 30) {
			this.width = new Random().nextInt(65);
		}
		
		while(this.height < 30){
			this.height = new Random().nextInt(65);
		}
		
		
		while(this.speed < 1) {
			this.speed = new Random().nextInt(3);
		}
		
		this.direction = new Random().nextInt(8);
		
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
		g.setColor(Color.red);
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
}
