package com.mark.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.mark.game.main.Resources;
import com.mark.game.main.GameMain;

public class MenuState extends State {
	
	private int currentSelection = 0;

	@Override
	public void init() {
		System.out.println("Entered MenuState");
	}

	@Override
	public void update(float delta) {
		// Do Nothing
	}

	@Override
	public void render(Graphics g) {
		// Draws Resoruces.welcome to the screen at x = 0, y = 0
		g.drawImage(Resources.welcome, 0, 0, null);
		if (currentSelection == 0)
		{
			g.drawImage(Resources.selector, 335, 241, null);
		} else {
			g.drawImage(Resources.selector, 335, 291, null);
		}
	}

	@Override
	public void onClick(MouseEvent e) {
		System.out.println("On Click!");
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		System.out.println("On KeyPress!");
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER)
		{
			if (currentSelection == 0)
			{
				setCurrentState(new PlayState());
			} else if (currentSelection == 1)
			{
				GameMain.sGame.exit();
			}
		} else if (key == KeyEvent.VK_UP) {
			currentSelection = 0;
		} else if (key == KeyEvent.VK_DOWN) {
			currentSelection = 1;
		}
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
		System.out.println("On KeyRelease!");
	}

}

