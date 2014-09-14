package org.lwjgl.mm;

/**this is an abstract class, this class never gets called but is extended to other classes like the player 
* class. other classes will use these methods and variables **/
public abstract class Entity {

	private float jumpHeight = 3;
	private float gravity = 0.1f;
	
	//these values control x movement 
	private float horizontalSpeed = 0.5f;
	private float speedIncrease = 0.05f; 
	
	protected float x = 100;
	protected float y = 100;

	float vertical_speed = 0.5f;
    float vertical_position;  
    private float Y_TERMINAL_VELOCITY = 20;
    private float X_MAX_SPEED = 6;
	
	
	private int score;
	private int health;
	private int lives;
    
    public void gravitons ()
    {
        this.vertical_speed = (float) (this.vertical_speed + gravity);
        
        if (this.vertical_speed > Y_TERMINAL_VELOCITY)
        {
            this.vertical_speed = Y_TERMINAL_VELOCITY;
        }
        
        this.y = this.y + this.vertical_speed;
        
        
        
        if (y > 400) y = 400;//keeps it on the level
    }
    
	public void Jump(int s)
	{
		/*this.vertical_speed = this.vertical_speed + gravity;
    if (this.vertical_speed > Y_TERMINAL_VELOCITY)
    {
        this.vertical_speed = Y_TERMINAL_VELOCITY;
    }
    this.y = this.y - this.vertical_speed;*/
    y= y+ s;
	}

	/**while left is being called changes x coordinate by the changing horizontal speed **/
	public void Left()
	{	
		//the horizontal speed gets increased
		horizontalSpeed = horizontalSpeed + speedIncrease;
	
		//keeps horizontal speed from going over max speed
	    if (horizontalSpeed > X_MAX_SPEED) horizontalSpeed = X_MAX_SPEED;
	    
	    // decreases x coordinate by the horizontal speed
	    x = x - horizontalSpeed;
		
	}

	/**while right is being called changes x coordinate by the changing horizontal speed **/
	public void Right()
	{
		//the horizontal speed gets increased
		horizontalSpeed = horizontalSpeed + speedIncrease;
		
		//keeps horizontal speed from going over max speed
	    if (horizontalSpeed > X_MAX_SPEED) horizontalSpeed = X_MAX_SPEED;
	    
	    // increases x coordinate by the horizontal speed
	    x = x + horizontalSpeed;
	}
	
	public void StopRight()
	{
		horizontalSpeed = horizontalSpeed - speedIncrease *2;
		
		if (horizontalSpeed < 0) horizontalSpeed = 0f;
		
		x = x + horizontalSpeed;
		
		
		
		score++;
	}
	
	public void StopLeft()
	{
		horizontalSpeed = horizontalSpeed - speedIncrease*2;
		
		if (horizontalSpeed < 0) horizontalSpeed = 0f;
		
		x = x - horizontalSpeed;
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

	public void setSpeedIncrease(float speedIncrease) {
		this.speedIncrease = speedIncrease;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int i) {
		this.score = i;
	}
	
	public void setVerticalSpeed(float s)
	{
		vertical_speed = s;
	}
}

