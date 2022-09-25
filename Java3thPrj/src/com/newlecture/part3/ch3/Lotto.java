package com.newlecture.part3.ch3;

public class Lotto {

	private int[] nums;

	public Lotto() {
		nums = new int[6];
	}

	public int get(int n) {

		if (!(1 <= n && n <= 6))
			return -1;
		return nums[n - 1];
	}

	public void sort() {

		for (int i = 0; i < nums.length-1; i++)
			for (int j = 0; j < nums.length-1-i; j++)
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
	}

	public void set(int n, int value) {
		if (!(1 <= n && n <= 6))
			return;
		nums[n - 1] = value;
	}

}
