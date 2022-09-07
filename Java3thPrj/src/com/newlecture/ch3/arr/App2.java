package com.newlecture.ch3.arr;

import java.util.Arrays;
import java.util.Scanner;

public class App2 {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 int subject_num = 3;
		 int subject_size = 3;
		 int idx = 0;
		 
		 String[][] subject_arr = new String[subject_num][] ;
		 
		 for(int i=0; i<subject_num; i++) 
			 subject_arr[i] = new String[subject_size];
		 
		 // 성적 입력
		 int valid = 0;
		 
		 do {
			 // 국어성적 입력

			 
			 if(idx>=subject_size) {
				 String[] temp = new String[subject_size+3] ;
				 for(int i=0;i<subject_size;i++) 
					 temp[i] = subject_arr[0][i];
				 subject_arr[0] = temp.clone();
				 subject_size += 3; 
			 }
			 
			 
			 do {
				 System.out.print("\t국어: ");
				 kor = sc.nextInt() ; 
				 if(kor < 0 || kor > 100) 
					 System.out.println("성적의 입력 범위(0~100을 벗어났습니다.");
				 
			 } while(kor < 0 || kor > 100) ;
			 
			 kors[idx] = kor ;
//			 engs[idx] = eng ;
//			 maths[idx] = math;
			 idx++;
			 
			 System.out.println("계속입력하시겠습니까?(1: 예, 0: 아니오");
			 valid = sc.nextInt() ;
			 
		 }while(valid == 1);
			 

			 
			 
			 
			 
		 // 성적 출력
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	}

}
