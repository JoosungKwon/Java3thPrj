package com.newlecture.ch3.fo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) throws IOException {
		 int menu ;
		 String name = "" ;
		 int kor = 0, math = 0, eng = 0 ;
		 int total = 0; 
		 double avg = 0;
		 
		 Scanner sc = new Scanner(System.in);
		
		 EXIT:
		 while(true) {
			 
			 // 메인 메뉴 화면
			 System.out.print("┌────────────────────┐\n");
			 System.out.print("│           	            메인 메뉴		           │\n");
			 System.out.print("└────────────────────┘\n");
			 System.out.print("\t\t\t 1. 성적 입력 \n");
			 System.out.print("\t\t\t 2. 성적 출력 \n");
			 System.out.print("\t\t\t 3. 성적 읽기 \n");
			 System.out.print("\t\t\t 4. 성적 저장하기 \n");
			 System.out.print("\t\t\t 5. 프로그램 종료 \n");
			 System.out.print("\t\t\t 선택 > ");
			 menu = sc.nextInt(); // 선택 메뉴 변수 
			 
			 switch(menu) {
			 
			 case 1:
					 //-------------------------- 입력부------------------------------
					 System.out.print("┌────────────────────┐\n");
					 System.out.print("│           	            성적 입력		           ││\n");
					 System.out.print("└────────────────────┘\n");
					 
					// 라벨 무엇을 입력받아야하는지 혹은 입력해야하는지 알려주는 작업
			
					 // 입력 조건절 
					 
					 do {
						 System.out.print("\t국어: ");
						 kor = sc.nextInt() ; 
						 if(kor<0 || kor > 100) {
							 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
						 }
					 } while(kor<0 || kor > 100) ;
					 
					 do {
						 System.out.printf("\t수학: ");
						 math = sc.nextInt() ; 
						 if(math<0 || math > 100) {
							 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
						 }
					 } while(math<0 || math > 100) ;
					 
					 do {
						 System.out.printf("\t영어: ");
						 eng = sc.nextInt() ;
						 if(eng<0 || eng > 100) {
							 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
						 }
					 } while(eng<0 || eng > 100) ;
					 
					 sc.nextLine() ;
					 System.out.printf("\t이름: ");
					 name = sc.nextLine() ;
					 
					 break;
					
			 case 2:
				 				 
					 // 연산부
					 total = kor + math + eng ;
					 avg = total/3.0f;
				 
					 //============================== 출력부===========================
					 
					 System.out.print("┌────────────────────┐\n");
					 System.out.print("│           	            메인 메뉴		           │\n");
					 System.out.print("└────────────────────┘\n");
					 

					 System.out.println("--------------<0>------------------------");
					 System.out.printf("\t국어:%d\n", kor);
					 System.out.printf("\t수학:%d\n", math);
					 System.out.printf("\t영어:%d\n", eng);
					 System.out.printf("\t총점:%d%n", total);
					 System.out.printf("\t평균:%5.2f%n",avg );
					 System.out.println("─────────────────────");
		
					 break;
			 	case 3:
			 		{	
			 			Scanner fscan = new Scanner(new FileInputStream("Java3thPrj\\res\\origin.csv"));			 			 
			 			name = fscan.nextLine();
			 			kor = Integer.parseInt(fscan.nextLine());
			 			math = Integer.parseInt(fscan.nextLine());
			 			eng = Integer.parseInt(fscan.nextLine());
			 			
			 			 System.out.println(name);
			 			 
			 			fscan.close();
			 		}
			 		break;
				case 4:
					{
						File data = new File("Java3thPrj\\res\\student_score.csv");
						FileOutputStream fos = new FileOutputStream(data,true);
			 			PrintStream ps = new PrintStream(fos ) ;
			 			
			 			ps.println(name);
			 			ps.println(kor);
			 			ps.println(math);
			 			ps.println(eng);
			 			
			 			fos.close() ;
			 			ps.close();
					}
					
					break;
				case 5:
					System.out.println("프로그램이 종료됩니다.");
					break EXIT;
					
				default:
					System.out.println("잘 못 입력하셨습니다. 1~3번만 입력하세요");
			 }
		}
	}
}

