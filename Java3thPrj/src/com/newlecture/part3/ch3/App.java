package com.newlecture.part3.ch3;

public class App {

	public static void main(String[] args) {

		ExamPage page = new ExamPage();
		page.input();
		page.print();
		
		Exam exam = new Exam();
		Exam exam1 = new Exam();
		Exam exam2 = new Exam(0,0,0);
		Exam exam3 = new Exam(10,10,10);
		Exam exam4 = new Exam(100,1000,100);
		
//		exam.init()
//		exam.input();
		
		System.out.println(exam.toString());
		System.out.println(exam1.toString());
		System.out.println(exam2.toString());
		System.out.println(exam3.toString());
		System.out.println(exam4.toString());
		
		
		
	}

}
