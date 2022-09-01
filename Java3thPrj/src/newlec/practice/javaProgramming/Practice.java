package newlec.practice.javaProgramming;

import java.util.Collections;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		 int kor, math, eng ; 
		 int total ; 
		 double avg ;
		 
		 Scanner sc = new Scanner(System.in);
		 
		 // 입력부
		 System.out.print("┌──────────────────────────────┐\n");
		 System.out.print("│           성적 입력            │\n");
		 System.out.print("└──────────────────────────────┘\n");
		 
		// 라벨 무엇을 입력받아야하는지 혹은 입력해야하는지 알려주는 작업
		 System.out.printf("\t국어: ");
		 kor = sc.nextInt() ; 
		 System.out.printf("\t수학: ");
		 math = sc.nextInt() ; 
		 System.out.printf("\t영어: ");
		 eng = sc.nextInt() ;
		 
		 // 연산부
		 total = kor + math + eng ;
		 avg = total/3.0f;
		 
		// 출력부
		 
		 System.out.print("┌──────────────────────────────┐\n");
		 System.out.print("│           성적 출력            │\n");
		 System.out.print("└──────────────────────────────┘\n");
		 
		 for(int i=0;i<3;i++) 
		 {
			 System.out.printf("--------------<%d>---------------%n", 3-i);
			 System.out.printf("\t국어:%d\n", kor);
			 System.out.printf("\t수학:%d\n", math);
			 System.out.printf("\t영어:%d\n", eng);
			 System.out.printf("\t총점:%d%n", total);
			 System.out.printf("\t평균:%5.2f%n",avg );
			 System.out.println("────────────────────────────────");

		 }
	}
}

