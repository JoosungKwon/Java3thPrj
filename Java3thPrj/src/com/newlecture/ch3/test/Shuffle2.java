package com.newlecture.ch3.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	
	static Scanner input = new Scanner(System.in);
	static int size = 0 ;
	static int MAX = 28;
	static int team_num ;
	static String[][] teams = new String[0][0];
	static String[] members = new String[MAX];
	static String[][] mate = new String[0][0];
	
    public static void main(String[] args) throws IOException {
    	
        //============== 프로그램 실행 ===================================================
        main:
        while (true) {
        	
            int menu = inputMenu();;
            
            switch (menu) {

                case 1: //======================== 입력 하기 =================================
                	input();
                    break;

                case 2: //======================== 자리 섞기 ==================================
                	shuffle(teams,members);
                    break;

                case 3: //======================== 출력 하기 ==================================
                	print(teams);
                    
                    break;
                case 4: //======================== 파일 읽기 ==================================
                	read();
                    break;

                case 5: //======================== 저장 하기 ==================================
                	save();
                    break;

                case 6://=================짝꿍 만들기===================
                	mate = pair(members);
                    
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

        String data = input.nextLine();
		
        return Integer.parseInt(data);
	}

	static void input() {
    	//============== 입력 화면 ==============================================
        System.out.print("┌───────────────────────────────────────────┐\n");
        System.out.print("│       	  명단 입력		    │\n");
        System.out.print("└───────────────────────────────────────────┘\n");

        System.out.print("입력을 멈추시려면 '끝'을 입력해주세요");
 
        inputMember();    
        
        
        //------------------------------ 조원 수 배분 문제 ------------------------------
        
        System.out.print("최소 조원의 수를 입력해주세요");
        team_num = Integer.parseInt(input.nextLine());

        if (size < team_num) {
            System.out.println("조원 부족합니다. 인원을 채워주세요.");
            size = 0;
            members = new String[MAX];
        }
        
        divMember();

      //------------------------------ 1차원 -> 2차원 ------------------------------
        toArray(teams,members);

        printseat(teams); // 디버깅
		
	}
	
	static String[][] divMember() {
    	String[][] teams;
    	
    	teams = new String[size / team_num][team_num];
        int[] remain_member = new int[size % team_num];

        if (size % team_num != 0) {
            System.out.printf("%d명의 인원이 남습니다. 몇 조에 넣으시겠습니까?", size % team_num);
            for (int i = 0; i < size % team_num; i++) {
                int num = Integer.parseInt(input.nextLine()) - 1;
                if (0 <= num && num < size / team_num) {
                    remain_member[i] = num;
                } else {
                    System.out.println("조를 잘 못 지정하셨습니다. 다시 입력하세요.");
                    i--;
                }
            }
            
            int x = 0;
            for (int i = 0; i < teams.length; i++) {
                if (i == remain_member[x]) {
                    teams[i] = new String[teams[i].length + 1];
                    i = -1;
                    x++;
                }
                if (x == remain_member.length) break;
            }
        }
            return teams;
        }
	
	static String[] inputMember() {
    	String[] members = new String[MAX];
    	
    	input:
        do {
            //------------------------------ 이름 입력 ------------------------------

            if (size == MAX) {
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
            members[size++] = member;
        } while (true);
    	
		return members;
	}

	static void toArray(String[][] table, String[] array) {
        int k = 0;
        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table[i].length; j++)
                table[i][j] = array[k++];
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

	static String[][] pair(String[] members) {
    	Random rand = new Random();
    	
    	String[][] mate = new String[13][2];
        
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
                mate[i][j] = members[temp[k++]];
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

	static void save() throws IOException {
    	
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
        if (size == 0) {
            System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
            return;
        }

        switch (menu) {

            case 1: // CSV형식으로 저장
            	saveCSV();
                break;

            case 2:// txt파일로 저장
            	saveTxT();
                break;

			case 3: // 짝꿍만들기 파일 저장
				savePair();
				break;

            case 4: // 출력포맷으로 저장
            	saveFormat();
                break;
            case 5: // 뒤로가기
            	return;
            default:
                System.out.println("입력값이 올바르지 않습니다.");
                return;
        }

        System.out.println("파일 저장이 완료되었습니다.");

		
	}

	private static void saveFormat() throws IOException {
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

	private static void savePair() throws IOException {
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

	private static void saveTxT() throws IOException {
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

	private static void saveCSV() throws IOException {
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

	static void read() throws IOException {
    	FileInputStream fis = new FileInputStream("res\\seat.csv");
        Scanner fscan = new Scanner(fis);

        int cnt = 0;
        size = 0;
        while (fscan.hasNext()) { // 파일에 내용이 있으면 true, 없으면 false -> 즉, 내용이 있을때 까지 읽기 위함

            String[] line = fscan.nextLine().split(",");
            String[] temp = new String[line.length];

            for (int i = 0; i < line.length; i++) {
                temp[i] = line[i];
                size++;
                if (size == MAX) {
                    System.out.print("파일 속 명단의 수가 최대 입력 인원을 초과하였습니다.");
                    break;
                }
            }
         // 동적으로 테이블 크기 증가 (2차원으로)
            teams = dynamicArray(teams);
            
            teams[cnt] = temp;
            cnt++;

        } // while read
      //------------------------------ 2차원 -> 1차원 ------------------------------
        toArray(teams,members);

        System.out.println("파일 읽기가 완료되었습니다.");
        fscan.close();
        fis.close();
		
	}

	static String[][] dynamicArray(String[][] table) {
            String[][] buffer = new String[table.length + 1][];

            for (int j = 0; j < table.length; j++) {
                buffer[j] = new String[table[j].length];
                for (int i = 0; i < table[j].length; i++)
                    buffer[j][i] = table[j][i];
            }
            table = buffer;
            
            return table;
        }
	
	private static void print(String[][] teams) {
    	printseat(teams); // 디버깅
        
        if (size < 26) {
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

	static String[][] shuffle(String[][] teams, String[] members) {
    	//------------------------------ 예외 처리 ------------------------------
        if (size == 0) {
            System.out.println("학생 명단이 없습니다. 명단을 먼저 읽기/입력해주세요.");
            return null;
        }
        
        Random random = new Random(); 
      //------------------------------ 랜덤 배열 뽑기 ------------------------------
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

      //------------------------------ 2차원 -> 1차원 ------------------------------
        toArray(teams,members);
     
        printseat(teams); // 디버깅
        
        return teams;	
	}

    
} // class

