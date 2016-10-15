package com.dockdev.duckclicker;
import java.awt.Graphics;
import java.util.LinkedList;
	
public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	LinkedList<Item> item = new LinkedList<Item>();
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		for (int i = 0; i < item.size(); i++){
			Item tempItem = item.get(i);
			tempItem.tick();
		}
	}
	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
		for (int i = 0; i < item.size(); i++){
			Item tempItem = item.get(i);
			tempItem.render(g);
			//tempItem.iconRender(g);
		}
	}
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	public void addItem(Item item) {
		this.item.add(item);
	}
	public void removeItem(Item item) {
		this.item.remove(item);
	}
}
