package com.dockdev.duckclicker;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.dockdev.duckclicker.Duck.GameState;

public class Clicking extends MouseAdapter {
	private Duck duck;

	public Clicking(Duck duck) {
		this.duck = duck;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (mouseOver(mx, my, Duck.WIDTH / 2 - 60 - 15 - 15, Duck.HEIGHT / 2 - 60 - 15 - 15 - 15, 158, 158)) {
			if (duck.currentState == GameState.Game) {
				duck.clicked++;
			}

			if (mouseOver(mx, my, 210, 150, 200, 64)) {
				duck.currentState = GameState.Game;
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
