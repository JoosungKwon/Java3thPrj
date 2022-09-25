package com.newlecture.kwonjoosung.omok;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class OmokApp2 {

//	경기 진행과정을 임시저장 하는 Buffer의 역할 -> 무르기 및 기보 보기 기능을 구현하고자 사용
//	 무르기 -> 최근 둔 수를 스택에서 pop후 롤백, 기보보기 -> 저장된 x,y를 dequeue로 빼내서 다시 경기 했던 과정을 보여줌
	private Deque DB; // Stack + Queue

	private String[][] omokTable; // 오목 판의 역할

	private Scanner input; // -> 입력을 변경하기 위함?

	// 사이즈를 입력받아 해당 사이즈 크기의 오목 판을 만들어준다.
	public OmokApp2(int size) {
		this.DB = new ArrayDeque<int[]>();
		omokTable = new String[size][size];
		setting();
		input = new Scanner(System.in);
	}

	// 게임 부팅하고 시작하는 엔드포인트
	public void game() {

		int x, y;
		int turn = 0;
		String[] color = { "●", "○" }; // 첫번째가 흑, 두번째가 백?

//-------------시작화면------------------------	

		display();
		System.out.print("오목 게임이 시작됩니다.");

//-------------게임이 진행되는 지점------------------------		
		main: while (true) {

			input: while (true) {
				try {
					System.out.print("놓으실 위치를 입력하세요: ");
					String[] Line = input.nextLine().split(" ");

					// 탈출 조건
					if (Line[0].equals("finish"))
						break main;

					// 무르기 기능
					if (Line[0].equals("prev")) {
						if (DB.isEmpty()) {
							System.out.println("무르기가 불가능합니다");
							continue;
						}

						int[] prev = (int[]) DB.pollLast();
						rollback(prev[0], prev[1]);
						turn--;

						display();
						System.out.println("무르기는 자제해주시길 바랍니다.");
						System.out.printf("무르기가 되어 차례가 되돌아 갑니다. \"%s\" 사용자는 다시 입력해주세요. %n", color[(turn) % 2]);
						continue;

					} // 무르기 끝
					
					// 좌표
					y = Integer.parseInt(Line[0]) - 1;
					x = Integer.parseInt(Line[1]) - 1;
					
					// 좌표 선택
					if (!(select(y, x, color[(turn) % 2]))) {
						System.out.println("잘못된 위치에 입력하셨습니다. 다시 입력해주세요");
						continue;
					}
					
					// 3 X 3 방지
					String threeByThree = "";
					if (!(threeByThree = whoIsWin(y, x, 3)).equals("Not Yet")) {
						int[] prev = (int[]) DB.pollLast();
						rollback(prev[0], prev[1]);
						display();
						System.out.println("3 X 3 위치입니다. 매너 게임 부탁합니다.");
						System.out.println("다시 입력해주세요.");
					}
					
					turn ++; // 턴 변경
					break input; // 정상 입력이면 input while 탈출 
					
				} catch (Exception e) { // 정상이 아닌 입력은 전체 오류로 캐치
					System.out.println("오류입니다. 다시 입력해주세요");
				} 
									 
			} // input while 

			
			// 입력이 완료된 이후 DB에 저장
			int[] tmp = { y, x };
			DB.offerLast(tmp);

			
			// 경기의 승패를 구하라
			String winner;
			if (!((winner = whoIsWin(y, x, 5)).equals("Not Yet"))) {
				System.out.printf("\"%s\" 사용자가 승리하였습니다.! 축하드립니다.!%n", winner);
				display();
				break;
			}
			
			// 오목판이 꽉찰 때까지 경기가 끝나지 않았다면 강제 종료
			if (turn == Math.pow(omokTable.length, 2)) {
				System.out.println("더이상 둘 자리가 없습니다.");
				break;
			}

			display();

		} // main while 종료
		
		
//		-------------게임 종료-------------------------------------	

		// 경기가 끝나면 기보를 볼지 선택 

		System.out.println("경기가 종료되었습니다.");
		System.out.println("기보를 확인하려면 \"1\"을 입력, 나가시려면 아무키나 입력 하세요.");
		
		String menu;
		menu = input.nextLine();
		
		// 기보를 선택하면 기보를 보여줌 
		
		if ("1".equals(menu)) {
			setting(); // 일단 리셋(테이블 덮어씌우기)
			turn = 0;
			display();
			for (Object tmp : DB) { // DB에 남은 경기 기록을 앞에서 부터(큐) 꺼내오면서 다시 실행
				int[] y_x1 = (int[]) tmp;
				y = y_x1[0];
				x = y_x1[1];
				select(y, x, color[(turn++) % 2]);
				display();
				System.out.printf("%d 번째 경기 화면%n", turn);
				System.out.println("다음 화면으로 넘어가려면 아무키나 입력하세요");
				input.nextLine();
			}
		}
		
		System.out.println("프로그램이 종료됩니다.");
	} // game 함수 종료

	
	// 오목판을 크기에 맞게 만들어주는 함수
	void setting() {
		int size = omokTable.length;

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

	// 다시 되돌리는 함수 
	// 모서리 쪽은 모서리에 맞게 다시 해야함으로 코드 복잡
	void rollback(int y, int x) {
		int size = omokTable.length;

		if (!(y > 0 && y < size - 1 && x > 0 && x < size - 1)) {
			if (y == 0) { // 첫 번째 줄
				if (x == 0) {
					omokTable[y][x] = "┌";
				} else if (x == size - 1) {
					omokTable[y][x] = "┐";
				} else {
					omokTable[y][x] = "┬";
				}
			} else if (y == size - 1) { // 마지막째 줄
				if (x == 0) {
					omokTable[y][x] = "└";
				} else if (x == size - 1) {
					omokTable[y][x] = "┘";
				} else {
					omokTable[y][x] = "┴";
				}
			} else { // 가운데 줄 중에 양 옆
				if (x == 0) {
					omokTable[y][x] = "├";
				} else if (x == size - 1) {
					omokTable[y][x] = "┤";
				}

			}
		} else { // 가운데 줄
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

	// 현재 둔 돌과 연결된 돌들의 개수를 보고 현재 입력된 돌과 연결된 같은 돌의 개수를 세줌
	// 3 X 3 확인과 승리조건을 만들기 위해서 사용
	// 방향 별 k개의 같은 돌이 있는지 알려줌
	String whoIsWin(int y, int x, int k) {
		String color = omokTable[y][x];
		int direction = 0;
		int size = omokTable.length;
		// 방향 4개를 다 확인하기

		// 세로 방향 확인
		{
			int cnt = 1;

			int colum = y;
			while (colum - 1 >= 0 && omokTable[colum - 1][x].equals(color)) {
				colum--;
				cnt++;
			}

			colum = y;
			while (colum + 1 < size && omokTable[colum + 1][x].equals(color)) {
				colum++;
				cnt++;
			}

			if (cnt == k)
				direction++;
		}
		// 가로 방향 확인
		{
			int cnt = 1;

			int row = x;
			while (row - 1 >= 0 && omokTable[y][row - 1].equals(color)) {
				row--;
				cnt++;
			}

			row = x;
			while (row + 1 < size && omokTable[y][row + 1].equals(color)) {
				row++;
				cnt++;
			}

			if (cnt == k)
				direction++;
		}
		// ('\'방향)대각선 확인
		{
			int cnt = 1;

			int colum = y;
			int row = x;
			while (colum - 1 >= 0 && row - 1 >= 0 && omokTable[colum - 1][row - 1].equals(color)) {
				colum--;
				row--;
				cnt++;
			}

			colum = y;
			row = x;
			while (colum + 1 < size && row + 1 < size && omokTable[colum + 1][row + 1].equals(color)) {
				colum++;
				row++;
				cnt++;
			}

			if (cnt == k)
				direction++;
		}
		// ('/'방향)대각선 확인
		{
			int cnt = 1;

			int colum = y;
			int row = x;
			while (colum - 1 >= 0 && row + 1 < size && omokTable[colum - 1][row + 1].equals(color)) {
				colum--;
				row++;
				cnt++;
			}

			colum = y;
			row = x;
			while (row - 1 >= 0 && colum + 1 < size && omokTable[colum + 1][row - 1].equals(color)) {
				colum++;
				row--;
				cnt++;
			}

			if (cnt == k)
				direction++;
		}

		String answer = "Not Yet";

		if (k == 3) {
			if (direction > 1)
				return color;
			return answer;
		} else {
			if (direction > 0)
				return color;
			return answer;
		}
	}

}