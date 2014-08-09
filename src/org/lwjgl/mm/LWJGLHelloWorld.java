package org.lwjgl.mm;

import static org.lwjgl.opengl.GL11.*;


import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class LWJGLHelloWorld {
	
	public LWJGLHelloWorld(){
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Whaddup");
			Display.create();
		
	} catch (LWJGLException e) {
		e.printStackTrace();
	}
		while(!Display.isCloseRequested()) {
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	public static void main(String[] args) {
			new LWJGLHelloWorld();
	

	}
}
