package com.newlecture.part3.ch4;

import java.util.Scanner;

public class BoardConsole {
	
	private Board board;
	private int turn;
	
	public BoardConsole() {
		board = new Board();
		turn = 0;
	}

	public void print() {
		
		board.rePaint();
		
		int height = board.getHeight();
		int width = board.getWidth();
		
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++)
				System.out.print(board.get(y,x));
			System.out.println();
		}
	}

	public void inputOmok() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("좌표를 입력하세요(행 열)>");
		String[] line = input.nextLine().split(" ");
		if("무르기".equals(line[0])) {
			rollbackOmok();
			return;
		}
		
		int y = Integer.parseInt(line[0]);
		int x = Integer.parseInt(line[1]);
		int color = turn++ % 2;
		
		Omok omok = new Omok(x,y,color);
		
		int result = board.put(omok);
		
		if (result == -1) {
			System.out.println("중복된 위치에 두셨습니다.");
			turn--;
		}
	}
	
	public void rollbackOmok() {
		board.rollback();
		turn--;
	}

}
