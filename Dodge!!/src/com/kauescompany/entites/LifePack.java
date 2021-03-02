package com.kauescompany.entites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.kauescompany.main.Game;

public class LifePack extends Entity{
	
	private int v;
	
	public LifePack(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		//g.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.drawImage(this.getSprite(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
	}
	
}
