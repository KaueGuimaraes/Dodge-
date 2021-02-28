package com.kauescompany.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.kauescompany.main.Game;

public class UI {
	
	public boolean F3;
	public int seconds, FPS;
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 17));
		g.drawString(""+seconds, 2 * Game.SCALE, 5 * Game.SCALE);
		g.drawString("", 2 * Game.SCALE, 5 * Game.SCALE);
		
		//Estatisticas para nerds
		if(F3) {
			g.setColor(Color.gray);
			g.setFont(new Font("arial", Font.BOLD, 17));
			
			g.drawString("Enemies: " + Game.enemies.size(), 1 * Game.SCALE, 22 * Game.SCALE);
			g.drawString("FPS: " + FPS, 1 * Game.SCALE, (34 - 7) * Game.SCALE);
			g.drawString("Level: " + Game.level, 1 * Game.SCALE, (32) * Game.SCALE);
			g.drawString("X: " + Game.player.getX(), 1 * Game.SCALE, (37) * Game.SCALE);
			g.drawString("Y: " + Game.player.getY(), 25 * Game.SCALE, (37) * Game.SCALE);
			g.drawString("PWidth: " + Game.player.getWidth(), 1 * Game.SCALE, (42) * Game.SCALE);
			g.drawString("PHeight: " + Game.player.getHeight(), 25 * Game.SCALE, (42) * Game.SCALE);
			g.drawString("Speed: " + Game.player.speed, 1 * Game.SCALE, (47) * Game.SCALE);
			g.drawString("Scale: " + Game.SCALE, 1 * Game.SCALE, (57) * Game.SCALE);
			g.drawString("Width: " + Game.WIDTH, 1 * Game.SCALE, (52) * Game.SCALE);
			g.drawString("Height: " + Game.HEIGHT, 25 * Game.SCALE,(52) * Game.SCALE);
			g.drawString("Hits: " + Game.player.hits, 1 * Game.SCALE, (62) * Game.SCALE);
		}
	}
	
}
