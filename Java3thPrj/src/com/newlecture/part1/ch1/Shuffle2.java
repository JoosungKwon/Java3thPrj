package com.newlecture.part1.ch1;

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
 * 6번: 짝꿍선택,
 * 7번: 종료하기,
 *
 * @author ict04-11
 */
public class Shuffle2 {
	
    public static void main(String[] args) throws IOException {
    	Scanner input = new Scanner(System.in);
    
    	TeamTable teamtable = new TeamTable();
    	teamtable.max = 26;
    	
    	teamtable.teams = new String[0][0];
    	teamtable.team = 0;
    	teamtable.members = new String[0];
    	teamtable.member = 0;
    	
    	String[][] mate = new String[0][0];
    	
        //============== 프로그램 실행 ===================================================
        main:
        while (true) {
        	
            int menu = inputMenu();;
            
            switch (menu) {

                case 1: //======================== 입력 하기 =================================
                	inputTeams(teamtable);
                    break;

                case 2: //======================== 자리 섞기 ==================================
                	shuffleTeams(teamtable);
                    break;

                case 3: //======================== 출력 하기 ==================================
                	printTeams(teamtable);
                    
                    break;
                case 4: //======================== 파일 읽기 ==================================
                	readTeams(teamtable);
                    break;

                case 5: //======================== 저장 하기 ==================================
                	saveTeams(teamtable,mate);
                    break;

                case 6://=================짝꿍 만들기===================
                	mate = makePair(teamtable);
                    
                    break;
                case 7: //======================== 종료 하기 ==================================
                    break main;
                default:
                    System.out.println("정확한 번호(1~7)으로 다시 입력해주세요.");
            } //switch
            //------------------------------ 메인 화면으로 복귀 ------------------------------
            System.out.print("메인 화면으로 돌아가려면 아무키나 입력하세요.");
            input.nextLine();
        } //  main while

        System.out.println("프로그램이 종료됩니다.");
    } 
    
    static int inputMenu() {
    	Scanner input = new Scanner(System.in);
        //============== 메인 화면 ===========================================
        System.out.print("┌───────────────────────────────────────────┐\n");
        System.out.print("│              자리 섞기 프로그램	            │\n");
        System.out.print("└───────────────────────────────────────────┘\n");
        System.out.print("\t\t1. 입력 하기 \n");
        System.out.print("\t\t2. 자리 섞기 \n");
        System.out.print("\t\t3. 출력 하기 \n");
        System.out.print("\t\t4. 파일 읽기 \n");
        System.out.print("\t\t5. 파일 저장 \n");
		System.out.print("\t\t6. 짝꿍 만들기 \n");
        System.out.print("\t\t7. 종료 하기 \n");
        System.out.print("\t\t선택 > ");

        String menu = input.nextLine();
		
        return Integer.parseInt(menu);
	}

	static void inputTeams(TeamTable teamtable) {
		Scanner input = new Scanner(System.in);
    	//============== 입력 화면 ==============================================
        System.out.print("┌───────────────────────────────────────────┐\n");
        System.out.print("│       	  명단 입력		    │\n");
        System.out.print("└───────────────────────────────────────────┘\n");

        System.out.print("입력을 멈추시려면 '끝'을 입력해주세요");
        
    	teamtable.teams = new String[0][0];
    	teamtable.team = 0;
    	teamtable.members = new String[0];
    	teamtable.member = 0;
    	
        inputMembers(teamtable);    
        
        
        //------------------------------ 조원 수 배분 문제 ------------------------------
        
        System.out.print("최소 조원의 수를 입력해주세요");
        int num = Integer.parseInt(input.nextLine());

        if (teamtable.member < num) {
            System.out.println("조원 부족합니다. 인원을 채워주세요.");
            teamtable.member = 0;
            teamtable.members = new String[teamtable.max];
        }
        
        divMembers(teamtable, num);
        
        toTable(teamtable.members,teamtable.teams);
        
        printseat(teamtable.teams); // 디버깅
		
	}
	
