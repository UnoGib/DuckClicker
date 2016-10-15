package com.dockdev.duckclicker;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public abstract class Item {
	
	protected int dps, pval;
	protected String image;
	
	BufferedImage icon;
	
	public Item(int dps, int pval, String image) {
		this.dps = dps;
		this.image = image;
		this.pval = pval;
		
		try {
			icon = ImageIO.read(getClass().getResourceAsStream(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void iconRender(Graphics g){
		g.drawImage(icon, 0, 0, null);
	}
	
	public int getDps(){
		return dps;
	}
	
	public int getPval(){
		return pval;
	}
	
}
