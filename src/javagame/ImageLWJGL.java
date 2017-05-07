package javagame;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

@SuppressWarnings("unused")
public class ImageLWJGL {
	public static Texture p;

	public static void main(String[] args) {
		createDisplay();
		createGL();
		
		render();
		
		cleanUp();

	}
	
	private static void createDisplay(){		// Create Display
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			Display.setVSyncEnabled(true);
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();				// Clears projection matrix
		glOrtho(0, 1, 0, 1, -1, 1);		// Creates window		
		
		glMatrixMode(GL_MODELVIEW);		
		
		glClearColor(0,0,0,1);			// Sets default color for canvas update
		//glDisable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
		
	}
	
	
	private static  void render(){
		while(!Display.isCloseRequested()){
			
		try {
			 p = TextureLoader.getTexture("PNG", 
								new FileInputStream(new File("res/Brick.png")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		float w = 0.4f; //p.getWidth();
		float h = 0.1f; //p.getHeight();	
		
		
		
		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();

		//glColor3f(0.25f,0.75f,0.5f);		
		//glPushMatrix();						// Creates separate matrices for each rect
		
		//glTranslatef(x,y,0);  				// Move(x, y, z)
		//glRotatef(rot,0,0,1);				// rotate(angle,x axis, y axis, z axis)
		
		//((Texture) Color.WHITE).bind();
		p.bind();
		
		glBegin(GL_QUADS);
		
		glTexCoord2f(0,0);
		glVertex2f(0,0);					// (origin, origin)
		
		glTexCoord2f(0,1);
		glVertex2f(0,h);					// (origin, y-axis)-height
		
		glTexCoord2f(1,1);
		glVertex2f(w,h);					// (x-axis, y-axis)
		
		glTexCoord2f(1,0);
		glVertex2f(w,0);					// (x-axis, origin)-width
		

		glEnd();
		
		//glPopMatrix();
		Display.update();
		}

	}

		
		

	private static void cleanUp(){
		Display.destroy();

	}


}
