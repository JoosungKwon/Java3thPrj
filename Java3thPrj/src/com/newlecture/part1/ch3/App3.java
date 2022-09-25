package com.newlecture.part1.ch3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class App3 {

	public static void main(String[] args) throws IOException {

		int max = 3;
		int[] numbers = new int[max];
		int[] kors = new int[max];
		int[] engs = new int[max];
		int[] maths = new int[max];

		int go = 0;
		int index = 0;
		int index2 = 0;
		int number = 1;

		Scanner scan = new Scanner(System.in);

		// 성적 입력

		System.out.println("┌──────────────┐");
		System.out.println("│       시   험   성   적   입   력    │");
		System.out.println("└──────────────┘");
		System.out.println();

		do {

			int kor;
			int eng;
			int math;


			//국어성적입력
			do {
				System.out.printf("\t국어성적 > ");
				kor = scan.nextInt();
				if (kor < 0 || kor > 100)
					System.out.println("성적의 범위 (0~100) 를 벗어났습니다");
			} while (kor < 0 || kor > 100);

			//영어성적입력	

			do {
				System.out.printf("\t영어성적 > ");
				eng = scan.nextInt();
				if (eng < 0 || eng > 100)
					System.out.println("성적의 범위 (0~100) 를 벗어났습니다");
			} while (eng < 0 || eng > 100);

			//수학성적입력

			do {
				System.out.printf("\t수학성적 > ");
				math = scan.nextInt();
				if (math < 0 || math > 100)
					System.out.println("성적의 범위 (0~100) 를 벗어났습니다");
			} while (math < 0 || math > 100);

			if (index >= max) {

				int[] temp_kor = new int[max + 3];
				int[] temp_eng = new int[max + 3];
				int[] temp_math = new int[max + 3];
				int[] temp_number = new int[max + 3];

				for (int i = 0; i < max; i++) {
					temp_kor[i] = kors[i];
					temp_eng[i] = engs[i];
					temp_math[i] = maths[i];
					temp_number[i] = numbers[i];

				}

				kors = temp_kor;
				engs = temp_eng;
				maths = temp_math;
				numbers = temp_number;
				max = max + 3;

			}

			kors[index] = kor;
			engs[index] = eng;
			maths[index] = math;
			numbers[index] = number;

			index++;
			number++;

			//더 할거니?		

			System.out.print("계속 입력하시겠습니까?(1. 예   2. 아니요)");
			go = scan.nextInt();

		} while (go == 1);
		index2 = index;

		// 성적 출력

		System.out.println("┌────────────────────────────────────────────┐");
		System.out.println("│                성   적   출   력              │");
		System.out.println("└────────────────────────────────────────────┘");
		System.out.println();

		System.out.printf("\t%10s%10s%10s%10s%10s%10s\n", "몇번째", "kor", "eng", "math", "평균", "총점");

		for (int i = 0; i < index; i++) {
			int total = kors[i] + engs[i] + maths[i];
			float avg = total / 3.0f;

			System.out.printf("\t%10d%10d%10d%10d%16.2f%11d\n", numbers[i], kors[i], engs[i], maths[i], avg, total);
		}

		//성적 수정

		System.out.println("┌────────────────────────────────────────────┐");
		System.out.println("│                성   적   수   정              │");
		System.out.println("└────────────────────────────────────────────┘");
		System.out.println();

		System.out.println("수정하고싶은거 몇번째?");
		int n = scan.nextInt();

		System.out.println("국어 >");
		kors[n - 1] = scan.nextInt();
		System.out.println("영어 >");
		engs[n - 1] = scan.nextInt();
		System.out.println("수학 >");
		maths[n - 1] = scan.nextInt();

		// 성적 출력

		System.out.println("┌────────────────────────────────────────────┐");
		System.out.println("│                성   적   출   력              │");
		System.out.println("└────────────────────────────────────────────┘");
		System.out.println();

		System.out.printf("\t%10s%10s%10s%10s%10s%10s\n", "몇번째", "kor", "eng", "math", "평균", "총점");

		for (int i = 0; i < index; i++) {
			int total = kors[i] + engs[i] + maths[i];
			float avg = total / 3.0f;
			System.out.printf("\t%10d%10d%10d%10d%16.2f%11d\n", numbers[i], kors[i], engs[i], maths[i], avg, total);
		}

		// 성적 수정
		System.out.println("┌────────────────────────────────────────────┐");
		System.out.println("│                성   적   삭   제              │");
		System.out.println("└────────────────────────────────────────────┘");
		System.out.println();

		System.out.println("삭제하고싶은거 몇번째?");
		int k = scan.nextInt();

		for (int i = 0; i < index + 1 - k; i++) {

			kors[i + k - 1] = kors[i + k];
			engs[i + k - 1] = engs[i + k];
			maths[i + k - 1] = maths[i + k];
			numbers[i + k - 1] = numbers[i + k];
		}

		// 마지막 줄 삭제

		int[] temp_kor = new int[index - 1];
		int[] temp_eng = new int[index - 1];
		int[] temp_math = new int[index - 1];
		int[] temp_number = new int[index - 1];

		for (int i = 0; i < index - 1; i++) {
			temp_kor[i] = kors[i];
			temp_eng[i] = engs[i];
			temp_math[i] = maths[i];
			temp_number[i] = numbers[i];

		}

		kors = temp_kor;
		engs = temp_eng;
		maths = temp_math;
		numbers = temp_number;
		index2 = index - 1;

		// 성적 출력

		System.out.println("┌────────────────────────────────────────────┐");
		System.out.println("│                성   적   출   력              │");
		System.out.println("└────────────────────────────────────────────┘");
		System.out.println();

		System.out.printf("\t%10s%10s%10s%10s%10s%10s\n", "몇번째", "kor", "eng", "math", "평균", "총점");

		for (int i = 0; i < index2; i++) {
			int total = kors[i] + engs[i] + maths[i];
			float avg = total / 3.0f;
			System.out.printf("\t%10d%10d%10d%10d%16.2f%11d\n", numbers[i], kors[i], engs[i], maths[i], avg, total);
		}

	}

}