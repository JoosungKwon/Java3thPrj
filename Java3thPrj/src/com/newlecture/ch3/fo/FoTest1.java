package com.newlecture.ch3.fo;

public class FoTest1 {

	public static void main(String[] args) {
		
//		// for문 연습하기
//		// for문의 조건틀은 유지할 것 for(int i=0;i<N; i++)
//		
//		// 문제 1 
//		for(int i=0;i<10; i++)
//			System.out.printf("%d ",1);
//		System.out.println();
//		
//		// 문제 2	
//		for(int i=0;i<10; i++)
//			System.out.printf("%d ",i+1);
//		System.out.println();
//		
//		// 문제 3
//		for(int i=0;i<10; i++)
//			System.out.printf("%d ",10-i);
//		System.out.println();
//		
//		// 문제 4
//		for(int i=0;i<5; i++)
//			System.out.printf("%d ",i+3);
//		System.out.println();
//		
//		//문제 5 ※수열 일반항 등차 수열 3씩 증가 (3*(n-1)) (2+(n-1)*3)/(초항*(n-1)*등차)
//		for(int i=0;i<20; i++)
//			System.out.printf("%d ",(3*i)+2);
//		System.out.println();
//		
		//문제6
		
//		for(int i=0;i<100; i++)
//			System.out.printf("%c",'┼');
//		System.out.println();
		
//		for(int n=1,c=1;n<=100; n++) {
//			int an = 1 + (c-1) * 10 ;
//			if(an == n) {
//				System.out.printf("%c",'○');
//				c++;
//			}
//			else
//				System.out.printf("%c",'┼');
//			if(n%10==0)
//				System.out.printf("%s","\n");
//		}
//		System.out.println();
		
		//문제7
//		for(int y=1; y<=10; y++) {
//			for(int x=1; x<=10; x++) {
//				if(x >= 12-y  && x<=y)
//					System.out.printf("%c",'●');
//				else
//				System.out.printf("%c",'┼');
//			}
//			System.out.println();
//		}
//		
		// 문제 8
//		final int HEIGHT= 12; // 상수화
//		final int WIDTH = 12; // 상수화
//		
//		for(int y=1; y <= HEIGHT; y++) {
//			
//			// 모서리
//			if(y == 1)
//				System.out.printf("%c",'┌'); // 왼쪽 위 모서리
//			else if(y == HEIGHT)
//				System.out.printf("%c",'└');// 왼쪽 아래 모서리
//			else 
//				System.out.printf("%c",'├'); // 왼쪽 옆
//			
//			for(int x=1; x<= WIDTH-2; x++) {
//				
//				if(y == 1 ) // 맨위 부분
//					System.out.printf("%c",'┬');
//				else if(y == WIDTH) // 맨 아래 부분
//					System.out.printf("%c",'┴');
//				else  // 가운데 칸
//					System.out.printf("%c",'┼');
//			}
//			
//			if(y == 1)
//				System.out.printf("%c",'┐'); // 오른쪽 위 모서리
//			else if(y == HEIGHT )
//				System.out.printf("%c",'┘'); // 오른쪽 아래 모서리
//			else 
//				System.out.printf("%c",'┤'); // 오른쪽 옆
//			
//			System.out.println();
//		}
//		
	}
	
}
