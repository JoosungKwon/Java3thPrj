package com.newlecture.part3.ch1;

import java.util.Scanner;

public class Omok {
	
	private int x;
	private int y;
	private int color;

	public void input() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("놓으실 위치를 입력하세요: ");
		
		String[] line = input.nextLine().split(" ");
		
		this.x = Integer.parseInt(line[0]);
		this.y = Integer.parseInt(line[1]);
		this.color = (this.color + 1) / 2;
	}
	
	public int getX() { return x;}
	
	public int getY() { return y;}
	
	public int getColor() { return color;}
	
}
