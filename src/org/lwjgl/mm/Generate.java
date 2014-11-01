package org.lwjgl.mm;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * this class generates and sets up the game, it initialises the states and sets the container  
 * @author cfrancois
 *
 */
public class Generate extends StateBasedGame
{
	private int multiplayerID = 3; //the multiplayer state
	private int standardGameID = 2;//the normal single player state
	private int gameMenuID = 1; //the start up game menu state
	private int gameOverID = 4; //this is the game over menu state
	private int settingsMenuID = 5;//this is the settings menu state
	private int pauseMenuID = 6;//this is the pause menu state
	
	/**
	 * constructor, adds all the states
	 */
	public Generate() 
	{
		super("Gname");
		
		this.addState(new StandardGame(standardGameID));
		//this.addState(new Menu(menuID));
		//this.addState(new Dead(deadID));
		//this.addState(new Game(gameID));
		//this.addState(new Menu(menuID));
		//this.addState(new Dead(deadID));
		
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException 
	{
		this.getState(standardGameID).init(gc,this);
		//this.getState(gameID).init(gc,this);
		//this.getState(deadID).init(gc, this);
		//this.getState(menuID).init(gc,this);
		//this.getState(gameID).init(gc,this);
		//this.getState(deadID).init(gc, this);
		//this.enterState(menuID);
		this.enterState(standardGameID);
		
	}

	/**main method sets up container**/
	public static void main(String[] args) 
	{
		// TODO expand to maybe specify container size and put in to own class 
	     try 
	     {
	          AppGameContainer container = new AppGameContainer(new Generate());
	          container.setMaximumLogicUpdateInterval(60);			
	          container.setDisplayMode(640, 480, false);//specify container size and if its full screen?
	          container.setTargetFrameRate(60);
	          container.setAlwaysRender(true);
	          container.setVSync(true);
	          container.start();
	     } 
	     catch (SlickException e) 
	     {
	          e.printStackTrace();
	     }
	}
}
