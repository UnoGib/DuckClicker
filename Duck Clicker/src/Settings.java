import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Settings {
	
	BufferedImage settings;
	
	public void render(Graphics g){
		
		g.drawImage(settings,  WIDTH, HEIGHT, null);
		
	}
}
