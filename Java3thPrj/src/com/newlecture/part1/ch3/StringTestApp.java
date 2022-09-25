package com.newlecture.part1.ch3;

public class StringTestApp {

	public static void main(String[] args) {
//		-------문자열의 형식변환-----------------
	
		int x = 30;
		String x_ = String.valueOf(x); // 정수 -> 문자
		x = Integer.parseInt(x_); // 문자 -> 정수
		
		String filename = "/menu/photo.jpg";
		int idx1 = filename.indexOf('/',1);
		System.out.printf("index : %d%n",idx1);
		int idx2 = filename.indexOf('.');
		System.out.printf("index : %d%n",idx2);
		
//		filename = filename.substring(idx1+1,idx2);
		String data = filename.substring(idx2+1);
		System.out.println(data);
		
		
//		-------문자열 비교-----------------
		
		String name1 = "아이유";
		String name2 = new String("아이유");
		
		// == 객체 비교
		System.out.println(name1==name2);
		
		// equals 값 비교
		System.out.println(name1.equals(name2));
		

	}

}
