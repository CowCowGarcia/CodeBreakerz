package org.lwjgl.mm;

public abstract class Entity {

	//TODO have speed controlled by delta and have some sort of velocity
	private float horizontalSpeed = 1;
	private float jumpHeight = 3;
	private double gravity = 1.1;
	private double speedIncrease = 1.1;
	protected float x = 100;
	protected float y = 100;

	float vertical_speed = 1;
    float vertical_position;  
    private float Y_TERMINAL_VELOCITY = 20;
    private float X_MAX_SPEED = 30;
    
    public void gravitons ()
    {
        /*this.vertical_speed = (float) (this.vertical_speed * gravity);
        
        if (this.vertical_speed > Y_TERMINAL_VELOCITY)
        {
            this.vertical_speed = Y_TERMINAL_VELOCITY;
        }*/
        this.y = this.y + 10;
        
        if (y > 400) y = 400;//keeps it on the level
    }
    
	public void Jump(int s)
	{
		/*this.vertical_speed = (float) (this.vertical_speed + gravity);
    if (this.vertical_speed > Y_TERMINAL_VELOCITY)
    {
        this.vertical_speed = Y_TERMINAL_VELOCITY;
    }
    this.y = this.y - this.vertical_speed;*/
    y= y+ s;
	}

	public void Left()
	
	{	

		this.horizontalSpeed = (float) (this.horizontalSpeed * speedIncrease);
	
	    if (this.horizontalSpeed > X_MAX_SPEED)
	    {
	        this.horizontalSpeed = X_MAX_SPEED;
	    }
	    
	    this.x = this.x - this.horizontalSpeed;
		
	}
	
	public void Right()
	{
		x= x+horizontalSpeed;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
}

