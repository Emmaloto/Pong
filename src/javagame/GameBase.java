package javagame;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/*
 * This just runs the game and sets up the display
 * 
 */

public class GameBase {
	
	private static PongGame game;

	public static void main(String[] args) {
		
		
		
		// Initialize Program
		createDisplay();
		createGL();
		
		startGame();						// 
		
		gameLoop();							// Actually runs the game
		cleanUp();
	}
		


	
	private static void createDisplay(){		// Create Display
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			Display.setVSyncEnabled(true);
			Keyboard.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();				// Clears projection matrix
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);		// Creates window		
		
		glMatrixMode(GL_MODELVIEW);		
		glClearColor(0,0,0,1);			// Sets default color for canvas update
		
	}
	
	private static void startGame(){
		
		game = new PongGame();
	}
		
		
	private static void gameLoop(){				// Game Loop
		while(!Display.isCloseRequested()){		// Run until window is closed	
			game.getInput();
			game.update();
			game.render();
						
		}
	}
	
	
	private static void cleanUp(){
		Display.destroy();
		Keyboard.destroy();
	}

}
