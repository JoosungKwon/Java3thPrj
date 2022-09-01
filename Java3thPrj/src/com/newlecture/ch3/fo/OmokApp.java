package com.newlecture.ch3.fo;

public class OmokApp {

	public static void main(String[] args) {
		
		for(int y=1; y<=12; y++) {
			
			// 모서리
			if(y<= 1 )
				System.out.printf("%c",'┌'); // 왼쪽 위 모서리
			else if(y>= 12 )
				System.out.printf("%c",'└');// 왼쪽 아래 모서리
			else 
				System.out.printf("%c",'├'); // 왼쪽 옆
			
			for(int x=1; x<=10; x++) {
				if(y<= 1 ) // 맨위 부분
					System.out.printf("%c",'┬');
				else if(y>= 12) // 맨 아래 부분
					System.out.printf("%c",'┴');
				else  // 가운데 칸
					System.out.printf("%c",'┼');
			}
			
			if(y<= 1 )
				System.out.printf("%c",'┐'); // 오른쪽 위 모서리
			else if(y>= 12 )
				System.out.printf("%c",'┘'); // 오른쪽 아래 모서리
			else 
				System.out.printf("%c",'┤'); // 오른쪽 옆
			
			System.out.println();
		}
		
	}

}

