package com.newlecture.ch3.arr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

class App4 {
	public static void main(String[] args) throws IOException {

		int max = 3;

		int[] names = new int[max];
		int[] kors = new int[max];
		int[] engs = new int[max];
		int[] maths = new int[max];
		Scanner scan = new Scanner(System.in);

		int index = 0;

		EXIT: while (true) {

			System.out.println(" ┌───────────┐");
			System.out.println(" │           메인 메뉴        │");
			System.out.println(" └───────────┘\\n");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 출력");
			System.out.println("3. 성적 읽기");
			System.out.println("4. 성적 저장");
			System.out.println("5. 프로그램 종료\\n");
			System.out.printf("선택 > _ ");
			int menu = scan.nextInt();

			switch (menu) {

			case 1:
				// =============== 성적 입력 부분 ================

				System.out.println(" ┌───────────┐");

				System.out.println(" │          성적 입력         │");

				System.out.println(" └───────────┘\\n");

				int go = 0;

				do {

					int kor;
					int eng;
					int math;
					// 국어성적 입력
					do {

						System.out.print("\\n국어: ");
						kor = scan.nextInt();
						if (kor < 0 || kor > 100)
							System.out.println("성적의 범위(0~100)를 벗어났습니다");
					} while (kor < 0 || kor > 100);

					do {

						System.out.print("\\n영어: ");
						eng = scan.nextInt();
						if (eng < 0 || eng > 100)
							System.out.println("성적의 범위(0~100)를 벗어났습니다");
					} while (eng < 0 || eng > 100);

					do {

						System.out.print("\\n수학: ");
						math = scan.nextInt();
						if (math < 0 || math > 100)
							System.out.println("성적의 범위(0~100)를 벗어났습니다");
					} while (math < 0 || math > 100);

					if (index >= max) {
						int[] tempkors = new int[max + 3];
						for (int i = 0; i < max; i++)
							tempkors[i] = kors[i];

						int[] tempengs = new int[max + 3];
						for (int i = 0; i < max; i++)
							tempengs[i] = engs[i];

						int[] tempmaths = new int[max + 3];
						for (int i = 0; i < max; i++)
							tempmaths[i] = maths[i];

						kors = tempkors;
						engs = tempengs;
						maths = tempmaths;
						max = max + 3;
					}

					kors[index] = kor;
					engs[index] = eng;
					maths[index] = math;

					index++;

					System.out.print("계속입력하시겠습니까?(1:예, 0.아니요)");
					go = scan.nextInt();

				} while (go == 1);
				System.out.println();
				System.out.println("프로그램 종료");
				break;

			case 2:
			// ============== 성적 출력부분 ===============
			{

				System.out.println(" ┌───────────┐");
				System.out.println(" │           성적 출력        │");
				System.out.println(" └───────────┘\\n");

				System.out.printf("%10s%10s%10s%10s%10s\\n", "kor", "eng", "math", "total", "avg");

				for (int i = 0; i < index; i++) {
					int total = kors[i] + engs[i] + maths[i];
					float avg = total / 3.0f;

					System.out.printf("%10d%10d%10d%12d%11.2f\\n", kors[i], engs[i], maths[i], total, avg);
				}
			}
				break;

			// ============== 성적 읽기 ==============

			case 3: {
				FileInputStream fis = new FileInputStream("res\\\\score.csv");
				Scanner fscan = new Scanner(fis);

				fscan.nextLine();

				for (int i = 0; i < 3; i++) {
					String[] tokens = fscan.nextLine().split(",");// split 나눈다 , 을 기준으로
					String name = tokens[0];
					int kor = Integer.parseInt(tokens[0]);
					int eng = Integer.parseInt(tokens[1]);
					int math = Integer.parseInt(tokens[2]);

					kors[i] = kor;
					engs[i] = eng;
					maths[i] = math;
				}

				fscan.close();
				fis.close();
				System.out.println("\\n성적을 읽어 왔습니다");
			}
				break;

			// =============== 성적 저장 ===============
			case 4: {

				FileOutputStream fos = new FileOutputStream("res\\\\score2.csv");
				PrintStream fprin = new PrintStream(fos);

				for (int i = 0; i < 3; i++) {
					fprin.print(kors[i]);
					fprin.print(engs[i]);
					fprin.print(maths[i]);
					fprin.println();

				}
				fprin.close();
				fos.close();
				System.out.println("\\n성적을 저장 했습니다");

			}

				break;

			// =============== 프로그램 끝 ===============
			case 5:
				System.out.println("\\n프로그램을 종료 합니다");
				break EXIT;

			default:
				System.out.println("\\n1~3번만 입력하세요");
				break;
			}
		}
	}
}
