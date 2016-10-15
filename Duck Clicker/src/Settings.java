import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Settings {
	BufferedImage settings;
	public Settings() {
		try {
			settings = ImageIO.read(getClass().getResourceAsStream("/settingshundp.png"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void render(Graphics g){
		
		g.drawImage(settings,  350, 340, null);
		
	}
}
