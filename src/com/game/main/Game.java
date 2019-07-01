package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private static final String TITLE = "Game version 0.0";
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	
	public Game() {
		handler = new Handler();
		
		new Window(WIDTH, HEIGHT, TITLE, this);
	}
	
	public synchronized void start() {
		thread = new Thread();
		thread .start();
		running = true;
		
		handler.addObject(new Player(150, 150, ID.Player));
		
		run();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running) {
				render();
			}
			frames ++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect((int)0, (int)0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	
	
	public static void main(String[] args) {
		new Game();
	}

}
