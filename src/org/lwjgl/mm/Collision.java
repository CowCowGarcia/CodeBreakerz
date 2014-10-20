package org.lwjgl.mm;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;

public class Collision 
{
	private Image colMap;
	boolean blocked[][];
	Color collision = new Color(1,0,0,1);
	
	public Collision(Image cm)
	{
		colMap = cm;
		scan();
	}
	
	private void scan()
	{
		blocked = new boolean[colMap.getWidth()][colMap.getHeight()];
		
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
		if(blocked[(int)x][(int)y])
		{
			return true;
		}
		return false;
	}
	
	public boolean bottomClear(float xpos, float ypos, int width, int height)
	{
		if(isBlocked(xpos, ypos + height) || isBlocked(xpos, (ypos + height)))
		{
			return false;
		}
		
		return true;
			
	}
}
