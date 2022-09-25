package com.newlecture.part3.ch3;

public class ExamPage {
	
	private Exam exam = new Exam();

	public void input() {
		exam.setKor(10);
	}

	public void print() {
		System.out.println(exam.getKor());
	}
	
	

}
