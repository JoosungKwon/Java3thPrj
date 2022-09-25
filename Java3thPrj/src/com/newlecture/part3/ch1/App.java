package com.newlecture.part3.ch1;

public class App {

	public static void main(String[] args) {
		
		// 1. 절차가 위주가 되고 데이터 구조와 함수가 사용되는 방법
		// 오목판을 출력한다.
//		printBoard();
//		// 사용자로부터 오목을 입력 받는다.
//		Omok omok = inputOmok();
//		// 오목판에 오목을 둔다.
//		putOmokonBoard(?,omok);
//		// 오목판을 출력한다.
//		printBoard();
		
		
		// 객체지햐 방법 -> 구성이 있어야한다.
		
		Board board = new Board();
		Omok omok = new Omok();
		
		board.init();
		// 오목판을 출력한다.
		board.print();
		// 사용자로부터 오목을 입력 받는다.
		omok.input();
		// 오목판에 오목을 둔다.
		board.put(omok);
		// 오목판을 출력한다.
		board.print();
		
	}

}
