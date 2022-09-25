package com.newlecture.kwonjoosung.omok;

import java.util.Scanner;

public class OmokApp {
	
		BoardConsole console;
	
	public OmokApp() {
		
		console = new BoardConsole();
	}
	
	public void run() {
		// 게임 흐름 진행하기 
		
		
		while (true) {
			
			console.print();
			console.inputOmok();
			console.print();
			console.inputOmok();
			console.print();
			break;
			
		}
		
		int size=0;
		Scanner scan = new Scanner(System.in);
		
		// 안전한 입력을 받아서 사이즈 넘겨 주기
		// 잘못된 값 입력시 디폴트로 설정?
		while(true) {
			try{
				System.out.print("오목판의 사이즈를 입력하세요(12 ~ 100): ");
				size = Integer.parseInt(scan.nextLine());
				if(size < 12  || 100 < size) {
					System.out.println("입력 범위를 넘어갔습니다. 다시 입력해주세요");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("오류입니다. 다시 입력해주세요");
			}
		}
	}

}
