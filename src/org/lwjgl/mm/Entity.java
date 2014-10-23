package org.lwjgl.mm;

public abstract class Entity {

	//TODO have speed controlled by delta and have some sort of velocity
	private float horizontalSpeed = 1;
	private float jumpHeight = 3;
	private double gravity = 1.1;
	private double speedIncrease = 1.05;
	protected float x = 100;
	protected float y = 100;

	float vertical_speed = 1;
    float vertical_position;  
    private float Y_TERMINAL_VELOCITY = 20;
    private float X_MAX_SPEED = 2;
	private float setHorizontalSpeed;
	
	private int score;
	private int health;
	private int lives;
    
    public void gravitons ()
    {
        this.vertical_speed = (float) (this.vertical_speed * gravity);
        
        if (this.vertical_speed > Y_TERMINAL_VELOCITY)
        {
            this.vertical_speed = Y_TERMINAL_VELOCITY;
        }
        
        this.y = this.y + this.vertical_speed;
        
        
        
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

		this.setHorizontalSpeed((float) (this.getHorizontalSpeed() * getSpeedIncrease()));
	
	    if (this.getHorizontalSpeed() > X_MAX_SPEED)
	    {
	        this.setHorizontalSpeed(X_MAX_SPEED);
	    }
	    
	    this.x = this.x - this.getHorizontalSpeed();
		
	}
	
	public void Right()
	{
		this.setHorizontalSpeed((float) (this.getHorizontalSpeed() * getSpeedIncrease()));
		
	    if (this.getHorizontalSpeed() > X_MAX_SPEED)
	    {
	        this.setHorizontalSpeed(X_MAX_SPEED);
	    }
	    
	    this.x = this.x + this.getHorizontalSpeed();
	}
	
	public void StopRight()
	{
		this.setHorizontalSpeed ((float) (this.getHorizontalSpeed() / this.getSpeedIncrease()));
		this.x = this.x + this.getHorizontalSpeed();
		
		if (this.getHorizontalSpeed() == 0)
		{
		this.setHorizontalSpeed(1);
		}
		
		score++;
	}
	
	public void StopLeft()
	{
		this.setHorizontalSpeed ((float) (this.getHorizontalSpeed() / this.getSpeedIncrease()));
		this.x = this.x - this.getHorizontalSpeed();
		
		if (this.getHorizontalSpeed() == 0)
		{
		this.setHorizontalSpeed(1);
		}
	}
	
	public void StartJump()
	{
		
	}
	
	public void EndJump()
	{
		
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

	public float getHorizontalSpeed() {
		return horizontalSpeed;
	}

	public void setHorizontalSpeed(float horizontalSpeed) {
		this.horizontalSpeed = horizontalSpeed;
	}

	public double getSpeedIncrease() {
		return speedIncrease;
	}

	public void setSpeedIncrease(double speedIncrease) {
		this.speedIncrease = speedIncrease;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int i) {
		this.score = i;
	}
}

