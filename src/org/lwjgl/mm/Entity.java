package org.lwjgl.mm;

public class Entity {
	
float speed;
float x;
float y;

public void Up(){
	y= y+speed;
}

public void Down(){
	y= y-speed;
}

public void Left(){
	x= x-speed;
}

public void Right(){
	x= x+speed;
}
}

