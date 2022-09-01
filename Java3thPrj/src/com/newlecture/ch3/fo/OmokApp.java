package com.newlecture.ch3.fo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class OmokApp {
	
	private String[][] omokTable ;
	
	public OmokApp() {
		this(12);
	}
	public OmokApp(int size) {
		omokTable = new String[size][size];
		setting();
	}
	
	protected void game() {
		int x,y ;
		Scanner scan = new Scanner(System.in);
		
		/// 게임 시작 화면 
		System.out.print("┌────────────────────┐\n");
		System.out.print("│     Game Start     │\n");
		System.out.print("└────────────────────┘\n");
		
		//부가적인 화면 꾸미기 요소
//		System.out.print("오목 게임이 시작됩니다.");	
		
		display() ;
		
		
		
		
		// 게임이 진행되는 지점 
		String[] color = {"●","○"}; // 첫번째가 흑, 두번째가 백?
		int order = 0;
		main : while(true) {
			
			while(true) {
				try{
					System.out.print("놓으실 위치를 입력하세요: ");	
					String[] Line = scan.nextLine().split(" ");
					if(Line[0].equals("finish")) { // 탈출 조건
						break main;
					}
					y = Integer.parseInt(Line[0]);
					x = Integer.parseInt(Line[1]);
					break;
				} catch (Exception e) {
					System.out.println("오류입니다. 다시 입력해주세요");
					continue;
				}
			}		
			
			if(!(select(y-1,x-1,color[(order++)%2]))) {
				System.out.println("잘못된 위치에 입력하셨습니다. 다시 입력해주세요");
				order--;
				continue;
			};
			
//			
//			if(whoIsWin(y,x)==5) {
//				System.out.printf("%d 번 사용자가 승리하였습니다.! 축하드립니다.!%n",(order-1)%2);
//			}
			display() ;
			
			
			// 경기의 승패를 구하라
			
			
		}

	}
	
	
	private void setting() {
				int size = omokTable.length;
				// 모서리 작업
				omokTable[0][0] = "┌";
				omokTable[size-1][0] = "└";
				omokTable[0][size-1] = "┐";
				omokTable[size-1][size-1] = "┘";
				
				// 양 옆
				for(int i=0; i<size-2;i++) {
					omokTable[0][i+1] = "┬";
					omokTable[size-1][i+1] = "┴";
					omokTable[i+1][0] = "├";
					omokTable[i+1][size-1] = "┤";
					
				}
				
				// 몸통
				for(int y =0; y<size-2; y++) {
					for(int x = 0; x<size-2; x++) {
						omokTable[y+1][x+1]= "┼" ;
					}
				}
		
	}
	
	// 바둑판을 출력해주는 함수
	private void display() {
		
		for(int y=0; y<omokTable.length; y++) {
			for(int x=0; x<omokTable[0].length; x++) {
				System.out.printf("%s", omokTable[y][x]);
			}
			System.out.println();
		}
	}
	
	// 선택한 좌표에 돌을 놓는 함수
	private boolean select(int y, int x, String color) {
		int size = omokTable.length ;
		
		if( 0 > x || x >=size || 0 > y || y >=size) return false ; // 좌표 잘못 입력시
		if(omokTable[y][x]=="○"|| omokTable[y][x]=="●") return false ; // 같은 자리에 중복해서 둘시에
		
		omokTable[y][x] = color ;
		return true ;
	}

//	private int whoIsWin(int y, int x) {
//		//현재 둔 돌과 연결된 돌들의 개수를 찾는 함수
//		 String[][] temp = omokTable.clone();
//		 String color = temp[y][x] ;
//		 int cnt = 1;
//		 Queue<int[]> queue = new LinkedList<>(); 
//		 // 방향 8개를 다 확인하기
//	
//	
//		 return 0;
}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		

	
}


















