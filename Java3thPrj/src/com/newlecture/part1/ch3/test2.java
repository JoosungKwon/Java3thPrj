package com.newlecture.part1.ch3;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input =1;
		String player1;
		String player2;
		String player1Word ="";
		String player2Word ="";
		
		// 1번 플레이어 setting
		System.out.println("1번 플레이어 이름을 입력하세요.");
		player1 = sc.next();
		
		// 2번 플레이어 setting
		System.out.println("2번 플레이어 이름을 입력하세요.");
		player2 = sc.next();
		
		while(input==1) {
		//제시어 출력
		
		//승리조건 달기.
		int turn =0;
		int cnt1 =0;
		int cnt2 =0;
		
		EXIT:
		while(cnt1<=3||cnt2<=3) {
			do {
				// 1번 플레이어 단어를 입력 받음.
				System.out.println("단어를 입력하세요.");
				System.out.printf("%s : ",player1);
				player1Word = sc.next();
				
				// 1번 플레이어의 단어를 출력 받아서 표시
				if(turn==0) {
					System.out.println(player1Word);
					break;
				}
				else if(player1Word.charAt(0) == player2Word.charAt(player2Word.length()-1))
					System.out.println(player1Word);
				else {
					System.out.println("잘못된 단어입니다. 다시입력해주세요.");
					cnt1++;
				}
				if(cnt1>=3)
					break EXIT;
			}while(player1Word.charAt(0) != player2Word.charAt(player2Word.length()-1));
			
			do {
				System.out.println("단어를 입력하세요.");
				System.out.printf("%s : ",player2);
				player2Word = sc.next();
				
				if(player1Word.charAt(player1Word.length()-1) == player2Word.charAt(0)) 
					System.out.println(player2Word);
				else {
					System.out.println("잘못된 단어입니다. 다시입력해주세요.");
					cnt2++;
				}
				
				if(cnt2>=3)
					break EXIT;
				
			}while(player1Word.charAt(player1Word.length()-1) != player2Word.charAt(0));
			
			turn++;
		}
		
		if(cnt1<cnt2)
			System.out.println("1번 플레이어 승리");
		if(cnt1>cnt2)
			System.out.println("2번 플레이어 승리");
		
		
		System.out.println("다시 하시겠습니까? 1.예  2.아니요");
		input = sc.nextInt();
		}
	}

}
