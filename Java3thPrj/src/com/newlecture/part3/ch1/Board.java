package com.newlecture.part3.ch1;

public class Board {
	
	int width;
	int height;
	char[][] buf;

	public void init() {
		this.width = 20;
		this.height = 20;
		this.buf = new char[height][width];
		setting();
	}

	private void setting() {
		
		// 모서리 작업
		buf[0][0] = '┌';
		buf[height - 1][0] = '└';
		buf[0][width - 1] = '┐';
		buf[height - 1][width - 1] = '┘';

		// 위 아래
		for (int i = 0; i < width - 2; i++) {
			buf[0][i + 1] = '┬';
			buf[height - 1][i + 1] = '┴';
		}
		
		// 양 옆
		for (int i = 0; i < height - 2; i++) {
			buf[i + 1][0] = '├';
			buf[i + 1][width - 1] = '┤';
		}

		// 몸통
		for (int y = 0; y < height - 2; y++) {
			for (int x = 0; x < width - 2; x++) {
				buf[y + 1][x + 1] = '┼';
			}
		}
		
	}

	public void print() {
		
		if(width == 0) {
			System.out.println("오목판을 먼저 생성해주세요.");
			return;
		}
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				System.out.printf("%s", buf[y][x]);
			}
			System.out.println();
		}
		
	}

	public void put(Omok omok) {
		
		int x = omok.getX();
		int y = omok.getY();
		int color = omok.getColor();
		
		buf[x][y] = (color == 1) ? '○' : '●';
	}

}
