package org.lwjgl.mm;

import org.newdawn.slick.Image;

/**
 * handles everything player specific and inherits from the entity class, this class takes in an image and an instance of collision, this is so 
 * the player class can check its own collision. the movement for the player is different from how everything els might move so player takes care of its own movement too.
 * this class is set up so that there can be multiple instances of player each with different images
 *   
 * @author cfrancois
 *
 */
public class Player extends Entity
{
	private Image playerImg;//this is where the image for the player will be stored
	private Collision collision; //this is the instance of collision that the player will be colliding against 
	
	/**
	 * constructor, 
	 * @param pimg represents the player image
	 * @param coll represents the instance of the collision object used for collision 
	 */
	public Player(Image pimg, Collision coll)
	{
		playerImg = pimg;
		collision = coll;
	}
	
	/**
	 * this is the jump method the player uses
	 * @param s represents the speed of the jump
	 */
	public void Jump(int s)
	{
		//TODO this whole thing needs to be fixed
		
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
	    if (collision.leftClear(getX(), getY(), playerImg.getWidth(), playerImg.getHeight(), getHorizontalSpeed()))//check collision
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
	    if(collision.rightClear(getX(),getY(), playerImg.getWidth(), playerImg.getHeight(), getHorizontalSpeed()))//check collision
	    x = x + horizontalSpeed;
	}
	
	/**
	 * this is the slowdown function used when the character stops
	 */
	public void StopRight()
	{
		horizontalSpeed = horizontalSpeed - speedIncrease *2;
		
		if (horizontalSpeed < 0) horizontalSpeed = 0f;
		
		if(collision.rightClear(getX(), getY(), playerImg.getWidth(), playerImg.getHeight(), getHorizontalSpeed()))//check collision
		x = x + horizontalSpeed;
		
		
		
		score++;
	}
	
	/**
	 * this is the slowdown function used when the character stops
	 */
	public void StopLeft()
	{
		horizontalSpeed = horizontalSpeed - speedIncrease*2;
		
		if (horizontalSpeed < 0) horizontalSpeed = 0f;
		
		if (collision.leftClear(getX(), getY(), playerImg.getWidth(), playerImg.getHeight(), getHorizontalSpeed()))//check collision
		x = x - horizontalSpeed;
	}
}

