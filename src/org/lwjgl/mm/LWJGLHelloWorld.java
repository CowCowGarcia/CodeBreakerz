package org.lwjgl.mm;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

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
		player = new Player();
		p1 = new Image("res/sprites/Idle.png");
		collisionimg = new Image("res/levels/testCol.png");
		//level = new TiledMap("res/levels/level.tmx"); //leave this for now

		collision = new Collision(collisionimg); 
	}
	
	String released= "player.getScore()";
	
	/**render method overridden from BasicGame class in the slick library, here is where everytrhing is drawn to screen **/
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		g.drawImage(collisionimg, 0, 0);
		g.drawImage(p1, player.getX(),player.getY());
		//level.render(0, 0); //leave this for now
		g.drawString(released, 10, 30);
		//g.drawString(player.getHorizontalSpeed(), 30, 30);
		
	}
	
	
	/**update method overridden from BasicGame class in the slick library, this is where all movement and anything that constantly needs to change happens.
	 * This method loops until game is closed **/
	@Override
	public void update(GameContainer gc, int arg1) throws SlickException 
	{
		  System.out.print(player.getX()+ "  ");
		
		player.setScore(0);
		
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
	
		boolean playerLeft = false;
		
	
		if(controller.isKeyDownLEFT())
		{
			
			keyPressed(Input.KEY_A, 'a');
			released = "left";
		}
		else
		{
			keyReleased(Input.KEY_A, 'a');
		}
		
		if(controller.isKeyDownRIGHT())
		{
			
			keyPressed(Input.KEY_D, 'd');
			released = "right";
		}
		else
		{
			keyReleased(Input.KEY_D, 'd');
		}
		
		
	
		
		
		
		 if (collision.bottomClear(player.getX(), player.getY(), p1.getWidth(), p1.getHeight()) && !up)
		{
			player.gravitons();
		}
		if (player.getY() > 400)
		{
			player.setY(400);
		}
		
	}
	
	public void keyPressed(int key, char c) {
		
		if (key == Input.KEY_D) {
			player.Right();
		}
		
		if (key == Input.KEY_A) {
			player.Left();
		}/*;
		if (key == Input.KEY_D) {
			player.Right();;
		};
		if (key == Input.KEY_D) {
			player.Right();;
		};*/
	}
	
	public void keyReleased(int key, char c){
		if (released == "right")
		{
			if (key == Input.KEY_D) 
			{
				player.StopRight();
			//released = "True";
			
			}
		}
		
		if (released == "left")
		{
			if (key == Input.KEY_A) 
			{
				player.StopLeft();
			//released = "blue";
			
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
