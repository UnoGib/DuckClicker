package com.dockdev.duckclicker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.dockdev.duckclicker.items.Cloner;
import com.dockdev.duckclicker.menu.Splash;

public class Duck extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 4502326507414152596L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Handler handler = new Handler();
	private Thread thread;
	private boolean running = false;

	BufferedImage duckclicker;
	// BufferedImage brahcha;
	private Settings settings = new Settings();
	private Clicking clicking = new Clicking(this, handler);
	private Splash splash = new Splash(this);
	private MainMenu mainmenu = new MainMenu(this);
	private Market market = new Market();
	public String aversion = "Version: " + "Alpha 0.2";
	public int clicked = 0;
	private boolean addedText = false;

	

	private Config config = new Config();


	public enum GameState {
		Splash, Menu, Game, Market, Settings
	};

	public GameState currentState = GameState.Splash;

	public Duck() {
		
		new Window(WIDTH, HEIGHT, "Duck Clicker Alpha", this);
		System.out.println(aversion);
		try {
			duckclicker = ImageIO.read(getClass().getResourceAsStream("/duckclicker.png"));
			// brahcha =
			// ImageIO.read(getClass().getResourceAsStream("/brahcha.gif"));
			handler.addItem(new Cloner(100, 5, 1, "/duckclicker.png", this));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.addMouseListener(clicking);
	}

	public static void main(String kase[]) {

		new Duck();

	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	public void tick() {
		if (currentState == GameState.Game) 
		handler.tick();
		else if(currentState == GameState.Splash){
			splash.tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		if (currentState == GameState.Game) {
			settings.render(g);
			market.render(g);
			handler.render(g);
			g.drawImage(duckclicker, WIDTH / 2 - 60 - 15 - 15, HEIGHT / 2 - 60 - 15 - 15 - 15, null);
		} else if(currentState == GameState.Menu){
			mainmenu.render(g);
		}else if(currentState == GameState.Splash){
			splash.render(g);
		}
		
		// g.drawImage(brahcha, WIDTH, HEIGHT, null);
		g.setColor(Color.black);
		if (addedText == false) {
			handler.addObject(new Text(240, 50, ID.Text, "Ducks: " + clicked, handler));
			addedText = true;
		}
		Font font2 = new Font("ariel", 1, 20);
		g.setFont(font2);
		g.setColor(Color.RED);
		g.drawString("Alpha 0.2", 15, 440);
		g.setColor(Color.yellow);
		g.dispose();
		bs.show();

	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		System.out.println("Started");
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			System.out.println("Stopping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	

	
	public Config getConfig(){
		return config;
	}

}