	static void divMembers(TeamTable teamtable, int num) {
		Scanner input = new Scanner(System.in);
		int size = teamtable.member;
    	teamtable.teams = new String[size / num][num];
    	teamtable.team = size / num;
        int[] remain_member = new int[size % num];

        if (size % num != 0) {
            System.out.printf("%d명의 인원이 남습니다. 몇 조에 넣으시겠습니까?", size % num);
            for (int i = 0; i < size % num; i++) {
                int team = Integer.parseInt(input.nextLine()) - 1;
                if (0 <= team && team < size / num) {
                    remain_member[i] = team;
                } else {
                    System.out.println("조를 잘 못 지정하셨습니다. 다시 입력하세요.");
                    i--;
                }
            }
            
            int x = 0;
            for (int i = 0; i < teamtable.teams.length; i++) {
                if (i == remain_member[x]) {
                	teamtable.teams[i] = new String[teamtable.teams[i].length + 1];
                    i = -1;
                    x++;
                }
                if (x == remain_member.length) break;
            }
        }
	}
	
	static void inputMembers(TeamTable teamtable) {
		Scanner input = new Scanner(System.in);
		teamtable.members = new String[teamtable.max];
    	
    	input:
        do {
            //------------------------------ 이름 입력 ------------------------------

            if (teamtable.member == teamtable.max) {
                System.out.print("최대 입력 인원을 초과하였습니다.");
                break;
            }

            String member;
            do {
                System.out.print("\n이름: ");
                member = input.nextLine();
                if ("끝".equals(member)) break input;
                if (member.length() != 3)
                    System.out.println("3글자에 맞춰서 입력해주세요");
            } while (member.length() != 3);
            teamtable.members[teamtable.member++] = member;
        } while (true);

	}

	static String[][] makePair(TeamTable teamtable) {
		int size = teamtable.member;
		Random rand = new Random();
    	String[][] mate = new String[size/2][2];
        
        int[] temp = new int[size];
        
        for (int i = 0; i < size; i++) {
            temp[i] = rand.nextInt(size);
            for (int j = 0; j < i; j++) {
                if (temp[i] == temp[j]) {
                    i--;
                    break;
                }

            }
        }
        
        int k = 0;
        for (int i = 0; i < mate.length; i++) {
            for (int j = 0; j < mate[i].length; j++)
                mate[i][j] = teamtable.members[temp[k++]];
        }
        
        System.out.println("*****짝꿍 만들기 결과*****");

        for (int i = 0; i < mate.length; i++) {
            System.out.printf("----- %d -----%n", i + 1);
            for (int j = 0; j < mate[i].length - 1; j++)
                System.out.printf("%s,", mate[i][j]);
            System.out.printf("%s%n", mate[i][mate[i].length - 1]);
        }
        
        return mate;
	}

	static void saveTeams(TeamTable teamtable,String[][] mate) throws IOException {
		Scanner input = new Scanner(System.in);
    	
    	System.out.print("┌───────────────────────────────────────────┐\n");
        System.out.print("│       	  저장 하기		    │\n");
        System.out.print("└───────────────────────────────────────────┘\n");
        System.out.print("\t\t1. CSV 파일로 저장하기 \n");
        System.out.print("\t\t2. TXT 파일로 저장하기 \n");
		System.out.print("\t\t3. 짝꿍명단 CSV 파일로 저장하기 \n");
		System.out.print("\t\t4. 출력포맷으로 저장하기 \n");
		System.out.print("\t\t5. 뒤로가기 \n");
        System.out.print("\t\t선택 > ");

        int menu = Integer.parseInt(input.nextLine());
        
        // 예외를 막으려고
        if (teamtable.member == 0) {
            System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
            return;
        }

        switch (menu) {

            case 1: // CSV형식으로 저장
            	saveCSV(teamtable.teams);
                break;

            case 2:// txt파일로 저장
            	saveTxT(teamtable.teams);
                break;

			case 3: // 짝꿍만들기 파일 저장
				savePair(mate);
				break;

            case 4: // 출력포맷으로 저장
            	saveFormat(teamtable.teams);
                break;
            case 5: // 뒤로가기
            	return;
            default:
                System.out.println("입력값이 올바르지 않습니다.");
                return;
        }

        System.out.println("파일 저장이 완료되었습니다.");

		
	}

