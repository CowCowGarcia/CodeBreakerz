package org.lwjgl.mm;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

/**
 * this class sets up the collision for the level, this class scanns the level for walls and platforms and performs checks
 * */
public class Collision 
{
	private Image collisionMap;//this is where the image for the collisionMap will be stored
	boolean blocked[][];//this is an array that keeps track of the pixels that cant be walked through
	
	/**
	 * constructor, empty
	 */
	public Collision()
	{
		
	}
	
	/**
	 * sets the 2d array to the width and height of the collisionMap cycles throught the 2d array and checks for pixels with tehe colour red, this will be the blocking colour
	 */
	public void scan()
	{
		blocked = new boolean[collisionMap.getWidth()][collisionMap.getHeight()];//sets the 2d array
		
		for(int x = 0; x < collisionMap.getWidth(); x++) //cycles through width
		{
			for(int y = 0; y < collisionMap.getHeight(); y++)//cycles through right
			{
				if (collisionMap.getColor(x, y).equals(Color.red)) //gets the colour of the coordinate and if it equals red
				{
					blocked[x][y] = true; //set that coordinate to true
				}
			}
		}
		
	}
	
	/**
	 * takes in a coordinate and checks to see if that position on the map is blocked or not 
	 * @param x represents the x coordinate of the object being checked
	 * @param y represents the y coordinate of the object being checked
	 * @return boolean represents if the coordinate is blocked or not  
	 */
	public boolean isBlocked(float x, float y)
	{
		if(blocked[(int) x][(int)y]) //if the blocked array indexed at x and y is true
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Performs a check on the bottom of an entity by calling isBlocked()
	 * @param xpos represents the x position of the entity
	 * @param ypos represents the y position of the entity
	 * @param width represents the width of the entity
	 * @param height represents the height of the entity
	 * @return boolean represents if the bottom of the entity is clear 
	 */
	public boolean bottomClear(float xpos, float ypos, int width, int height)
	{
		if(isBlocked(xpos, ypos + height) || isBlocked(xpos + width, ypos + height))
		{
			return false;
		}
		return true;	
	}
	/**
	 * Performs a check on the left of an entity by calling isBlocked()
	 * @param xpos represents the x position of the entity
	 * @param ypos represents the y position of the entity
	 * @param width represents the width of the entity
	 * @param height represents the height of the entity
	 * @param speed represents the speed of the entity, this may or maynot need to be taken in to consideration
	 * @return boolean represents if the left of the entity is clear
	 */
	public boolean leftClear(float xpos, float ypos, int width, int height, float speed)
	{
		if(isBlocked(xpos - speed, ypos) || isBlocked(xpos - speed, ypos + height - 1))
		{
			return false;
		}
		return true;	
	}
	
	/**
	 * Performs a check on the right of an entity by calling isBlocked()
	 * @param xpos represents the x position of the entity
	 * @param ypos represents the y position of the entity
	 * @param width represents the width of the entity
	 * @param height height represents the height of the entity
	 * @param speed represents the speed of the entity, this may or maynot need to be taken in to consideration
	 * @return boolean represents if the right of the entity is clear
	 */
	public boolean rightClear(float xpos, float ypos, int width, int height, float speed)
	{
		if(isBlocked((xpos + width)+speed, ypos) || isBlocked((xpos + width)+speed, ypos + height - 1))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Performs a check on the top of an entity by calling isBlocked()
	 * @param xpos represents the x position of the entity
	 * @param ypos represents the y position of the entity
	 * @param width represents the width of the entity
	 * @param height represents the height of the entity
	 * @return boolean represents if the top of the entity is clear
	 */
	public boolean upClear(float xpos, float ypos, int width, int height)
	{
		if(isBlocked(xpos, ypos) || isBlocked(xpos + width, ypos))
		{
			return false;
		}
		return true;	
	}
	
	/**
	 * sets the collision map
	 * @param cm represents the collision map to be used
	 */
	public void setCollisionMap(Image cm)
	{
		collisionMap = cm;
	}
	
	/**
	 * gets the collision map
	 * @return Image represents the current collision map
	 */
	public Image getCollisionMap()
	{
		return collisionMap;
	}
}
