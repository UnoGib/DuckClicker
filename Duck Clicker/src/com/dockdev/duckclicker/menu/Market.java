package com.dockdev.duckclicker.menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.dockdev.duckclicker.Duck;
import com.dockdev.duckclicker.Duck.GameState;

public class Market {

	BufferedImage market;
	private Duck duck;

	public Market(Duck duck) {
		try {
			market = ImageIO.read(getClass().getResourceAsStream("/markethundp.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.duck = duck;
	}

	public void render(Graphics g) {
		if (duck.currentState == GameState.Game)
			g.drawImage(market, 500, 340, null);
		if(duck.currentState == GameState.Market){
			g.setColor(Color.YELLOW);
			g.fillRect(0, 0, Duck.WIDTH, Duck.HEIGHT);
			g.drawImage(duck.duckclicker, 15, 15, 100, 100, null);
		}
	}

	public void tick() {

	}
}
