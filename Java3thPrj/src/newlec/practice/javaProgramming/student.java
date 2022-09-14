package newlec.practice.javaProgramming;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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

			case 2://============================== 성적 출력 ===========================
				
				//============== 출력 화면 ==============================================
				 System.out.print("┌───────────────────────────────────────────┐\n");
				 System.out.print("│       	  성적 출력		    │\n");
				 System.out.print("└───────────────────────────────────────────┘\n");
				
				 int total; // 국영수 합계 점수
				 double avg; // 평균 점수
				 
				if(idx==0) System.out.println("출력할 성적이 없습니다. 성적을 먼저 읽기/입력해주세요.");
				
				for(int i=0; i<idx; i++) {// format:  국어     영어      수학      합계     평균
					 System.out.printf("---------------------<%d>---------------------%n",i+1);
					 System.out.printf("%3s%9s%9s%9s%8s%n", "국어","영어","수학","합계","평균");
					 total = kors[i] + engs[i] + maths[i];
					 avg = total/3.0;
					 System.out.printf("%3d%10d%10d%10d%10.2f%n", kors[i],engs[i],maths[i],total,avg);
				}
				
				break;
		
			case 3://============================== 성적 읽기 ===========================
				// 파일 입력 장치
				FileInputStream fis = new FileInputStream("Java3thPrj\\res\\data.csv"); // 읽고자 하는 파일의 위치 입력
				Scanner fscan = new Scanner(fis); // 입력을 편하게 사용하기 위한 객체
				
				fscan.nextLine(); // 첫 줄 제거 -> 과목명
				
				while(fscan.hasNext()) { // 파일에 내용이 있으면 true, 없으면 false -> 즉, 내용이 있을때 까지 읽기 위함
					
					if (idx == max) { // 동적으로 배열 길이 증가
	
						int[] temp_kor = new int[max + 3];
						int[] temp_eng = new int[max + 3];
						int[] temp_math = new int[max + 3];

						for (int i = 0; i < idx; i++) {
							temp_kor[i] = kors[i];
							temp_eng[i] = engs[i];
							temp_math[i] = maths[i];
						}

						kors = temp_kor;
						engs = temp_eng;
						maths = temp_math;
					} // 현재 배열의 크기보다 읽으려는 파일의 길이가 더 길 경우를 대비하여
					
					// csv 파일은 ","를 기준으로 나눠서 입력 받아야 한다.
					// 한줄로 이루어진 format("국어,영어,수학")을 국어 영어 수학 으로 나눈 후 배열에 담는다.
					// 배열에 0번 인덱스 -> 국어; 1번 인덱스 영어; 2번 인덱스 수학;
					// 현재 idx 위치에 대입 후 크기 증가
					
					String[] line = fscan.nextLine().split(",");
					kors[idx] = Integer.parseInt(line[0]);
					engs[idx] = Integer.parseInt(line[1]);
					maths[idx] = Integer.parseInt(line[2]);
					idx++;
					
				} // while read
				
				System.out.println("성적 읽기가 완료되었습니다."); 
				break;
				
			case 4://============================== 성적 저장 ===========================
				
				// 파일 출력 장치
				FileOutputStream fos = new FileOutputStream("Java3thPrj\\res\\data.csv"); // 쓰고자 하는 파일의 위치 입력
				PrintStream fprint = new PrintStream(fos);// 출력을 편하게 사용하기 위한 객체 매개변수에 true 입력시 이어서 작성가능
				
				if(idx==0) System.out.println("저장할 성적이 없습니다. 성적을 먼저 읽기/입력해주세요.");
				
				fprint.println("국어,영어,수학"); // 첫줄은 과목명
				
				for(int i=0; i<idx; i++) { // format: '국어,영어,수학' (한줄로 출력)
					fprint.printf("%d,",kors[i]);
					fprint.printf("%d,",engs[i]);
					fprint.printf("%d",maths[i]);
					fprint.println();
				}
				
				System.out.println("성적 저장이 완료되었습니다."); 
				break;

			case 5: // ============================== 성적 수정 ===========================
				

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
