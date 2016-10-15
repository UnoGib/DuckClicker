package com.dockdev.duckclicker.items;

import java.awt.Graphics;

import com.dockdev.duckclicker.Duck;
import com.dockdev.duckclicker.Item;

public class Cloner extends Item{

	private Duck duck;
	
	private int time = 0;
	
	public Cloner(int dps, int pval, String image, Duck duck) {
		super(dps, pval, image);
		this.duck = duck;
	}

	@Override
	public void tick() {
		time++;
		if(time == 60){
			time = 0;
			duck.clicked = duck.clicked + dps;
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		
	}

}
