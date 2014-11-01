package org.lwjgl.mm;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**this class is the basic gameloop and the main class, it is a good idea to eventually split the main and gameloop */
public class StandardGame extends BasicGameState 
{
	
	private Player player; 
	private Controller controller;
	private Image p1;
	private TiledMap level;
	boolean up = false;
	double counter2 = 4;
	private Image collisionimg;
	private Collision collision;
	private int standardGameID;
	private LevelGen lg;
	private Camera cam;
	
	/**Constructor setting title **/
	public StandardGame(int sgID) 
	{
		standardGameID = sgID;
		
	}
	
	/**init method overridden from BasicGame class in the slick library, here is where variables are initialised for use**/
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		lg = new LevelGen();
		controller = new Controller(gc); // GameContainer given to Controller class
		p1 = new Image("res/sprites/Idle.png"); //setting player 1 image
		level = new TiledMap("res/levels/test2.tmx"); //leave this for now
		
		
		
		player = new Player(p1, lg.getCollision()); //new instance of player
		
		cam = new Camera(gc,level);
	}
	
	/**render method overridden from BasicGame class in the slick library, here is where everytrhing is drawn to screen **/
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		cam.centerOn(player.getX(), player.getY());
		cam.drawMap();
		
		
		
		cam.translateGraphics();
		g.drawImage(lg.collisionMapPicker(), 0, 0);
		g.drawImage(p1, player.getX(),player.getY());
		//level.render(0, 0); //leave this for now
		//g.drawString(released, 10, 30);
		
	}
	
	
	/**update method overridden from BasicGame class in the slick library, this is where all movement and anything that constantly needs to change happens.
	 * This method loops until game is closed **/
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg1 ) throws SlickException 
	{
		player.setScore(0);
		///////////////////////////////player jump////////////////////////////////////
		if(controller.isKeyDownUP())
		{
			counter2 = counter2 + 0.1;
			up = true;
			player.Jump((int) ((Math.sin(counter2)+Math.cos(counter2))*20));
			if (counter2 >= 7)
			{
				counter2 = 4;
			}
		}
		else
		{
			up = false;
			counter2 = 4;
		}

		///////////////////////////////////////////////////////////////////////////
		
		/////////////////////////////player fall////////////////////////////////
		if (!up) //if the bottom of the character is clear and character is finished going up
		{
			player.gravitons(p1, lg.getCollision()); //call gravatons() function
		}
		//makes sure player does not go below a point, use this to fix bug 4
		if (player.getY() > 400) 
		{
			player.setY(400); 
		}
		///////////////////////////////////////////////////////////////////////////
		
		////////////////////////////player control////////////////////////////////
		if(controller.isKeyDownLEFT()) //if key down for left
		{
			controller.setPlayer(player);
			controller.keyPressed(Input.KEY_A, 'a');
			controller.setReleaseConstrain("left");
			
		}
		else
		{
			//controller.setPlayer(player);
			controller.keyReleased(Input.KEY_A, 'a');

		}
		
		if(controller.isKeyDownRIGHT())//if key down for right
		{
			controller.setPlayer(player);
			controller.keyPressed(Input.KEY_D, 'd');
			controller.setReleaseConstrain("right");
		}
		else
		{
			controller.setPlayer(player);
			controller.keyReleased(Input.KEY_D, 'd');
		}
		//////////////////////////////////////////////////////////////////////
		
	}

	@Override
	public int getID() {
		
		return standardGameID;
	}
	
}
