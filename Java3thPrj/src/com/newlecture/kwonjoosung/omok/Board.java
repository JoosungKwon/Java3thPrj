package com.newlecture.kwonjoosung.omok;

public class Board {
	
	private char[][] buf;
	private Omok[] omoks;
//	private int cnt;
	private final int HEIGHT = 20;
	private final int WIDTH = 20;
	
	public Board() {
		buf = new char[HEIGHT][WIDTH];
		omoks = new Omok[HEIGHT*WIDTH];
		init();
//		cnt=0;
	}
	
	private void init() {
		
		// 모서리 작업
		buf[0][0] = '┌';
		buf[HEIGHT - 1][0] = '└';
		buf[0][WIDTH - 1] = '┐';
		buf[HEIGHT - 1][WIDTH - 1] = '┘';

		// 위 아래
		for (int i = 0; i < WIDTH - 2; i++) {
			buf[0][i + 1] = '┬';
			buf[WIDTH - 1][i + 1] = '┴';
		}
		
		// 양 옆
		for (int i = 0; i < HEIGHT - 2; i++) {
			buf[i + 1][0] = '├';
			buf[i + 1][WIDTH - 1] = '┤';
		}

		// 몸통
		for (int y = 0; y < HEIGHT - 2; y++) {
			for (int x = 0; x < WIDTH - 2; x++) {
				buf[y + 1][x + 1] = '┼';
			}
		}
	}

	public void put(Omok omok) {
		
		int x = omok.getX();
		int y = omok.getY();
		int color = omok.getColor();
		
		buf[y][x] = (color == 0) ? '○':'●';
//		omoks[cnt++] = omok;
		
	}	
	
	public char get(int y, int x) {
		return buf[y][x];
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}


	
	

}
