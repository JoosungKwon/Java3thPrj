package com.newlecture.part1.ch3;

import java.util.Random;
import java.util.Scanner;

public class LottoApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Lotto lotto = new Lotto();
		lotto.nums = new int[6];

		main: while (true) {
//			------------------메인 화면-----------------------------------
			System.out.print("┌────────────────────────────────────┐\n");
			System.out.print("│              로또 복권               │\n");
			System.out.print("└────────────────────────────────────┘\n");
			System.out.println("1. 로또 번호 뽑기");
			System.out.println("2. 로또 번호 출력하기");
			System.out.println("3. 종료");
			System.out.print("선택> ");

			int menu = Integer.parseInt(scan.nextLine());

			switch (menu) {

			case 1: // 번호 뽑기
//				------------------입력 화면-----------------------------------
				System.out.print("┌────────────────────────────────────┐\n");
				System.out.print("│              번호 뽑기               │\n");
				System.out.print("└────────────────────────────────────┘\n");
				System.out.println("1. 자동");
				System.out.println("2. 수동");
				System.out.println("3. 뒤로가기");
				System.out.print("선택> ");

				menu = Integer.parseInt(scan.nextLine());

				switch (menu) {

				case 1:// 자동으로 뽑기
					autoInputLotto(lotto);
					break;
				case 2:// 수동으로 뽑기
					manualInputLotto(lotto);
					break;
				case 3:// 뒤로가기
					break;
				default: // 오타시 메인화면으로
					System.out.print("잘못 입력했습니다. 뒤로 되돌아 갑니다.");
				}

				break;

			case 2: // 번호 출력하기
				printLotto(lotto);
				break;
			case 3: // 메인 화면 종료
				break main;
			default: // 오타시 메인화면
				System.out.println("정확한 번호를 선택해주세요.");
			}
		} // while main
		System.out.println("프로그램이 종료됩니다.");
	} // func main

	static void autoInputLotto(Lotto lotto) {
		Scanner scan = new Scanner(System.in);
		
		// 뽑은 번호가 있다면 지워질 수 있음을 경고
		if(lotto.nums[lotto.nums.length-1] != 0) {
			System.out.println("이미 뽑으신 번호가 존재합니다. 새로 입력 받으시겠습니까? 뒤로가기는 0번 입력받으시려면 아무키나 눌러주세요");
			String button = scan.nextLine();
			if("0".equals(button)) return;
		}
		
		Random random = new Random();

		int[] arr = new int[45];
		for (int n = 1; n < 46; n++)
			arr[n - 1] = n;
		
//     ---------- 랜덤하게 섞기 --------------------
		for (int i = 0; i < 45; i++) {
			int random_num = random.nextInt(45);
			int temp = arr[i];
			arr[i] = arr[random_num];
			arr[random_num] = temp;
		}

		for (int i = 0; i < 6; i++)
			lotto.nums[i] = arr[i];
	}

	static void manualInputLotto(Lotto lotto) {
		Scanner scan = new Scanner(System.in);
		
		// 뽑은 번호가 있다면 지워질 수 있음을 경고
		if(lotto.nums[lotto.nums.length-1] != 0) { 
			System.out.println("이미 뽑으신 번호가 존재합니다. 새로 입력 받으시겠습니까? 뒤로가기는 0번 입력받으시려면 아무키나 눌러주세요");
			String button = scan.nextLine();
			if("0".equals(button)) return;
		}
		
		// 사용자에게 입력받기
		input: for (int i = 0; i < lotto.nums.length; i++) {
			
			System.out.print("번호를 입력해주세요 >");
			int num = Integer.parseInt(scan.nextLine());
			
			// 조건 체크 1(범위)
			if (1 > num || num > 45) {
				System.out.println("1~45번 사이의 번호를 선택해주세요.");
				i--;
				continue input;
			}
			
			// 조건 체크 2(중복)
			for (int j = 0; j < i; j++) {
				if (lotto.nums[j] == num) {
					System.out.println("이미 선택하신 번호입니다.");
					i--;
					continue input;
				}
			}
			
			lotto.nums[i] = num;
		}
	}
	
	static void printLotto(Lotto lotto) {

		if(lotto.nums[lotto.nums.length-1] == 0) { //예외처리
			System.out.println("번호를 먼저 뽑아주세요");
			return;
		}
		
//     ------------------ 정렬하기 ---------------------
		for (int i = 0; i < lotto.nums.length - 1; i++) {
			for (int j = 0; j < lotto.nums.length - 1 - i; j++) {
				if (lotto.nums[j] > lotto.nums[j + 1]) {
					int temp = lotto.nums[j];
					lotto.nums[j] = lotto.nums[j + 1];
					lotto.nums[j + 1] = temp;
				}
			}
		}
		
		// 출력
		for (int i = 0; i < lotto.nums.length-1; i++)
			System.out.printf("%d, ", lotto.nums[i]);
		System.out.printf("%d%n", lotto.nums[lotto.nums.length - 1]);
	}

}
