package com.newlecture.part2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 
 * 구조적 프로그래밍 연습하기
 * 
 * @author kwonjoosung
 *
 */



public class App {
	
   public static void main(String[] args) throws IOException {
	   
	   Exam exam = new Exam();
	   Exam[] examlist = new Exam[3];
	  
//	  for(int i=0; i<3; i++) {
//		  exams[i] = new Exam();
//		  idx++;
//	  }
		  
	  int menu;
	  
      EXIT:
      while(true)
      {         
    	  menu = inputMenu();
        
         switch(menu){
         
         case 1:
//        	 inputExams(list); 	 
//            break;
         case 2:
//        	 printExams(list);
//            break;
         case 3:
//        	 saveExam(list);
//            break;
         case 4:
//        	 readExam(list);
//            break;
         case 5:
            System.out.println("Bye~~~");
            break EXIT;
            
         default:
            System.out.println("메뉴는 1~5번만 선택할 수 있습니다.");
            break;
         }
      }      
   }
   

static int inputMenu() {
	   
	   Scanner scan = new Scanner(System.in);
	   
       System.out.print("┌─────────────────────────────┐\n");
       System.out.print("│            메인 메뉴           │\n");
       System.out.print("└─────────────────────────────┘\n");
       System.out.println("1. 성적입력");
       System.out.println("2. 성적출력");
       System.out.println("3. 성적저장");
       System.out.println("4. 성적읽기");
       System.out.println("5. 종료");
       System.out.print(">");
	   int menu = Integer.parseInt(scan.nextLine());
	   return menu;
	  
   }
   
   static void inputExams(ExamList list) {
	   Scanner scan = new Scanner(System.in);
	   
       System.out.print("┌─────────────────────────────┐\n");
       System.out.print("│            메인 입력           │\n");
       System.out.print("└─────────────────────────────┘\n");
       
       String[] titles = {"kor", "eng", "math"};
       int[] nums = new int[3];
       
       for(int i=0;i<3; i++) {
          int temp;
          do {
             System.out.printf("%s:", titles[i]);
             temp = scan.nextInt();
             
             if(temp<0 ||temp>100)
                System.out.println("성적은 (0~100) 범위를 벗어날 수 없습니다.");
             
          }while(temp<0 || temp>100);   
       
          nums[i] = temp;
       }
       
       Exam exam = new Exam();
       exam.kor = nums[0];
       exam.eng = nums[1];
       exam.math = nums[2];
       list.exams[list.idx] = exam;
       list.idx++;
       
   }
   
   static void printExams(ExamList list) {
	   
	 
       System.out.print("┌─────────────────────────────┐\n");
       System.out.print("│            성적 출력           │\n");
       System.out.print("└─────────────────────────────┘\n");
	   
	   for(int i=0; i<list.idx; i++) {
		   System.out.printf("-------------<%d>------------\n",i+1);
		   int kor = list.exams[i].kor;
		   int eng = list.exams[i].eng;
		   int math = list.exams[i].math;
		   
	       int total = kor+eng+math;
	       float avg = total/3.0f;               
	       
	       System.out.printf("kor : %d\n", kor);
	       System.out.printf("eng : %d\n", eng);
	       System.out.printf("math : %d\n", math);
	       System.out.printf("total : %d\n", total);
	       System.out.printf("avg : %f\n", avg);        
	   }
	   
   }
   
   static void saveExam(ExamList list) throws IOException 
   {
       FileOutputStream fos = new FileOutputStream("res/data.csv");
       PrintStream fout = new PrintStream(fos);
       
       for(int i=0; i<list.idx; i++) {
    	   
		   int kor = list.exams[i].kor;
		   int eng = list.exams[i].eng;
		   int math = list.exams[i].math;
		   
    	   fout.println("kor,eng,math");
    	   fout.printf("%d,%d,%d\n",kor,eng,math);
       }
       
       fout.close();
       fos.close();
    }   
   
   static void readExam(ExamList list) throws IOException {
	   
       FileInputStream fis = new FileInputStream("res/data.csv");
       Scanner fscan = new Scanner(fis);
       
       String titles = fscan.nextLine(); // 필드명 행 건너뛰기
       String[] line = fscan.nextLine().split(",");

	   list.exams[list.idx].kor = Integer.parseInt(line[0]);
	   list.exams[list.idx].eng = Integer.parseInt(line[1]);
	   list.exams[list.idx].math = Integer.parseInt(line[2]);
	   list.idx++;
	   
       fscan.close();
       fis.close();
       
    }
   
}
