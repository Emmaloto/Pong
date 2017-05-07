package javagame;

public class EnemyPaddle extends GameObject {

	public static int PSIZE = 20;
	public static float MAX_SPEEDY = 4;
	
	private GOBall b;
	
	public EnemyPaddle(float ex, float ey, GOBall ball) {
		x = ex;
		y = ey;
		w = PSIZE;
		h = PSIZE * 7;
		b = ball;
	}

	
	public void updateObj() {
		if(PongPhysics.checkCollision(b, this))
			b.reverseX(getCenterY());
		
		float speed = (b.getCenterY() - getCenterY()) * 0.05f;	// Dist between enemy and ball
		if(speed > MAX_SPEEDY)
			speed = MAX_SPEEDY;
		if(speed < -MAX_SPEEDY)
			speed = -MAX_SPEEDY;
		
		y += speed;
		
	}
	

}
