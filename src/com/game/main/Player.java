package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	Player(float x, float y, ID id) {
		super(x, y, id);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 50, 50);
	}

	public void tick() {
		x += velX;
		y += velY;
	}
	

}
