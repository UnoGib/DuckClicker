package com.dockdev.duckclicker;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class MainMenu {
	
	private Duck duck;
	BufferedImage background;
	
	public MainMenu(Duck duck) {
		this.duck = duck;
		try {
			background = ImageIO.read(getClass().getResourceAsStream("/ksduck.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g){
		Font fnt = new Font("arial", 1, 50);
		Font bntFnt = new Font("arial", 1, 20);
		Font versionFnt = new Font("arial", 1, 15);
		
		g.setFont(fnt);
		
		g.drawImage(background, 0, 0, duck);
		
		g.setColor(Color.WHITE);
		g.drawString("Duck Clicker", 200, 50);
		
		g.setFont(bntFnt);
		g.drawString("Play", 285, 190);
		g.drawString("Shop", 285, 290);
		g.drawString("Exit", 290, 390);
		g.setFont(versionFnt);
		g.drawRect(210, 150, 200, 64);
		
		g.setColor(Color.WHITE);
		g.drawRect(210, 250, 200, 64);
		
		g.setColor(Color.WHITE);
		g.drawRect(210, 350, 200, 64);
	}
}
