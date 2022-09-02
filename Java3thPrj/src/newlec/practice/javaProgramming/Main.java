package newlec.practice.javaProgramming;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size ;
		Scanner scan = new Scanner(System.in);
		
		// 안전한 입력을 받아서 사이즈 넘겨 주기
		// 잘못된 값 입력시 디폴트로 설정?
		while(true) {
			try{
				System.out.print("오목판의 사이즈를 입력하세요(12 ~ 100): ");
				size = Integer.parseInt(scan.nextLine());
				if(size < 12  || 100 < size) {
					System.out.print("입력 범위를 넘어갔습니다. 다시 입력해주세요");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("오류입니다. 다시 입력해주세요");
			}
		}
		// 앞단 화면 만들기

		OmokApp omokGame = new OmokApp(size) ;
		omokGame.game();

	}

}
