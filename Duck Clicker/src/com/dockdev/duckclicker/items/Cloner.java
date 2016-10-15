package com.dockdev.duckclicker.items;

import java.awt.Graphics;

import com.dockdev.duckclicker.Duck;
import com.dockdev.duckclicker.Item;

public class Cloner extends Item{

	private Duck duck;
	
	public Cloner(int price, int dps, int pval, String image, Duck duck) {
		super(price, dps, pval, image);
		this.duck = duck;
	}

	@Override
	public void tick() {
		System.out.println("tick");
		duck.clicked = duck.clicked + dps / 60;
	}

	@Override
	public void render(Graphics g) {
		
	}

}
