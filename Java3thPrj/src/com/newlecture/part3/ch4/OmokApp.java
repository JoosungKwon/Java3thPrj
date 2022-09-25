package com.newlecture.part3.ch4;

public class OmokApp {

	public static void main(String[] args) {

		BoardConsole console = new BoardConsole();
		console.print();
		
		while (true) {
			console.inputOmok();
			console.print();
		}

	}

}