	static void saveFormat(String[][] teams) throws IOException {
		FileOutputStream fos = new FileOutputStream("res\\seat2.txt");
		PrintStream fprint = new PrintStream(fos);

        fprint.print("=====================================================================\n");
        fprint.print("                            4강의실 자리표                               \n");
        fprint.print("=====================================================================\n");
        fprint.println();
        fprint.print("┌───────┐ ┌──────────────────────────────────────────────────────────┐\n");
        fprint.print("│  Door │ │                       Whiteboard                         │\n");
        fprint.print("└───────┘ └──────────────────────────────────────────────────────────┘\n");
        //선생님 자리
        fprint.print("                                                            ┌────────┐\n");
        fprint.printf("                                                            │  %s  │ \n", "뉴렉쌤");
        fprint.print("                                                            └────────┘\n");
        //자리
        fprint.println("┌─────────────Group1──────────────┬───────────Group4──────────────────┐ ");
        fprint.println("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
        fprint.printf("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n", teams[0][0], teams[0][1], teams[0][2], teams[0][3], teams[3][1], teams[3][2]);
        fprint.println("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
        fprint.println("├──────────┐                      │                        ┌──────────┘");
        fprint.println("│┌────────┐│┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
        fprint.printf("││  %s  │││  %s  │ │  %s  │ │   │  %s  │ │  %s  │││  %s  │\n", teams[1][5], teams[0][3], teams[0][4], teams[3][3], teams[3][4], "빈자리");
        fprint.println("│└────────┘│└────────┘ └────────┘ │   └────────┘ └────────┘│└────────┘");
        fprint.println("│          └───Group2─────────────┼───────────Group5───────┴──────────┐");
        fprint.println("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
        fprint.printf("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n", teams[1][0], teams[1][1], teams[1][2], teams[4][0], teams[4][1], teams[4][2]);
        fprint.println("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
        fprint.println("│                     ┌──Group3───┤                        ┌──────────┘");
        fprint.println("│┌────────┐ ┌────────┐│┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
        fprint.printf("││  %s  │ │  %s  │││  %s  │ │   │  %s  │ │  %s  │││  %s  │\n", teams[1][3], teams[1][4], teams[2][0], teams[4][3], teams[4][4], "빈자리");
        fprint.println("│└────────┘ └────────┘│└────────┘ │   └────────┘ └────────┘│└────────┘");
        fprint.println("├─────────────────────┘           └─────────────┬──────────┴──────────┐");
        fprint.println("│┌────────┐ ┌────────┐ ┌────────┐     ┌────────┐│┌────────┐ ┌────────┐│");
        fprint.printf("││  %s  │ │  %s  │ │  %s  │     │  %s  │││  %s  │ │  %s  ││\n", teams[2][1], teams[2][2], teams[2][3], teams[2][4], "멘토쌤", "멘토쌤");
        fprint.println("│└────────┘ └────────┘ └────────┘     └────────┘│└────────┘ └────────┘│");
        fprint.println("└───────────────────────────────────────────────┴───────Mentor────────┘ ");

        fprint.close();
	}

	static void savePair(String[][] mate) throws IOException {
		if(mate.length==0) {
			System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
			return;
		}

		FileOutputStream fos = new FileOutputStream("res\\pair.txt");
		PrintStream fprint = new PrintStream(fos);


		for(int j=0; j<mate.length; j++) {
			for(int i=0; i<mate[j].length-1; i++)
				fprint.printf("%s,",mate[j][i]);
			fprint.printf("%s%n",mate[j][mate[j].length-1]);
		}
		fprint.close();
		
	}

	static void saveTxT(String[][] teams) throws IOException {
		FileOutputStream fos = new FileOutputStream("res\\seat.txt");
		PrintStream fprint = new PrintStream(fos);

        fprint.println("*********조 편성 결과*********");
        fprint.println("(자리 표는 아래 \"4강의실 자리표\" 참고)");

        Random random = new Random();

        fprint.print("이번 달 조장: ");

        for (int j = 0; j < teams.length; j++) {
	        int random_num = random.nextInt(teams[j].length);
            fprint.printf("%s ", teams[j][random_num]);
        }
        fprint.println();

        for (int j = 0; j < teams.length; j++) {
            fprint.printf("%d조: ", j + 1);
            for (int i = 0; i < teams[j].length - 1; i++)
                fprint.printf("%s,", teams[j][i]);
            fprint.printf("%s%n", teams[j][teams[j].length - 1]);
        }
        fprint.close();
        fos.close();
		
	}

	static void saveCSV(String[][] teams) throws IOException {
		FileOutputStream fos = new FileOutputStream("res\\seat.csv");
		PrintStream fprint = new PrintStream(fos);

        for (int j = 0; j < teams.length; j++) {
            for (int i = 0; i < teams[j].length - 1; i++)
                fprint.printf("%s,", teams[j][i]);
            fprint.printf("%s%n", teams[j][teams[j].length - 1]);
        }
        fprint.close();
        fos.close();
		
	}

	static void readTeams(TeamTable teamtable) throws IOException {
    	FileInputStream fis = new FileInputStream("res\\seat.csv");
        Scanner fscan = new Scanner(fis);
        
    	teamtable.teams = new String[0][0];
    	teamtable.members = new String[0];

        while (fscan.hasNext()) { // 파일에 내용이 있으면 true, 없으면 false -> 즉, 내용이 있을때 까지 읽기 위함

            String[] line = fscan.nextLine().split(",");
            String[] temp = new String[line.length];

            for (int i = 0; i < line.length; i++) {
                temp[i] = line[i];
                teamtable.member++;
                if (teamtable.member == teamtable.max) {
                    System.out.print("파일 속 명단의 수가 최대 입력 인원을 초과하였습니다.");
                    break;
                }
            }
         // 동적으로 테이블 크기 증가 (2차원으로)
            dynamicArray(teamtable);
            
            teamtable.teams[teamtable.team++] = temp;

        } // while read
      //------------------------------ 2차원 -> 1차원 ------------------------------
        teamtable.members = new String[teamtable.member];
        toArray(teamtable.teams,teamtable.members);

        System.out.println("파일 읽기가 완료되었습니다.");
        fscan.close();
        fis.close();
		
	}

	static void dynamicArray(TeamTable teamtable) {
            String[][] buffer = new String[teamtable.team + 1][];

            for (int j = 0; j < teamtable.team; j++) {
                buffer[j] = new String[teamtable.teams[j].length];
                for (int i = 0; i < teamtable.teams[j].length; i++)
                    buffer[j][i] = teamtable.teams[j][i];
            }
            teamtable.teams = buffer;
        }
	
	static void printTeams(TeamTable teamtable) {
		String[][] teams =teamtable.teams;
    	printseat(teams); // 디버깅
        
        if (teamtable.member < 26) {
            System.out.println("출력하기에는 인원 부족합니다. 인원을 채워주세요.");
            return;
        }

        if (teams.length!=5) {
            System.out.println("출력 포맷을 사용하려면 5조 이상 조원 5명이상이어야 가능합니다.");
            return;
        }

        for(int i=0; i<5; i++)
            if (!(teams[i].length>=5)) {
                System.out.println("출력 포맷을 사용하려면 5조 이상 조원 5명이상이어야 가능합니다.");
                return;
            }


        //조 편성
        System.out.println("*********조 편성 결과*********");
        System.out.println("(자리 표는 아래 \"4강의실 자리표\" 참고)");
        System.out.println();
        for (int j = 0; j < teams.length; j++) {
            System.out.printf("%d조:", j + 1);
            for (int i = 0; i < teams[j].length - 1; i++)
                System.out.printf("%s,", teams[j][i]);
            System.out.printf("%s%n", teams[j][teams[j].length - 1]);
        }
        //선생님들 이름
//		System.out.printf("※선생님: %s\n",teac1);
//		System.out.printf("※멘토1: %s, 멘토2: %s",teac2,teac3);
        System.out.println();
        System.out.println();

        //자리배치표
        System.out.print("=====================================================================\n");
        System.out.print("                            4강의실 자리표                               \n");
        System.out.print("=====================================================================\n");
        System.out.println();
        System.out.print("┌───────┐ ┌──────────────────────────────────────────────────────────┐\n");
        System.out.print("│  Door │ │                       Whiteboard                         │\n");
        System.out.print("└───────┘ └──────────────────────────────────────────────────────────┘\n");
        //선생님 자리
        System.out.print("                                                            ┌────────┐\n");
        System.out.printf("                                                            │  %s  │ \n", "뉴렉쌤");
        System.out.print("                                                            └────────┘\n");
        //자리
        System.out.println("┌─────────────Group1──────────────┬───────────Group4──────────────────┐ ");
        System.out.println("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
        System.out.printf("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n", teams[0][0], teams[0][1], teams[0][2], teams[0][3], teams[3][1], teams[3][2]);
        System.out.println("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
        System.out.println("├──────────┐                      │                        ┌──────────┘");
        System.out.println("│┌────────┐│┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
        System.out.printf("││  %s  │││  %s  │ │  %s  │ │   │  %s  │ │  %s  │││  %s  │\n", teams[1][5], teams[0][3], teams[0][4], teams[3][3], teams[3][4], "빈자리");
        System.out.println("│└────────┘│└────────┘ └────────┘ │   └────────┘ └────────┘│└────────┘");
        System.out.println("│          └───Group2─────────────┼───────────Group5───────┴──────────┐");
        System.out.println("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
        System.out.printf("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n", teams[1][0], teams[1][1], teams[1][2], teams[4][0], teams[4][1], teams[4][2]);
        System.out.println("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
        System.out.println("│                     ┌──Group3───┤                        ┌──────────┘");
        System.out.println("│┌────────┐ ┌────────┐│┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
        System.out.printf("││  %s  │ │  %s  │││  %s  │ │   │  %s  │ │  %s  │││  %s  │\n", teams[1][3], teams[1][4], teams[2][0], teams[4][3], teams[4][4], "빈자리");
        System.out.println("│└────────┘ └────────┘│└────────┘ │   └────────┘ └────────┘│└────────┘");
        System.out.println("├─────────────────────┘           └─────────────┬──────────┴──────────┐");
        System.out.println("│┌────────┐ ┌────────┐ ┌────────┐     ┌────────┐│┌────────┐ ┌────────┐│");
        System.out.printf("││  %s  │ │  %s  │ │  %s  │     │  %s  │││  %s  │ │  %s  ││\n", teams[2][1], teams[2][2], teams[2][3], teams[2][4], "멘토쌤", "멘토쌤");
        System.out.println("│└────────┘ └────────┘ └────────┘     └────────┘│└────────┘ └────────┘│");
        System.out.println("└───────────────────────────────────────────────┴───────Mentor────────┘ ");

		
	}

	static void shuffleTeams(TeamTable teamtable) {
		
		String[][] teams = teamtable.teams;
		String[] members = teamtable.members;
		int size = teamtable.member;
    	//------------------------------ 예외 처리 ------------------------------
        if (teamtable.member == 0) {
            System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
            return ;
        }
        
        Random random = new Random(); 
      //------------------------------ 배열 랜덤하게 만들기 ------------------------------
		for (int i = 0; i < 1000; i++) {
			int random_num = random.nextInt(size);
			String temp = members[0];
			members[0] = members[random_num];
			members[random_num] = temp;
		}
		
		toTable(members,teams);
     
        printseat(teams); // 디버깅
	}
	
	static void toArray(String[][] teams, String[] members) {
			
        int k = 0;
        for (int i = 0; i < teams.length; i++)
            for (int j = 0; j < teams[i].length; j++)
            		members[k++] = teams[i][j];
	}
	
	static void toTable(String[] members,String[][] teams) {
		
        int k = 0;
        for (int i = 0; i < teams.length; i++)
            for (int j = 0; j < teams[i].length; j++)
            		 teams[i][j] = members[k++];
	}

	static void printseat(String[][] seatTable) {
        // 디버깅용 코드
        for (int i = 0; i < seatTable.length; i++) {
            System.out.printf("---- %d조 ----------------%n", i + 1);
            for (int j = 0; j < seatTable[i].length - 1; j++)
                System.out.printf("%s,", seatTable[i][j]);
            System.out.printf("%s%n", seatTable[i][seatTable[i].length - 1]);
        }
    }
	
	
	

    
} // class

