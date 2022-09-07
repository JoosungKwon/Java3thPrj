package com.newlecture.ch3.arr;

import java.util.Scanner;

public class omok {

	public static void main(String[] args) {
		
		
		final int HIGHT = 12;
		final int WIDTH = 12;
		
		char[][] board = new char[HIGHT][WIDTH];

		// 몸통 채우기
		for (int y = 0; y < HIGHT - 2; y++) {
			for (int x = 0; x < WIDTH - 2; x++) {
				board[y + 1][x + 1] = '┼';
			}
		}
		
		// 각 모서리
		board[0][0] = '┌';
		board[HIGHT - 1][0] = '└';
		board[0][WIDTH - 1] = '┐';
		board[HIGHT - 1][WIDTH - 1] = '┘';
		
		
		// 위 아래
		for (int i = 0; i < WIDTH - 2; i++) {
			board[0][i + 1] = '┬';
			board[HIGHT - 1][i + 1] ='┴';
		}
		
		
		// 양 옆
		for (int i = 0; i < HIGHT - 2; i++) {	
			board[i + 1][0] = '├';
			board[i + 1][WIDTH - 1] = '┤';
		}

		
		
		
		Scanner input = new Scanner(System.in);
		print(board,HIGHT,WIDTH);
		
		while(true) {
			System.out.print("x y> ");
			int y = input.nextInt(); // stringtokenizer?
			int x = input.nextInt();
			input.nextLine() ;
			if(y >= HIGHT && y<0 && x>=WIDTH && x<0) {
				System.out.println("칸을 벗어난 입력입니다.");
				continue;
			}
			if(board[y][x]!='●') {
				board[y][x] = '●';
				print(board, HIGHT,WIDTH);
			}
			else
				System.out.println("오류: 중복된 곳에 둘 수 없습니다.");
			
		}
		
	}
	
	public static void  print(char[][] board, int HIGHT, int WIDTH) {
		
		for (int y = 0; y < HIGHT; y++) {
			for (int x = 0; x < WIDTH; x++) {
				System.out.printf("%c", board[y][x]);
			}
			System.out.println();
		}
		
	}

}
