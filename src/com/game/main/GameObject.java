package com.game.main;

import java.awt.Graphics;

public abstract class GameObject {
	
	protected float x, y;
	protected float velX, velY;
	private ID id;
	
	GameObject(float x, float y, ID id){
		this.x = x;
		this.y = y;
		this.setId(id);
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
