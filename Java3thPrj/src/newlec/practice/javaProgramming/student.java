package newlec.practice.javaProgramming;

import java.io.IOException;
import java.util.Scanner;

/**
 * < 성적 관리 프로그램 > 파일명: Program.java 1번: 국영수 점수 입력, 2번: 국영수 점수 출력, 3번: 국영수 점수 읽기,
 * 4번: 국영수 점수 저장, 5번: 프로그램 종료
 * 
 * @author ict04-11
 */
public class student {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in); // 기본 입출력

		int max = 3; // 디폴트 사이즈
		int idx = 0; // 현재 크기(size)

		int[] kors = new int[max]; // 국어
		int[] engs = new int[max]; // 영어
		int[] maths = new int[max];// 수학

		// ============== 프로그램 실행 ===================================================
		main: while (true) { // case 5번에서 중단

			// ============== 메인 화면 ===========================================
			System.out.print("┌─────────────────────────────────────────┐\n");
			System.out.print("│       	성적 관리 프로그램		    │\n");
			System.out.print("└─────────────────────────────────────────┘\n");
			System.out.print("\t\t1. 성적 입력 \n");
			System.out.print("\t\t2. 성적 출력 \n");
			System.out.print("\t\t3. 성적 읽기 \n");
			System.out.print("\t\t4. 성적 저장 \n");
			System.out.print("\t\t4. 성적 수정 \n");
			System.out.print("\t\t4. 성적 삭제 \n");
			System.out.print("\t\t5. 프로그램 종료 \n");
			System.out.print("\t\t선택 > ");

			int menu = Integer.parseInt(input.nextLine()); // 사용자가 선택한 메뉴

			switch (menu) { // 사용자가 선택한 메뉴에 따른 기능 처리

			case 1: // ======================== 성적 입력 ==================================

				// ============== 입력 화면 ==============================================
				System.out.print("┌─────────────────────────────────────────┐\n");
				System.out.print("│       	  성적 입력		    │\n");
				System.out.print("└─────────────────────────────────────────┘\n");

				String button = "1"; // 반복 선택 버튼
				do {

					if (idx == max) { // 현재 크기와 배열에 최대 길이가 같다면 -> 배열이 가득찼다면

						// 국어, 영어, 수학 각각 임시로 저장하기 위한 배열 생성
						int[] temp_kor = new int[max + 3];
						int[] temp_eng = new int[max + 3];
						int[] temp_math = new int[max + 3];

						// 내용을 옮겨 담은 후 copy
						for (int i = 0; i < idx; i++) {
							temp_kor[i] = kors[i];
							temp_eng[i] = engs[i];
							temp_math[i] = maths[i];
						}

						// copy 작업
						kors = temp_kor;
						engs = temp_eng;
						maths = temp_math;

					} // 동적으로 배열의 길이가 증가함

					// ------------------------------ 국어 입력 ------------------------------
					int kor;
					do { // 입력 범위 조건 검사
						System.out.print("\n국어: ");
						kor = Integer.parseInt(input.nextLine());
						if (kor < 0 || kor > 100)
							System.out.println("성적의 범위(0~100)를 벗어났습니다");
					} while (kor < 0 || kor > 100);
					kors[idx] = kor;

					// ------------------------------ 영어 입력 ------------------------------
					int eng;
					do {// 입력 범위 조건 검사
						System.out.print("\n영어: ");
						eng = Integer.parseInt(input.nextLine());
						if (eng < 0 || eng > 100)
							System.out.println("성적의 범위(0~100)를 벗어났습니다");
					} while (eng < 0 || eng > 100);
					engs[idx] = eng;

					// ------------------------------ 수학 입력 ------------------------------
					int math;
					do {// 입력 범위 조건 검사
						System.out.print("\n수학: ");
						math = Integer.parseInt(input.nextLine());
						if (math < 0 || math > 100)
							System.out.println("성적의 범위(0~100)를 벗어났습니다");
					} while (math < 0 || math > 100);
					maths[idx] = math;

					idx++; // 크기 증가

					// ------------------------------ 반복 작업 선택 ------------------------------
					System.out.print("계속하시겠습니까?(계속하시려면 1번, 아니면 0번을 입력해주세요.)");
					button = input.nextLine();
				} while ("1".equals(button)); // 입력 while

				break;

			case 2:
				// ============================== 성적 출력 ===========================

			case 3:
				// ============================== 성적 읽기 ===========================

			case 4:
				// ============================== 성적 저장 ===========================

			case 5:
				// ============================== 성적 수정 ===========================

			case 6:
				// ============================== 성적 삭제 ===========================

			case 7:// ============================== 프로그램 종료 ===========================
				break main;

			default:
				System.out.print("정확한 번호(1~7)으로 다시 입력해주세요.");
			} // switch
			
			// ------------------------------ 메인 화면으로 복귀 ------------------------------
			System.out.print("메인 화면으로 돌아가려면 아무키나 입력하세요.");
			input.nextLine();
		} // main while
		
		System.out.println("프로그램이 종료됩니다.");
	} // main

}// class
