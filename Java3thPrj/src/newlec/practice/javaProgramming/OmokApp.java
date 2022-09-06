package newlec.practice.javaProgramming;

import java.util.Scanner;
import java.util.Stack;


class OmokApp {
	Stack<int[]> stack ;
	private String[][] omokTable;

	public OmokApp() {
		this(12);
	}

	public OmokApp(int size) {
		omokTable = new String[size][size];
		setting();
	}

	// 게임 부팅하고 시작하는 엔드포인트
	public void game() {
		int x, y;
		Scanner scan = new Scanner(System.in);
		this.stack = new Stack<int[]>();

		/// 게임 시작 화면
//		System.out.print("┌────────────────────┐\n");
//		System.out.print("│                      Game Sta                          │\n");
//		System.out.print("└────────────────────┘\n");

		// 부가적인 화면 꾸미기 요소
//		System.out.print("오목 게임이 시작됩니다.");	

		display(); // 시작화면

		// 게임이 진행되는 지점
		String[] color = { "●", "○" }; // 첫번째가 흑, 두번째가 백?
		int order = 0;

		main: while (true) {
			
			while (true) {
				try {
					System.out.print("놓으실 위치를 입력하세요: ");
					String[] Line = scan.nextLine().split(" ");
					if (Line[0].equals("finish")) { // 탈출 조건
						break main;
					}
					
					// 무르기 기능 
					if(Line[0].equals("prev") ) {
						if(stack.isEmpty()) {
							System.out.println("무르기가 불가능합니다");
							continue;
						}
						
						int[] prev = stack.pop();
						omokTable[prev[0]][prev[1]] = "┼"; // 따로 함수 만들기
						rollback(prev[0],prev[1]);
						order--;
						
						display();
						System.out.println("무르기는 자제해주시길 바랍니다.");
						System.out.printf("무르기가 되어 차례가 되돌아 갑니다. \"%s\" 사용자는 다시 입력해주세요. ",color[(order) % 2]);
						continue;
						
					}
					
					y = Integer.parseInt(Line[0]);
					x = Integer.parseInt(Line[1]);
					break;
				} catch (Exception e) {
					System.out.println("오류입니다. 다시 입력해주세요");
					continue;
				}
			}
			
			if (!(select(y - 1, x - 1, color[(order++) % 2]))) {
				System.out.println("잘못된 위치에 입력하셨습니다. 다시 입력해주세요");
				order--;
				continue;
			}
			
			int[] tmp = {y-1,x-1} ;
			stack.push(tmp);
			
			// 경기의 승패를 구하라
			
			String winner;
			if(!((winner=whoIsWin(y-1,x-1)).equals("Not Yet"))) {
				System.out.printf("\"%s\" 사용자가 승리하였습니다.! 축하드립니다.!%n",winner);
				display();
				break;
			}
			if (order == Math.pow(omokTable.length, 2)) {
				System.out.println("더이상 둘 자리가 없습니다.");
				break;
			}
			
			display();

		}
		System.out.println("경기가 종료되었습니다.");

	}

	// 오목판을 크기에 맞게 만들어주는 함수
	void setting() {
		int size = omokTable.length;

		// 숫자 판 --> 폰트로 인해 구현이 안됨
//				for(int i = 0; i< size; i++) {
//					
//					omokTable[i+1][0] = (i+1>=10) ?  String.valueOf(i+1) :  String.valueOf(i+1+"  ");
//					omokTable[0][i+1] = String.valueOf(i+1)+" ";
//				}
//				omokTable[0][0] = String.valueOf(0)+"  ";

		// 모서리 작업
		omokTable[0][0] = "┌";
		omokTable[size - 1][0] = "└";
		omokTable[0][size - 1] = "┐";
		omokTable[size - 1][size - 1] = "┘";

		// 양 옆
		for (int i = 0; i < size - 2; i++) {
			omokTable[0][i + 1] = "┬";
			omokTable[size - 1][i + 1] = "┴";
			omokTable[i + 1][0] = "├";
			omokTable[i + 1][size - 1] = "┤";

		}

		// 몸통
		for (int y = 0; y < size - 2; y++) {
			for (int x = 0; x < size - 2; x++) {
				omokTable[y + 1][x + 1] = "┼";
			}
		}

	}
	
