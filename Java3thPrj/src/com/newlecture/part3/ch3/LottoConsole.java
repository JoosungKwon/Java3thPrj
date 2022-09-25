package com.newlecture.part3.ch3;

import java.util.Scanner;

public class LottoConsole {
	
	private Lotto lotto;
	
	public static void main(String[] args) {
		
		LottoConsole lottoconsole = new LottoConsole();
		lottoconsole.input();
		lottoconsole.print();
	}
	
	public LottoConsole() {
		lotto = new Lotto();
	}
	
	public void input() {
		Scanner scan = new Scanner(System.in);

		System.out.print("┌─────────────────────────────┐\n");
		System.out.print("│            로또 입력           │\n");
		System.out.print("└─────────────────────────────┘\n");
		System.out.print("로또 번호 6개를 입력해주세요>");
		String[] line = scan.nextLine().split(" ");
		
		for(int i=0; i<6; i++) {
			int num = Integer.parseInt(line[i]);
			lotto.set(i+1,num);
		}
			
			
			
	}
	
	public void print() {
		lotto.sort();
		System.out.printf("로또 번호는: ");
		for(int n=1; n<6; n++) 
			System.out.printf("%d,",lotto.get(n));
		System.out.printf("%d%n",lotto.get(6));
	}
	
}
