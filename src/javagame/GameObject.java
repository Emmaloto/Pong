package javagame;

public abstract class GameObject {
	
	protected float x, y, w, h;
	
	
	abstract void updateObj();
	
	public void renderObj(){
		Draw.rect(x, y, w, h);
	}
	
	public float getX(){
		return x; 
	}
	
	public float getY(){
		return y;
	}
	
	public float getWidth(){
		return w;
	}
	
	public float getHeight(){
		return h;
	}
	
	public float getCenterY(){
		return y + h/2;
	}
}
