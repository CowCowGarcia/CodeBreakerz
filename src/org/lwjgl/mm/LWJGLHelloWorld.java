package org.lwjgl.mm;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**this class is the basic gameloop and the main class, it is a good idea to eventually split the main and gameloop */
public class LWJGLHelloWorld extends BasicGame 
{
	
	private Player player; 
	private Controller controller;
	private Image p1;
	private TiledMap level;
	boolean up = false;
	double counter2 = 4;
	private Image collisionimg;
	private Collision collision;
	String released= "player.getScore()";
	
	/**Constructor setting title **/
	public LWJGLHelloWorld(String title) 
	{
		super(title);
		
	}
	
	/**init method overridden from BasicGame class in the slick library, here is where variables are initialised for use**/
	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		controller = new Controller(gc); // GameContainer given to Controller class
		player = new Player(); //new instance of player
		p1 = new Image("res/sprites/Idle.png"); //setting player 1 image
		collisionimg = new Image("res/levels/testCol.png");// collision image
		//level = new TiledMap("res/levels/level.tmx"); //leave this for now

		collision = new Collision(collisionimg); //create collision class parsing in collision image
	}
	
	/**render method overridden from BasicGame class in the slick library, here is where everytrhing is drawn to screen **/
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		g.drawImage(collisionimg, 0, 0);
		g.drawImage(p1, player.getX(),player.getY());
		//level.render(0, 0); //leave this for now
		g.drawString(released, 10, 30);
		
		System.out.print(collisionimg.getHeight());
		
	}
	
	
	/**update method overridden from BasicGame class in the slick library, this is where all movement and anything that constantly needs to change happens.
	 * This method loops until game is closed **/
	@Override
	public void update(GameContainer gc, int arg1) throws SlickException 
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
		if (collision.bottomClear(player.getX(), player.getY(), p1.getWidth(), p1.getHeight()) && !up) //if the bottom of the character is clear and character is finished going up
		{
			player.gravitons(); //call gravatons() function
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
			
			keyPressed(Input.KEY_A, 'a');
			released = "left";
		}
		else
		{
			keyReleased(Input.KEY_A, 'a');
		}
		
		if(controller.isKeyDownRIGHT())//if key down for right
		{
			
			keyPressed(Input.KEY_D, 'd');
			released = "right";
		}
		else
		{
			keyReleased(Input.KEY_D, 'd');
		}
		//////////////////////////////////////////////////////////////////////
		
	}
	
	public void keyPressed(int key, char c) 
	{
		
		if (key == Input.KEY_D) 
		{
			if(collision.rightClear(player.getX(), player.getY(), p1.getWidth(), p1.getHeight()))//check collision
			player.Right();
		}
		
		if (key == Input.KEY_A) 
		{
			if (collision.leftClear(player.getX(), player.getY(), p1.getWidth(), p1.getHeight()))//check collision
			player.Left();
		}
	}
	
	public void keyReleased(int key, char c)
	{
		if (released == "right")
		{
			if (key == Input.KEY_D) 
			{
				if(collision.rightClear(player.getX(), player.getY(), p1.getWidth(), p1.getHeight()))//check collision
				player.StopRight();
			}
		}
		
		if (released == "left")
		{
			if (key == Input.KEY_A) 
			{
				if (collision.leftClear(player.getX(), player.getY(), p1.getWidth(), p1.getHeight()))//check collision
				player.StopLeft();
			}
		}
	}
	
	
	/**main method sets up container**/
	public static void main(String[] args) 
	{
		// TODO expand to maybe specify container size and put in to own class 
		LWJGLHelloWorld game = new LWJGLHelloWorld("yoyoyo");
	     try 
	     {
	          AppGameContainer container = new AppGameContainer(game);
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
