package com.newlecture.kwonjoosung.omok;

import java.util.Scanner;

public class BoardConsole {
	
	private Board board;
	private int turn;
	
	public BoardConsole() {
		board = new Board();
	}

	public void print() {
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
		
		int y = Integer.parseInt(line[0]);
		int x = Integer.parseInt(line[1]);
		int color = turn++ % 2;
		
		Omok omok = new Omok(x,y,color);
		
		board.put(omok);
		
	}
}