	void rollback( int y , int x) {
		int size = omokTable.length;
		
		if(!(y>0 && y<size-1&& x>0 && x<size-1)) {
			if(y==0) { // 첫 번째 줄
				if(x==0) {
					omokTable[y][x] = "┌";
				}else if(x==size-1){
					omokTable[y][x] = "┐";
				}else {
					omokTable[y][x] =  "┬";
				}
			}else if(y==size-1){ // 마지막째 줄
				if(x==0) {
					omokTable[y][x] = "└";
				}else if(x==size-1){
					omokTable[y][x] = "┘";
				}else {
					omokTable[y][x] =  "┴";
				}
			}else { //가운데 줄 중에 양 옆
				if(x==0) {
					omokTable[y][x] = "├";
				}else if(x==size-1){
					omokTable[y][x] = "┤";
				}
				
			}
		}else { // 가운데 줄
			omokTable[y][x] = "┼";
		}
	}
			
	
	

	// 바둑판을 출력해주는 함수
	void display() {

		for (int y = 0; y < omokTable.length; y++) {
			for (int x = 0; x < omokTable[0].length; x++) {
				System.out.printf("%s", omokTable[y][x]);
			}
			System.out.println();
		}
	}

	// 선택한 좌표에 돌을 놓는 함수
	boolean select(int y, int x, String color) {
		int size = omokTable.length;

		if (0 > x || x >= size || 0 > y || y >= size)
			return false; // 좌표 잘못 입력시
		if (omokTable[y][x].equals("○") || omokTable[y][x].equals("●"))
			return false; // 같은 자리에 중복해서 둘시에

		omokTable[y][x] = color;
		return true;
	}

	// 현재 둔 돌과 연결된 돌들의 개수를 보고 현재 입력된 돌이 이겼는지 확인하는 기능
	String whoIsWin(int y, int x) {
		String color = omokTable[y][x] ;
		int size = omokTable.length;
		// 방향 4개를 다 확인하기
		 
		//세로 방향 확인
		{
			int cnt = 1 ;
			
			int colum = y ;
			while(colum-1>=0 && omokTable[colum-1][x].equals(color)) {
				colum--; cnt++;
			 }
			
			colum = y ;
			while(colum+1<size&& omokTable[colum+1][x].equals(color)) {
				colum++; cnt++;
			 }
			
			 if(cnt==5) 
				 return color;
		}
		//가로 방향 확인
		{
			int cnt = 1 ;
			
			int row = x ;
			while(row-1>=0 && omokTable[y][row-1].equals(color)) {
				row--; cnt++;
			 }
			
			row = x ;
			while(row+1<size&& omokTable[y][row+1].equals(color)) {
				row++;cnt++;
			 }
			
			 if(cnt==5) 
				 return color;
		}
		//('\'방향)대각선 확인 
		{
			int cnt = 1 ;
			
			int colum = y ;
			int row = x ;
			while(colum-1>=0 && row-1>=0 && omokTable[colum-1][row-1].equals(color)) {
				colum--; row--; cnt++;
			 }
			
			colum = y ;
			row = x ;
			while(colum+1<size && row+1<size&& omokTable[colum+1][row+1].equals(color)) {
				colum++; row++;cnt++;
			 }
			
			 if(cnt==5) 
				 return color;
		}
		//('/'방향)대각선 확인 
		{
			int cnt = 1 ;
			
			int colum = y ;
			int row = x ;
			while(colum-1>=0 && row+1<size && omokTable[colum-1][row+1].equals(color)) {
				colum--; row++; cnt++;
			 }
			
			colum = y ;
			row = x ;
			while(row-1>=0 && colum+1<size&& omokTable[colum+1][row-1].equals(color)) {
				colum++; row--;cnt++;
			 }
			
			 if(cnt==5) 
				 return color;
		}
		 

		 
		 String answer = "Not Yet";
		 return answer;
	}

}