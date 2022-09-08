package com.newlecture.ch3.test;

public class test {
	public static void main(String[] args) {
		// 1번문제
//		int[] nums = {5,2,7,4,6,90,3} ;
//		
//		for(int i=0; i<7; i++) 
//			if(nums[i]==90)
//				System.out.println(i);
		
		int[] nums = {5,2,7,4,6,90,3} ;
		int total = 0; 
		for(int i=0; i<6; i++) { 
			total += nums[i] ;
			if(nums[i]==90)
				break;
		}
		System.out.printf("total is %d",total);
		
	}


}
