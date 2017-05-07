package javagame;

import java.awt.Rectangle;

public class PongPhysics {
	
	public static boolean checkCollision(GameObject g1, GameObject g2){
		Rectangle r1 = new Rectangle((int)g1.getX(), (int)g1.getY(), 
									 (int)g1.getWidth(), (int)g1.getHeight());
		Rectangle r2 = new Rectangle((int)g2.getX(), (int)g2.getY(), 
				 (int)g2.getWidth(), (int)g2.getHeight());
		
		return r1.intersects(r2);
	}

}
