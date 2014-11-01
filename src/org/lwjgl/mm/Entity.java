package org.lwjgl.mm;

import org.newdawn.slick.Image;

/**this is an abstract class, this class never gets called but is extended to other classes like the player 
* class. other classes will use these methods and variables **/
public abstract class Entity {

	protected float jumpHeight = 3; //max jump height
	protected float gravity = 0.1f; //the force of the gravity
	
	//these values control x movement 
	protected float horizontalSpeed = 0.5f;
	protected float speedIncrease = 0.05f; 
	
	protected float x = 100; //x coordinate 
	protected float y = 100; //y coordinate

	protected float vertical_speed = 0.5f; // y coordinate speed
	protected float vertical_position;  //i dont think we need this
    
	//max speed
	protected final float Y_TERMINAL_VELOCITY = 20;
    protected final float X_MAX_SPEED = 6;
	
	
    protected int score; //maybe should be in player
    protected int health; // entity health
    protected int lives; //maybe should be in player
    
    /**
     * used to generate falling/gravity
     * @param image represents the image being used to apply gravity to 
     * @param collision represents the collision object used 
     */
    public void gravitons (Image image, Collision collision)
    {
        this.vertical_speed = (float) (this.vertical_speed + gravity);
        
        if (this.vertical_speed > Y_TERMINAL_VELOCITY)
        {
            this.vertical_speed = Y_TERMINAL_VELOCITY;
        }
        if(collision.bottomClear(getX(), getY(), image.getWidth(), image.getHeight()))
        this.y = this.y + this.vertical_speed;
        
        
        
        if (y > 400) y = 400;//keeps it on the level
    }
    
	//TODO entity should get generic left and right functions
    
    ////////////////////gets and sets///////////////////////////////////////
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

