package org.lwjgl.mm;

import org.lwjgl.input.Keyboard;

public class Controller {
	boolean keyDownUP = Keyboard.isKeyDown(Keyboard.KEY_UP);
	boolean keyDownDOWN = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
	boolean keyDownLEFT = Keyboard.isKeyDown(Keyboard.KEY_LEFT);
	boolean keyDownRIGHT = Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
}
