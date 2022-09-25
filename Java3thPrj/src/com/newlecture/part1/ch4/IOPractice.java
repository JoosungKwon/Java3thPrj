package com.newlecture.part1.ch4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

// CSV 파일을 읽어서 출력하고 복사해서 새로운 파일을 만들어주는 기능 연습

public class IOPractice {
	public static void main(String[] args) throws IOException {
		
		File inputData = new File("Java3thPrj\\res\\student_score.csv"); // 읽어올 파일
		File outputData = new File("Java3thPrj\\res\\copy.csv"); // 저장될 파일
		Scanner fs = new Scanner(new InputStreamReader(new FileInputStream(inputData))); // 입력 장치 객체
		PrintWriter pw = new PrintWriter(new FileWriter(outputData,true)) ; // 출력 장치 객체
		
		Vector<Vector> Temp = new Vector<>(); // 데이터를 일시적으로 보관할 자료구조 캐시? 이차원 리스트 필요 -> excel 파일을 입력할 것이기 때문
		
		// 첫줄을 읽는 다 (열 속성 값) -> 예외 케이스들을 관리 필요  
		
		
		while(fs.hasNext()) {
			String[] attribute = fs.nextLine().split(",");
			
			for(int i =0; i<attribute.length; i++) {
				System.out.printf("%s",attribute[i]);
			}
			System.out.println();
			
		}
		
		pw.flush();
		fs.close();
		pw.close();
		
	}
}

