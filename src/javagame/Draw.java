package javagame;

/* Draw rectangles for GameObject
 *  
 */

import static org.lwjgl.opengl.GL11.*;

public class Draw {
	
	public static void rect(float x, float y, float width, float height){
		rect(x, y, width, height, 0);
	}
	
	public static void rect(float x, float y, float width, float height, float rot){
		glPushMatrix();						// Creates separate matrices for each rect
		
		glTranslatef(x,y,0);  				// Move(x, y, z)
		glRotatef(rot,0,0,1);				// rotate(angle,x axis, y axis, z axis)
		
		glBegin(GL_QUADS);
							
		glVertex2f(0,0);
		glVertex2f(0,height);
		glVertex2f(width,height);
		glVertex2f(width,0);
					
		glEnd();
		
		glPopMatrix();
	}
}
