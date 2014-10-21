package org.lwjgl.mm;

public class Player extends Entity
{
	public Player()
	{
		
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
}

