package com.newlecture.ch3.arr;

import java.util.Random;

public class LottoApp {

	public static void main(String[] args) {
//		정수 타입의 배열 lotto를 생성 및 초기화 하시오.
//		랜덤 값(1~45) 6개를 넣으시오 .

		Random random = new Random(); // 랜덤값을 만들어주는 객체

		int[] lotto = new int[6]; // lotto 배열 선언 및 생성

		for (int i = 0; i < lotto.length - 1; i++) {
			lotto[i] = random.nextInt(45) + 1; // 랜덤값으로 초기화 범위는 1~ 45 사이
		}

//		값 변경하기
//		버블정렬
//		1. 몇번 반복하는지
//		2. 반복하는 데 어떤 변화나 차이가 있는지

		for (int i = 0; i < lotto.length - 1; i++) {
			boolean sort = false;
			for (int j = 0; j < lotto.length - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {

					int temp = lotto[j]; // 1. A공간의 값을 임시변수에 넣는다
					lotto[j] = lotto[j + 1]; // 2. B공간의 값을 A공간에 넣는다.
					lotto[j + 1] = temp; // 3. 임시공간에 있는 값을 B공간에 넣는다

					sort = true;
				}
			}
			if (!sort)
				break;
		}

		for (int i = 0; i < lotto.length - 1; i++) {
			for (int j = 0; j < lotto.length - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}
		int[] nums = {3,4,5,1,2,3,7};
//		sort(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%d ", nums[i]);
		}
		System.out.println();
		
		int[] lotto1 = {1,2,3,4,5,6} ;
		int[] lotto2 = {2,3,4,5,6,7} ;
		int[] lotto3 = {3,4,5,6,7,8} ;
		
		int[][] lottos = new int[3][] ;
		
		lottos[0] = lotto1 ;
		lottos[1] = lotto2 ;
		lottos[2] = lotto3 ;
		
		
		int[] temp ;
		
		temp = lottos[0];
		lottos[0] = lottos[1];
		lottos[1] = temp;
		
		for(int j=0; j<lottos.length;j++) {
			for(int i=0; i<lottos[j].length; i++) 
				System.out.printf("%d ",lottos[j][i]);
			System.out.println();
		}
		

		
		
		

	}

//	public static void sort(int[] arr) {
//		quicksort(arr, 0, arr.length - 1);
//	}
//
//	static void quicksort(int[] arr, int start, int end) {
//		if (start >= end)
//			return;
//
//		int pivot = start + ((end - start) / 2);
//		int pivotValue = arr[pivot];
//
//		int left = start;
//		int right = end;
//
//		while (left <= right) {
//
//			while (left < right && arr[left] < pivotValue) {
//				left++;
//			}
//
//			while (left < right && arr[right] > pivotValue) {
//				right--;
//			}
//			if(left<=right) {
//				int temp = arr[right];
//				arr[right] = arr[left];
//				arr[left] = temp;
//				left++;
//				right--;
//			}
//		}
//
//		quicksort(arr, start, right-1);
//		quicksort(arr, right, end);
//	}

}
