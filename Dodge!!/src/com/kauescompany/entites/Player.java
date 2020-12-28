package com.kauescompany.entites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Entity{
	
	public static boolean down, up, right, left;
	public static double speed = 1.7;
	
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
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.getX(), this.getY(), 65, 65);
	}
}
