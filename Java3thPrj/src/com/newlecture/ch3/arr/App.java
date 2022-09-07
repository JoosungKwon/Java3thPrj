package com.newlecture.ch3.arr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws IOException {
		 int size = 3 ;
		 int idx = 0 ;
		 int subject[][] = new int[3][] ;
		 int[] kors = new int[size] ;
		 int[] engs = new int[size] ;
		 int[] maths = new int[size] ;
		 
		 Scanner sc = new Scanner(System.in);
		 
		 
		 EXIT:
		 while(true) {
			 
			 // 메인 메뉴 화면
			 System.out.print("┌───────────────────────────────────────────┐\n");
			 System.out.print("│       	  메인 메뉴		    │\n");
			 System.out.print("└───────────────────────────────────────────┘\n");
			 System.out.print("\t\t1. 성적 입력 \n");
			 System.out.print("\t\t2. 성적 출력 \n");
			 System.out.print("\t\t3. 성적 읽기 \n");
			 System.out.print("\t\t4. 성적 저장하기 \n");
			 System.out.print("\t\t5. 프로그램 종료 \n");
			 System.out.print("\t\t선택 > ");
			 
			 int menu ;
			 menu = sc.nextInt(); // 선택 메뉴 변수 
			 
			 switch(menu) {
			 
			 case 1:
				 	//============================== 입력부===========================

					 System.out.print("┌───────────────────────────────────────────┐\n");
					 System.out.print("│       	  성적 입력		    │\n");
					 System.out.print("└───────────────────────────────────────────┘\n");
					 // 계속 입력할지 판단 flag 
					 int valid = 0;
					 
					 do { // 3과목 성적 입력
						 int kor;
						 int eng;
						 int math;
						 
						 // 동적 배열 구현
						 if(idx>=size) {
							 
							 subject[0]=kors ;
							 subject[1]=maths ; 
							 subject[2]=engs ; 
							 
							 int[][] temp = new int[3][size*2] ;
							 
							 for(int j=0;j<3;j++) {
								 for(int i=0;i<size;i++) 
									 temp[j][i] = subject[j][i];
							 }
							 kors = temp[0];
							 maths = temp[1]; 
							 engs = temp[2]; 
							 size += 3; 
						 }
						 

						//-------------------------- 국어 ---------------------------------------------
						 do {
							 System.out.print("\t국어: ");
							 kor = sc.nextInt() ; 
							 if(kor < 0 || kor > 100) 
								 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
							 
						 } while(kor < 0 || kor > 100) ;
						 
						 kors[idx] = kor ; // 해당번째에 해당 값 넣기
						 
						 
						//-------------------------- 영어 ---------------------------------------------
						 do {
							 System.out.print("\t영어: ");
							 eng = sc.nextInt() ; 
							 if(eng < 0 || eng > 100) 
								 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
							 
						 } while(eng < 0 || eng > 100) ;
						 
						engs[idx] = eng ; // 해당번째에 해당 값 넣기
						 

						//-------------------------- 수학 ---------------------------------------------
						 do {
							 System.out.print("\t수학: ");
							 math = sc.nextInt() ; 
							 if(math < 0 || math > 100) 
								 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
							 
						 } while(math < 0 || math > 100) ;
						 
						 maths[idx] = math ; // 해당번째에 해당 값 넣기

						 idx++; // size up
						//-------------------------- 반복 입력 선택 ----------------------------------------
						 System.out.println("계속입력하시겠습니까?(1: 예, 0: 아니오");
						 valid = sc.nextInt() ;
						 
					 }while(valid == 1);
					 
					 break;
					
			 case 2:		 
					 // 연산부
				 	int total = 0; 
				 	double avg = 0;
				 	
					 //============================== 출력부===========================
					 
					 System.out.print("┌───────────────────────────────────────────┐\n");
					 System.out.print("│       	  성적 출력		    │\n");
					 System.out.print("└───────────────────────────────────────────┘\n");
			 
					 for(int i=0; i<idx;i++)
					{
						 System.out.printf("---------------------<%d>---------------------%n",i);
						 System.out.printf("%3s%10s%10s%10s%8s%n", "kors","engs","maths","total","avg");
						 total = kors[i] + engs[i] + maths[i] ;
						 avg = total/3.0;
						 System.out.printf("%3d%10d%10d%10d%10.2f%n", kors[i],engs[i],maths[i],total,avg);
					 }
					 
					 
					 
//					 for(int i=0; i<kors.length; i++) {
//						 System.out.printf("\t국어:%d\n", kors[i]);
//					 }
//					 System.out.printf("\t총점:%d%n", total);
//					 System.out.printf("\t평균:%5.2f%n",avg );
//					 System.out.println("─────────────────────");
//		
					 break;
			 	case 3:
			 		{	
			 			Scanner fscan = new Scanner(new FileInputStream("Java3thPrj\\res\\student_score.csv"));
			 			
			 			for(int i=0; i<3; i++)
			 			{
			 				String[] tokens = fscan.nextLine().split(" ");
			 				int kor = Integer.parseInt(tokens[0]); 
			 				int eng = Integer.parseInt(tokens[1]); 
			 				int math = Integer.parseInt(tokens[2]);
			 				
			 				kors[0] = kor;
			 				engs[0] = eng;
			 				maths[0] = math;
			 			}
			 			fscan.close();
			 		}
			 		break;
				case 4:
					{
						File data = new File("Java3thPrj\\res\\student_score.csv");
						FileOutputStream fos = new FileOutputStream(data);
			 			PrintStream ps = new PrintStream(fos ) ;
			 			
			 			for(int i=0; i< kors.length; i++) 
			 				ps.println(kors[i]);

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

