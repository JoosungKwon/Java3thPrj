package com.newlecture.part3.ch4;

public class Omok {
	
	private int x;
	private int y;
	public int color;
	
	public Omok() {
		this(0,0,0);
	}
	
	public Omok(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getColor() {
		return color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	

}
