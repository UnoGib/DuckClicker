import java.awt.Font;
import java.awt.Graphics;

public class Text extends GameObject{
	private String text;
	private Handler handler;
	public Text(int x, int y, ID id, String text, Handler handler) {
		super(x, y, id);
		this.text = text;
		this.handler = handler;
	}

	@Override
	public void tick() {
		
	}
	
	public void remove() {
		handler.removeObject(this);
	}
	
	@Override
	public void render(Graphics g) {
		Font font = new Font("ariel", 1, 40);
		  g.setFont(font);
		  g.drawString(text, x, y);
	}

}
