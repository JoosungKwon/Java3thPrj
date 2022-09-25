package com.newlecture.part3.ch4;

public class Board {
	
	private char[][] buf;
	private Omok[] omoks; 
	private int idx;
	private final int HEIGHT = 20;
	private final int WIDTH = 20;
	
	public Board() {
		buf = new char[HEIGHT][WIDTH];
		omoks = new Omok[HEIGHT*WIDTH];
		idx=0;
		init();
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

	public int put(Omok omok) {
		
		int x = omok.getX();
		int y = omok.getY();
		int color = omok.getColor();
		
		if(check(x,y))
			return -1;
		
		omoks[idx++] = omok;
		return 0;
		
	}	
	
	private boolean check(int new_x, int new_y) {
		
		for(int i=0; i<idx; i++) {
			
			int x = omoks[i].getX();
			int y = omoks[i].getY();
			
			if(new_x == x && new_y == y)
				return true;
		}
		
		return false;
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

	
	public void rePaint() {
		init();
		for(int i=0; i<idx; i++) {
			int x = omoks[i].getX();
			int y = omoks[i].getY();
			int color = omoks[i].getColor();
			buf[y][x] = (color == 0) ? '○':'●';
		}
	}
	
	public void rollback() {
		omoks[idx--] = null;
	}

	
	

}
