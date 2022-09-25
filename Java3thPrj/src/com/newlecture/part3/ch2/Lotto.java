package com.newlecture.part3.ch2;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	int[] nums;

	public void input() {

		Scanner scan = new Scanner(System.in);

		if (nums != null) {
			System.out.println("이미 뽑으신 번호가 존재합니다. 새로 입력 받으시겠습니까? 뒤로가기는 0번 입력받으시려면 아무키나 눌러주세요");
			String button = scan.nextLine();
			if ("0".equals(button))
				return;
		}

		this.nums = new int[6];

		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            로또 입력           │\n");
		System.out.print("└─────────────────────────────┘\n");

		input: for (int i = 0; i < 6; i++) {

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
				if (nums[j] == num) {
					System.out.println("이미 선택하신 번호입니다.");
					i--;
					continue input;
				}
			}

			nums[i] = num;

		}

	}

	public void print() {

		if (nums == null) { // 예외처리
			System.out.println("번호를 먼저 뽑아주세요");
			return;
		}

		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            로또 출력           │\n");
		System.out.print("└─────────────────────────────┘\n");

		System.out.println("로또 번호는 :");
		for (int i = 0; i < 5; i++)
			System.out.printf("%d,", nums[i]);
		System.out.printf("%d%n", nums[5]);

	}

	public void sort() {

		if (nums == null) { // 예외처리
			System.out.println("번호를 먼저 뽑아주세요");
			return;
		}

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5 - i; j++)
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
		System.out.println("로또 번호 정렬이 완료되었습니다.");
	}

	public void autoSetting() {

		Scanner scan = new Scanner(System.in);

		if (nums != null) {
			System.out.println("이미 뽑으신 번호가 존재합니다. 새로 입력 받으시겠습니까? 뒤로가기는 0번 입력받으시려면 아무키나 눌러주세요");
			String button = scan.nextLine();
			if ("0".equals(button))
				return;
		}

		Random rand = new Random();

		this.nums = new int[6];
		int[] randomArr = new int[45];

		for (int i = 0; i < 45; i++)
			randomArr[i] = i + 1;

		for (int j = 0; j < 1000; j++) {
			int rand_num = rand.nextInt(45);
			int temp;
			temp = randomArr[0];
			randomArr[0] = randomArr[rand_num];
			randomArr[rand_num] = temp;
		}

		for (int j = 0; j < 6; j++)
			this.nums[j] = randomArr[j];

		System.out.println("로또 번호가 자동 생성 되었습니다.");
	}

}
