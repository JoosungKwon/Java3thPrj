package newlec.practice.javaProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomSeat {

	public static void main(String[] args) throws IOException {
		
		// 자리를 랜덤하게 선택하기 위한 객체
		Random random = new Random();

		// 학생들 이름이 저장되어 있는 txt파일을 읽어온다
		// 파일을 읽어오기 위한 객체들
		File f = new File("C:\\Users\\ict04-13\\git\\Java3thPrj\\Java3thPrj\\res\\randomseat.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
//		FileWriter fw = new FileWriter(f);

		
		// 학생들을 저장할 리스트 맵으로 구현 해도 괜찮다
		ArrayList<String> memberList = new ArrayList<>();
		String name ;
		while ((name = br.readLine()) != null) {
			memberList.add(name.trim());
		}

		// 학생들이 안고 있는 자리 <2차원 배열(테이블) 형태로 구현하였다.> -> 0,0 제일 왼쪽 자리 4,5는 제일 끝자리
		String[][] seatTable = new String[5][6];
		
		// 스태프님들은 뒷자리 고정
		// 고정자리!
		//seatTable[4][3] = "_뉴렉쌤" ;
		seatTable[4][4] = "멘토쌤" ;
		seatTable[4][5] = "멘토쌤" ;
		seatTable[1][5] = "빈자리" ;
		seatTable[3][5] = "빈자리" ;
		
	
		// 조장 뽑기 기능
		ArrayList<String> leaderList = new ArrayList<>();
		System.out.print("이번 달 조장은:");
		for(int i = 0; i<5; i++) {
			int randomNum = random.nextInt(memberList.size());
			String leader = memberList.get(randomNum);
			System.out.printf(" %s",leader);
			leaderList.add(leader);
			memberList.remove(leader); // 추후에 map,set으로 구현해보는 것도 좋음
			seatTable[i][0] = leader; // 순서대로 조장이 되는 것도 괜찮다
		}System.out.println();
		
		// 랜덤 자리 배정! 1조에 한명씩 (총 5개조)
		// 조장부터 각줄에 1명씩 배정
		
//		for(int i = 0; i<5; i++) {
//			int randomNum = random.nextInt(leaderList.size());
//			seatTable[i][0] = leaderList.get(randomNum);
//			leaderList.remove(randomNum);
//		} 
		
		// 랜덤으로 조 편성 기능
		ArrayList<String> temp = memberList ;
//		Scanner scanner = new Scanner(System.in); 직접 반복 횟수를 지정해주는 걸로 해도 됨
		// 일단은 20명 만
		for(int i = 0; i<5; i++) {
			for(int j = 1;j<6 ;j++) {
				if(seatTable[i][j]==null) {
					int randomNum = random.nextInt(temp.size());
					seatTable[i][j] = temp.get(randomNum);
					temp.remove(randomNum);
				}
			}
		}
		// 남는 인원 한명 처리..  
		//seatTable[4][3] = temp.get(0);
		
		
		SeatPrint.print(seatTable);
		//PrintSeatTable.print(seatTable);
		
		// 새롭게 선정된 조로 내용 초기화
		//fw.close();
		
	}

	static void printseat (String[][] seatTable) {
		// 디버깅용 코드
		for(int i = 0; i<5; i++) {
			System.out.printf("---- %d조 ----%n",i+1);
			for(int j = 0; j<6;j++) {
				System.out.println(seatTable[i][j]);
			}
		}
		
	}

}
