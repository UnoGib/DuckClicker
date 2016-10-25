package com.dockdev.duckclicker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.dockdev.duckclicker.Duck.GameState;

public class Clicking extends MouseAdapter {
	private Duck duck;

	public Clicking(Duck duck) {
		this.duck = duck;
	}

	public void mousePressed(MouseEvent mouse) {
		int mx = mouse.getX();
		int my = mouse.getY();

		if (mouseOver(mx, my, Duck.WIDTH / 2 - 60 - 15 - 15, Duck.HEIGHT / 2 - 60 - 15 - 15 - 15, 158, 158)) {
			if (duck.currentState == GameState.Game) {
				duck.clicked++;
			}
		}
		// Market
		if (mouseOver(mx, my, 500, 340, 100, 100)) {
			if (duck.currentState == GameState.Market){
				duck.currentState = GameState.Game;}
			if (duck.currentState == GameState.Game){
				duck.currentState = GameState.Market;}
		}
		if (duck.currentState == GameState.Menu) {
			// Start Button
			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				duck.currentState = GameState.Game;
			}
			//Shop
			if(mouseOver(mx, my, 210, 250, 200, 64)){
				duck.currentState = GameState.Market;
			}
			//Exit
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				System.exit(0);
			}
		}
	}

	public boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			}
			return false;
		}
		return false;
	}
}
