package com.newlecture.part3.ch6;

import java.awt.Frame;
import java.awt.Graphics;

public class GameFrame extends Frame{

	public static void main(String[] args) {
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(20, 20, 200, 200);
	}
}
