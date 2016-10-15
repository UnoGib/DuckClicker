package com.dockdev.duckclicker.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.dockdev.duckclicker.Duck;
import com.dockdev.duckclicker.Duck.GameState;

public class Splash {

	BufferedImage background;

	private int time = 0;

	private Duck duck;

	public Splash(Duck duck) {
		try {
			background = ImageIO.read(getClass().getResourceAsStream("/dclickbg.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.duck = duck;
	}

	public void render(Graphics g) {
		Font fnt = new Font("ariel", 1, 50);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawImage(background, 0, 0, null);
		g.drawString("DockDev", 200, Duck.HEIGHT / 2);
	}

	public void tick() {
		if (duck.currentState == GameState.Splash) {
			time++;
			if (time == 180) {
				time = 0;
				duck.currentState = GameState.Menu;
			}
		}
	}
}
