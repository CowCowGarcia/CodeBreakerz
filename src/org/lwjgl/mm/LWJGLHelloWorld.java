package org.lwjgl.mm;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LWJGLHelloWorld extends BasicGame 
{
	
	Entity player;
	Controller controller;
	Image p1;
	
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
		player = new Entity();
		p1 = new Image("res/sprites/Idle.png");
		
	}
	
	/**render method overridden from BasicGame class in the slick library, here is where everytrhing is drawn to screen **/
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{

		g.drawString("Fuck you",player.getX(),player.getY() - 20);	
		g.drawImage(p1, player.getX(),player.getY());
		
	}
	
	/**update method overridden from BasicGame class in the slick library, this is where all movement and anything that constantly needs to change happens.
	 * This method loops until game is closed **/
	@Override
	public void update(GameContainer gc, int arg1) throws SlickException 
	{
		  
		if(controller.isKeyDownUP())
		{
			player.Up();
		}
		
		if(controller.isKeyDownLEFT())
		{
			player.Left();
		}
		
		if(controller.isKeyDownRIGHT())
		{
			player.Right();
		}
		
		if(controller.isKeyDownDOWN())
		{
			player.Down();
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
	          container.start();
	     } 
	     catch (SlickException e) 
	     {
	          e.printStackTrace();
	     }
	}
}
