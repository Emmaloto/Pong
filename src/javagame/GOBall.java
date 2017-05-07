package javagame;

/* Class for ball inheriting GameObject
 * 
 */

public class GOBall extends GameObject{
	
	public static int SIZE = 20;
	
	private static final float MAX_SPEEDX = 4;
	private static final float MAX_SPEEDY = 4;
	
	public float velX, velY;
	public float startX, startY;

	public GOBall(float bx, float by){
		x = bx;
		y = by;
		w = SIZE;
		h = SIZE;
		startX = x;
		startY = y;
		
		velX = -MAX_SPEEDX;
		velY = 0;
	}
	
	
	public void updateObj() {							// Occurring every frame
		x += velX;
		y += velY;
		
	}

	public void reverseX(float center) {				// Reverse ball direction
		velX *= -1;
		velY += (getCenterY() - center) *0.05;
		
		if(velY > MAX_SPEEDY)
			velY  = MAX_SPEEDY;
		else if(velY < -MAX_SPEEDY)
			velY = -MAX_SPEEDY;
	}
	
	public void reverseY(){
		velY *= -1;
	}


	public void reset() {
		x = startX;
		y = startY;
		
		velX += -1;
		velY = 0; 
		
	}

}
