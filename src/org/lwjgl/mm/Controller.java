package org.lwjgl.mm;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**this class covers all the input*/
public class Controller {
	private Input input;
	
	/**Constructor, This has to get the already made game container and put to in to a variable to be used
	 *@param gc represents the game container that is parsed in to get its input*/
	public Controller(GameContainer gc)
	{
		input = gc.getInput(); //calls the getInput method of the GameContainer and puts it in to the input variable
	}
	
	/**checks to see 'up' key or 'w' key is pressed*/
	public boolean isKeyDownUP() 
	{
		return input.isKeyDown(Input.KEY_UP) || input.isKeyDown(Input.KEY_W); //returns if 'UP' or 'W' is pressed
	}
	
	/**checks to see 'down' key or 's' key is pressed*/
	public boolean isKeyDownDOWN() 
	{
		return input.isKeyDown(Input.KEY_DOWN) || input.isKeyDown(Input.KEY_S); //returns if 'DOWN' or 'S' is pressed
	}

	/**checks to see 'left' key or 'a' key is pressed*/
	public boolean isKeyDownLEFT() 
	{
		return input.isKeyDown(Input.KEY_LEFT) || input.isKeyDown(Input.KEY_A); //returns if 'LEFT' or 'A' is pressed
	}
	
	/**checks to see 'right' key or 'd' key is pressed*/
	public boolean isKeyDownRIGHT() 
	{
		return input.isKeyDown(Input.KEY_RIGHT) || input.isKeyDown(Input.KEY_D); //returns if 'RIGHT' or 'D' is pressed
	}
}
