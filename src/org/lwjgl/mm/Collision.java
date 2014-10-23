package org.lwjgl.mm;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class Collision 
{
	private Image colMap;
	boolean blocked[][];
	
	public Collision(Image cm)
	{
		colMap = cm;
		scan();
	}
	
	private void scan()
	{
		blocked = new boolean[colMap.getWidth()][colMap.getHeight()+100];
		
		for(int x = 0; x < colMap.getWidth(); x++)
		{
			for(int y = 0; y < colMap.getHeight(); y++)
			{
				if (colMap.getColor(x, y).equals(Color.red))
				{
					blocked[x][y] = true;
				}
			}
		}
		
	}
	
	public boolean isBlocked(float x, float y)
	{
		if(blocked[(int) x][(int)y])
		{
			return true;
		}
		return false;
	}
	
	public boolean bottomClear(float xpos, float ypos, int width, int height)
	{
		if(isBlocked(xpos, ypos + height) || isBlocked(xpos + width, ypos + height))
		{
			return false;
		}
		
		return true;
			
	}
	
	public boolean leftClear(float xpos, float ypos, int width, int height, float speed)
	{
		if(isBlocked(xpos - speed, ypos) || isBlocked(xpos - speed, ypos + height - 1))
		{
			return false;
		}
		
		return true;
			
	}
	
	public boolean rightClear(float xpos, float ypos, int width, int height, float speed)
	{
		if(isBlocked((xpos + width)+speed, ypos) || isBlocked((xpos + width)+speed, ypos + height - 1))
		{
			return false;
		}
		
		return true;
			
	}
	
	public boolean upClear(float xpos, float ypos, int width, int height)
	{
		if(isBlocked(xpos, ypos) || isBlocked(xpos + width, ypos))
		{
			return false;
		}
		
		return true;
			
	}
}
