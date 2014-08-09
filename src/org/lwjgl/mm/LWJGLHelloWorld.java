package org.lwjgl.mm;

import static org.lwjgl.opengl.GL11.*;


import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class LWJGLHelloWorld extends BasicGame {
	
	public LWJGLHelloWorld(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	

	public static void main(String[] args) {
		LWJGLHelloWorld game = new LWJGLHelloWorld("yoyoyo");
	     try {
	          AppGameContainer container = new AppGameContainer(game);
	          container.start();
	     } catch (SlickException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	     }
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
<<<<<<< HEAD
		g.drawString("Fuck you",200,200);
=======
		// TODO Auto-generated method stub
		g.drawString("Hello World!",200,200);
>>>>>>> origin/master
		
	}

	@Override
	public void init(GameContainer g) throws SlickException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, int arg1) throws SlickException 
	{
		// TODO Auto-generated method stub
		
	}
}
