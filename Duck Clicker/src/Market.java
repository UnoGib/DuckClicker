import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Market {
	BufferedImage market;
	public Market() {
		try {
			market = ImageIO.read(getClass().getResourceAsStream("/markethundp.png"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void render(Graphics g){
		
		g.drawImage(market,  100, 340, null);
		
	}
}