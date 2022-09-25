package com.newlecture.kwonjoosung.omok;

public class Omok {
	
	private int x;
	private int y;
	private int color;
	
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

}
