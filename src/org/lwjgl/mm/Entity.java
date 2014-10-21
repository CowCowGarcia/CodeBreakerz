package org.lwjgl.mm;

/**this is an abstract class, this class never gets called but is extended to other classes like the player 
* class. other classes will use these methods and variables **/
public abstract class Entity {

	protected float jumpHeight = 3;
	protected float gravity = 0.1f;
	
	//these values control x movement 
	protected float horizontalSpeed = 0.5f;
	protected float speedIncrease = 0.05f; 
	
	protected float x = 100;
	protected float y = 100;

	protected float vertical_speed = 0.5f;
	protected float vertical_position;  
    protected final float Y_TERMINAL_VELOCITY = 20;
    protected final float X_MAX_SPEED = 6;
	
	
    protected int score;
    protected int health;
    protected int lives;
    
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
    
	//TODO entity should get generic left and right functions
    
    
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

