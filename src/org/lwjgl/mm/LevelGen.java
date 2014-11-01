package org.lwjgl.mm;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
/**
 * this class sets the level and colision map
 * @author cfrancois
 *
 */
public class LevelGen 
{
	private TiledMap level;
	private Image collisionMap;
	private int levelToRender = 0;
	private Collision collision;
	int doOnce = 0;
	
	public LevelGen() throws SlickException 
	{
		collision = new Collision(); //create collision class parsing in collision image
	}
	
	public TiledMap levelPicker(int ltr)
	{
		return level;
	}
	
	public Image collisionMapPicker()throws SlickException 
	{
		switch(levelToRender)
		{
			case 0:
				while(doOnce<1)
				{
					collisionMap = new Image("res/levels/colltest2.png");
					collision.setCollisionMap(collisionMap);
					collision.scan();
					doOnce++;
				}
				break;
		}
		
		return collisionMap;
	}
	
	public void setLevel(int lvl)
	{
		levelToRender = lvl;
	}
	
	public int getLevel()
	{
		return levelToRender;
	}
	
	public Collision getCollision()
	{
		return collision;
	}
	
	public void setDoOnce(int doonce)
	{
		doOnce = doonce;
	}
}
