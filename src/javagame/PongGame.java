package javagame;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import java.util.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class PongGame {
	
	private ArrayList<GameObject> objects;
	private PlayerPaddle player;					// Inst variable bc input is required at getInput
	private GOBall ball;
	
	private int playerScore = 0;
	private int enemyScore = 0;
	
	public PongGame(){
		
		objects = new ArrayList<GameObject>();
		
		// Player elements
		ball = new GOBall(Display.getWidth()/2 - GOBall.SIZE/2,
								 Display.getHeight()/2 - GOBall.SIZE/2);
		player = new PlayerPaddle(0, Display.getHeight()/2 - PlayerPaddle.PSIZE/2, ball);
		EnemyPaddle opp = new EnemyPaddle(Display.getWidth() -EnemyPaddle.PSIZE ,
										 Display.getHeight()/2 - PlayerPaddle.PSIZE/2, ball);
		
		// Environment
		GOWall bottom = new GOWall(0, 0, Display.getWidth(), GOWall.STDSIZE, ball);
		GOWall top = new GOWall(0, Display.getHeight() - GOWall.STDSIZE, 
								Display.getWidth(), GOWall.STDSIZE, ball);
		
		objects.add(ball);
		objects.add(player);
		objects.add(opp);
		objects.add(top);
		objects.add(bottom);
	}
	
	
	public void getInput(){			// Obtains any user input needed
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			player.move(1);
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			player.move(-1);
	}
	
	public void update(){			// Does calculations and such
		for(GameObject g: objects)
			g.updateObj();
		
		if(ball.getX() > Display.getWidth()){
			
			playerScore++;
			ball.reset();			
		}else if(ball.getX() < 0){			
			enemyScore++;
			ball.reset();
		}
	}
	
	public void render(){			// Renders to screen so changes can be seen on canvas
		glClear(GL_COLOR_BUFFER_BIT);		// Clear up screen
		glLoadIdentity();
		
		glColor3f(0.25f, 0.75f, 0.5f);		// Square Color
		
		for(GameObject g: objects)
			g.renderObj();
		
		Display.setTitle("Player: " + playerScore + "   Computer: " + enemyScore);
		
		Display.update();					// update display
		Display.sync(60);					// Sync framerate
	}

}
