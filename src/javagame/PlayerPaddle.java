package javagame;

public class PlayerPaddle extends GameObject{

	
	public static final int PSIZE = 20;
	
	public static float DY = 4;
	
	private GOBall b;
	
	public PlayerPaddle(float x, float y, GOBall ball) {
		this.x = x;
		this.y = y;
		this.w = PSIZE;
		this.h = PSIZE * 7;
		b = ball;
	}

	
	public void updateObj() {						// Update per frame
		if(PongPhysics.checkCollision(b, this))
			b.reverseX(getCenterY());
	}


	public void move(int i) {
		y += DY * i;
		
	}

}
