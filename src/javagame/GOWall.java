package javagame;

public class GOWall extends GameObject {

	private GOBall b;
	public static final int STDSIZE = 16;
	
	public GOWall(float wx, float wy, float ww, float hw, GOBall ball) {
		x = wx;
		y = wy;
		w = ww;
		h = hw;
		b = ball;
	}

	@Override
	public void updateObj() {
		if(PongPhysics.checkCollision(b, this))
			b.reverseY();

	}

}
