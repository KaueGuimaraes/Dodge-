package com.kauescompany.entites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.kauescompany.main.Game;

public class Player extends Entity{
	
	public static boolean down, up, right, left;
	public static double speed = 1.7;
	public static int life = 10000, hits;
	
	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
	}
	
	public void tick() {
		if(down) {
			y += speed;
		}
		
		if(up) {
			y -= speed;
		}
		
		if(right) {
			x += speed;
		}
		
		if(left) {
			x -= speed;
		}
		
		//System.out.println("X = " + this.getX());
		//System.out.println("Y = " + this.getY());
		
		for(int i = 0; i < Game.enemies.size(); i++) {
			if (isColliding(this, Game.enemies.get(i))) {
				hits++;
				life--;
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
