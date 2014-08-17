package org.lwjgl.mm;

public class Entity {

	//TODO make a constructor that takes in speed, x and y so these values can be set when an entity is initialised
	//TODO have speed controlled by delta and have some sort of velocity
	private float speed = 1;
	private float x = 100;
	private float y = 100;

	public void Up()
	{
		y= y-speed;
	}
	
	public void Down()
	{
		y= y+speed;
	}
	
	public void Left()
	{
		x= x-speed;
	}
	
	public void Right()
	{
		x= x+speed;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
}

