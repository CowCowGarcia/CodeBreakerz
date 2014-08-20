package org.lwjgl.mm;

public class Entity {

	//TODO have speed controlled by delta and have some sort of velocity
	private float speed = 5;
	private float gravity = 1;
	private float x = 100;
	private float y = 100;

	float vertical_speed = 0;
    float vertical_position;  
    private float TERMINAL_VELOCITY = 3;
    
    public void gravitons ()
    {
        this.vertical_speed = this.vertical_speed + gravity;
        if (this.vertical_speed > TERMINAL_VELOCITY)
        {
            this.vertical_speed = TERMINAL_VELOCITY;
        }
        this.y = this.y + this.vertical_speed;
    }
    
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

