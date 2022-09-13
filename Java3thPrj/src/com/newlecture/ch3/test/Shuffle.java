package com.newlecture.ch3.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * < 자리 섞기 프로그램 > 파일명: Shuffle.java 
 * 1번: 입력하기, 
 * 2번: 자리섞기, 
 * 3번: 출력하기, 
 * 4번: 파일읽기, 
 * 5번: 파일저장, 
 * 6번: 종료하기,
 * @author ict04-11
 */
public class Shuffle {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in); 

		int MAX = 28;
		int size = 0;
		int team_num = 4; 
		String[][] teams = new String[0][0]; 
		String[] members = new String[MAX]; 

		//============== 프로그램 실행 ===================================================	
		main:
		while (true) {
			
			//============== 메인 화면 ===========================================
			System.out.print("┌───────────────────────────────────────────┐\n");
			System.out.print("│              자리 섞기 프로그램	            │\n");
			System.out.print("└───────────────────────────────────────────┘\n");
			System.out.print("\t\t1. 입력 하기 \n");
			System.out.print("\t\t2. 자리 섞기 \n");
			System.out.print("\t\t3. 출력 하기 \n");
			System.out.print("\t\t4. 파일 읽기 \n");
			System.out.print("\t\t5. 파일 저장 \n");
			System.out.print("\t\t6. 종료 하기 \n");
			System.out.print("\t\t선택 > ");

			int menu = Integer.parseInt(input.nextLine()); 

			switch (menu) {

			case 1: //======================== 입력 하기 ==================================
				
				//============== 입력 화면 ==============================================
				System.out.print("┌───────────────────────────────────────────┐\n");
				System.out.print("│       	  명단 입력		    │\n");
				System.out.print("└───────────────────────────────────────────┘\n");

				System.out.print("입력을 멈추시려면 '끝'을 입력해주세요");
				
				input:
				do {
					//------------------------------ 이름 입력 ------------------------------
				
					if(size == MAX) {
						System.out.print("최대 입력 인원을 초과하였습니다.");
						break; 
					}

					String member;
					do { 
						System.out.print("\n이름: ");
						member = input.nextLine();
						if("끝".equals(member)) break input;
						if (member.length() != 3)
							System.out.println("3글자에 맞춰서 입력해주세요");
					} while (member.length() != 3);
					members[size++] = member;
				} while (true);
				
				//------------------------------ 조원 수 배분 문제 ------------------------------
				System.out.print("최소 조원의 수를 입력해주세요");
				team_num = Integer.parseInt(input.nextLine());
				
				teams = new String[size / team_num][team_num];
				int[] remain_member = new int[size % team_num];
				
				if(size % team_num!=0) {
					System.out.printf("%d명의 인원이 남습니다. 몇 조에 넣으시겠습니까?",size % team_num);
					for(int i=0; i<size % team_num; i++) {
						int num = Integer.parseInt(input.nextLine());
						if(0<= num && num < size / team_num) {
							remain_member[i] = num; 
						}else {
							System.out.printf("조를 잘 못 지정하셨습니다. 다시 입력하세요.");
							i--;
						}
					}

					int x = 0;
					for (int i = 0; i < teams.length; i++) {
						if(i==remain_member[x]-1) {
							teams[i] = new String[teams[i].length+1];
							i=0;
							x++;
						}
						if(x==remain_member.length) break;
					}
				}
				
		        // 팀 Table에 랜덤으로 선택된 순서에 맞게 끊어서 대입
				int k=0;
		        for(int i=0; i<teams.length; i++) 
		            for(int j=0; j<teams[i].length; j++)
		                teams[i][j] = members[k++];
		        printseat(teams); // 디버깅
				break;
				
			case 2: //======================== 자리 섞기 ==================================
				
				
				if(size==0) {
					System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
					break;
				}
				
				Random random = new Random(); // 자리를 랜덤하게 선택하기 위한 객체 
				
				int[] tmp = new int[size];
				for (int i = 0; i < size; i++) {
					tmp[i] = random.nextInt(size);
					for (int j = 0; j < i; j++) {
						if (tmp[i] == tmp[j]) {
							i--;
							break;
						}
					}
				}
			
		        // 팀 Table에 랜덤으로 선택된 순서에 맞게 끊어서 대입
				k=0;
		        for(int j=0; j<teams.length; j++) 
		            for(int i=0; i<teams[j].length; i++)
		                teams[j][i] = members[tmp[k++]];
		        printseat(teams); // 디버깅
				break;
			
			case 3: //======================== 출력 하기 ================================== 

				printseat(teams); // 디버깅
				
				break;
			case 4: //======================== 파일 읽기 ==================================

				FileInputStream fis = new FileInputStream("Java3thPrj\\res\\seat.csv");
				Scanner fscan = new Scanner(fis); 
				
				int cnt=0;
				while(fscan.hasNext()) { // 파일에 내용이 있으면 true, 없으면 false -> 즉, 내용이 있을때 까지 읽기 위함

					String[] line = fscan.nextLine().split(",");
					String[] temp = new String[line.length];
					
					for(int i=0; i<line.length; i++) {
						temp[i] = line[i];
						size++;
						if(size==MAX) {
							System.out.print("파일 속 명단의 수가 최대 입력 인원을 초과하였습니다.");
							break;
						}
					}
					if(teams.length==cnt) {
						
						String[][] buffer = new String[cnt+1][];
						
						for(int j=0; j<teams.length; j++ ) {
							buffer[j] = new String[teams[j].length];
							for(int i=0;i<teams[j].length ;i++)
								buffer[j][i] = teams[j][i];
						}
						teams = buffer;
					}
					
					teams[cnt] = temp;
					cnt++;
					
				} // while read
				
				k=0;
				for(int j=0; j<teams.length; j++) 
					for(int i=0;i<teams[j].length ;i++) 
						members[k++] = teams[j][i];

				System.out.println("파일 읽기가 완료되었습니다.");
				break;
			
			case 5: //======================== 저장 하기 ==================================
				
				System.out.print("┌───────────────────────────────────────────┐\n");
				System.out.print("│       	  저장 하기		    │\n");
				System.out.print("└───────────────────────────────────────────┘\n");
				System.out.print("\t\t1. CSV 파일로 저장하기 \n");
				System.out.print("\t\t2. TXT 파일로 저장하기 \n");
				System.out.print("\t\t선택 > ");

				menu = Integer.parseInt(input.nextLine()); 
				
				if(size==0) {
					System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
					break;
				}
				
				// 두가지 저장을 고려? -> csv로 저장하기, 형식에 맞춰서 저장하기
				
				FileOutputStream fos;
				PrintStream fprint;
				switch(menu) {
				
				case 1: // CSV형식으로 저장
					fos = new FileOutputStream("Java3thPrj\\res\\seat.csv");
					fprint = new PrintStream(fos);
					
					for(int j=0; j<teams.length; j++) {
						for(int i=0; i<teams[j].length-1; i++)
							fprint.printf("%s,",teams[j][i]);
						fprint.printf("%s%n",teams[j][teams[j].length-1]);
					}
					break;
					
				case 2:// txt파일로 저장
					
					fos = new FileOutputStream("Java3thPrj\\res\\seat.txt");
					fprint = new PrintStream(fos);
					
					fprint.println("*********조 편성 결과*********");
					fprint.println("(자리 표는 아래 \"4강의실 자리표\" 참고)");
					
					random = new Random();
					
					fprint.print("이번 달 조장: ");
				
					for(int j=0; j<teams.length; j++) {
						int random_num = random.nextInt(teams[j].length);
						fprint.printf("%s ",teams[j][random_num]);
					}
					fprint.println();
					
					for(int j=0; j<teams.length; j++) {
						fprint.printf("%d조: ",j+1);
						for(int i=0; i<teams[j].length-1; i++)
							fprint.printf("%s,",teams[j][i]);
						fprint.printf("%s%n",teams[j][teams[j].length-1]);
					}
					break;

				default : System.out.println("입력값이 올바르지 않습니다."); 
				}
				
				System.out.println("파일 저장이 완료되었습니다."); 
				
				break;
			case 6: //======================== 종료 하기 ==================================
				break main;
			default : System.out.println("정확한 번호(1~6)으로 다시 입력해주세요.");  
			} //switch
			//------------------------------ 메인 화면으로 복귀 ------------------------------
			System.out.print("메인 화면으로 돌아가려면 아무키나 입력하세요.");
			input.nextLine();
		} //  main while
		
		System.out.println("프로그램이 종료됩니다.");
	} // main
	
	
	
	static void printseat (String[][] seatTable) {
		// 디버깅용 코드
		for(int i = 0; i<seatTable.length; i++) {
			System.out.printf("---- %d조 ----------------%n",i+1);
			for(int j = 0; j<seatTable[i].length-1;j++) 
				System.out.printf("%s,",seatTable[i][j]);
			System.out.printf("%s%n",seatTable[i][seatTable[i].length-1]);
		}
		
	}
	
	
	
	
	
	
} // class
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		// 배열에 읽어온 학생들의 이름을 저장
////		for (int i = 0; i < 26; i++) {
////			member[i] = Character.toString((char) (i + 65));
////		}
//		
//
//
//
//	// 학생들 이름이 저장되어 있는 txt파일을 읽어온다
//	// 파일을 읽어오기 위한 객체들
//	File f = new File("C:\\Users\\ict04-11\\git\\Java3thPrj\\Java3thPrj\\res\\randomseat.txt");
//	FileReader fr = new FileReader(f);
//	BufferedReader br = new BufferedReader(fr);
////		FileWriter fw = new FileWriter(f);
//
//	// 학생들을 저장할 리스트 맵으로 구현 해도 괜찮다
//	ArrayList<String> memberList = new ArrayList<>();
//	String name ;while((name=br.readLine())!=null)
//	{
//		memberList.add(name.trim());
//	}
//
//	// 학생들이 안고 있는 자리 <2차원 배열(테이블) 형태로 구현하였다.> -> 0,0 제일 왼쪽 자리 4,5는 제일 끝자리
//	String[][] seatTable = new String[5][6];
//
//	// 스태프님들은 뒷자리 고정
//	// 고정자리!
//	// seatTable[4][3] = "_뉴렉쌤" ;
//	seatTable[4][4]="멘토쌤";seatTable[4][5]="멘토쌤";seatTable[1][5]="빈자리";seatTable[3][5]="빈자리";
//
//	// 조장 뽑기 기능
//	ArrayList<String> leaderList = new ArrayList<>();System.out.print("이번 달 조장은:");for(
//	int i = 0;i<5;i++)
//	{
//		int randomNum = random.nextInt(memberList.size());
//		String leader = memberList.get(randomNum);
//		System.out.printf(" %s", leader);
//		leaderList.add(leader);
//		memberList.remove(leader); // 추후에 map,set으로 구현해보는 것도 좋음
//		seatTable[i][0] = leader; // 순서대로 조장이 되는 것도 괜찮다
//	}System.out.println();
//
//	// 랜덤 자리 배정! 1조에 한명씩 (총 5개조)
//	// 조장부터 각줄에 1명씩 배정
//
////		for(int i = 0; i<5; i++) {
////			int randomNum = random.nextInt(leaderList.size());
////			seatTable[i][0] = leaderList.get(randomNum);
////			leaderList.remove(randomNum);
////		} 
//
//	// 랜덤으로 조 편성 기능
//	ArrayList<String> temp = memberList;
////		Scanner scanner = new Scanner(System.in); 직접 반복 횟수를 지정해주는 걸로 해도 됨
//	// 일단은 20명 만
//	int[] arr = new int[3];for(
//	int i = 0;i<5;i++)
//	{
//		for (int j = 1; j < 6; j++) {
//			if (seatTable[i][j] == null) {
//				int randomNum = random.nextInt(temp.size());
//				seatTable[i][j] = temp.get(randomNum);
//				temp.remove(randomNum);
//			}
//		}
//	}
//	// 남는 인원 한명 처리..
//	// seatTable[4][3] = temp.get(0);
//
////		SeatPrint.print(seatTable);
//	// PrintSeatTable.print(seatTable);
//
//	// 새롭게 선정된 조로 내용 초기화
//	// fw.close();
//
//	}



//}
