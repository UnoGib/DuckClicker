import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Clicking extends MouseAdapter{
	private Duck duck;
	private Handler handler;
	public Clicking(Duck duck, Handler handler) {
		this.duck = duck;
		this.handler = handler;
	}
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if (mouseOver(mx, my, Duck.WIDTH / 2 - 60 - 15 - 15, Duck.HEIGHT / 2 - 60 - 15 - 15 - 15, 158, 158)) {
			duck.clicked++ ;
			for (int i = 0; i < handler.object.size(); i++ ) {
				GameObject tempObject = handler.object.get(i);
				if (tempObject.getID() == ID.Text) {
					handler.removeObject(tempObject);
				}
			}
			handler.addObject(new Text(240, 50, ID.Text, "Ducks: " + duck.clicked, handler));
		}
		
			
		
	}
	
	
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		  if(mx > x && mx < x + width){
		   if(my > y && my < x + width){
		    return true;
		   }
		   return false;
		  }
		  return false; 
		 }
}
