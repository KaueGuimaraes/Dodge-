package com.kauescompany.entites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.kauescompany.main.Game;

public class Player extends Entity{
	
	public static boolean down, up, right, left;
	public static double speed = 2;
	public static int life = 10000, hits;
	public static final int initLife = life;
	
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
		
		if(Game.level == 3 || Game.level == 4) {
			speed = 4;
		}else if(Game.level >= 5) {
			speed = 7;
		}
		
		//System.out.println("X = " + this.getX());
		//System.out.println("Y = " + this.getY());
		
		for(int i = 0; i < Game.enemies.size(); i++) {
			if (isColliding(this, Game.enemies.get(i))) {
				hits++;
				if(Game.level == 0) {
					life-= new Random().nextInt(4);
				}else if(Game.level == 1 || Game.level == 2 || Game.level == 3) {
					life-= new Random().nextInt(6);
				}else if(Game.level == 4) {
					life-= new Random().nextInt(10);
				}else if(Game.level == 5) {
					life-= new Random().nextInt(12);
				}else if(Game.level == 6) {
					life-= new Random().nextInt(14);
				}else if(Game.level == 7){
					life-= new Random().nextInt(28);
				}else {
					life-= new Random().nextInt(80);
				}
			}
		}
		
		for(int i = 0; i < Game.lifepacks.size(); i++) {
			if(isColliding(this, Game.lifepacks.get(i))) {
				life += new Random().nextInt(500);
				Game.lifepacks.remove(i);
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
