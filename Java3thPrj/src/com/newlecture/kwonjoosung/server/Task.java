package com.newlecture.kwonjoosung.server;

public class Task {

	public static void main(String[] args) {
		
//		=============문제1======================================================
		int[] arr = new int[10];
		int sum = 0;
		for(int i=0; i< arr.length; i++) {
			arr[i] = i+1 ;
			sum += i+1 ;
		}
		System.out.printf("배열:");
		for(int i=0; i<arr.length; i++)
			System.out.printf(" %d",arr[i]);
		System.out.println();
		
		System.out.printf("합: %d%n", sum);
		System.out.println();
//		=============문제2======================================================
		
		for(int x=1; x<=8; x++) {
			System.out.printf("-----%d단------%n", x+1);
			for(int y=1; y<=9 ; y++) 
				System.out.printf("%d X %d = %d%n",x+1,y,(x+1)*y);
			System.out.println();
		}
		
//		=============문제3======================================================
		
		int[] arr2 = {4, 1, 3, 10, 5, 7, 6, 2, 9, 8};

		for(int n=1; n<=arr2.length; n++)
			System.out.printf("%d ",arr2[arr.length-n]);
		System.out.println();
		System.out.println();
		
//		=============문제4======================================================
		
		for(int n=1; n<=5; n++) {
			for(int i=0; i<5; i++) {
				System.out.printf("%d",n+i);
			}
			System.out.println();
		}
		
		
	}

}
