package newlec.practice.javaProgramming;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

// 로또 번호 추첨 시뮬레이션 프로그램

public class Lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력장치
		Random rand = new Random(); // 랜덤번호 추출기 로또 번호를 뽑는 기계
		DecimalFormat formatter = new DecimalFormat("###,###"); // 당첨금을 회계형식으로 보여주기 위해서
		
		TreeSet<Integer> select = new TreeSet<>(); // 선택한 번호를 저장하는 자료구조 (내림차순 정렬된 상태로 보는게 좋아서 Treeset 사용)
		TreeSet<Integer> result = new TreeSet<>(); // 이번주 로또 번호를 저장하는 자료구조
		
		// 입력 화면
		System.out.print("┌────────────────────────────────────┐\n");
		System.out.print("│              로또 복권               │\n");
		System.out.print("└────────────────────────────────────┘\n");
		
		// 번호를 입력 받는 창 
		for(int i =0; i<6;i++) {
			System.out.print("번호를 입력하세요: ");
			int selectNum = Integer.parseInt(sc.nextLine());
			if(select.contains(selectNum)) {
				System.out.println("이미 선택한 번호입니다."); // 중복 방지
				--i; continue; // 총 6번만 입력받아야 하기 때문에 늘어난 cnt는 줄여주어야 함
			}
			if(!(0 < selectNum && selectNum < 46)) { // 사용자 1~45번 사이의 값만 입력할 수 있도록 함
				System.out.println(" 1 ~ 45 사이의 번호를 입력해주세요.");
				--i; continue;
			}
			select.add(selectNum);
			// 선택한 번호도 실시간으로 보여주기 위해
			System.out.print("선택하신 번호: ");
			for(int x: select) {
				System.out.printf("%d ",x);
			}
			System.out.println();
		}
		
		// 로또 번호 추출기
		while(result.size()<6) {
			int num = rand.nextInt(45);
			if(result.contains(num)) {
				continue;
			}
			result.add(++num);
		}
		
		// 보너스 숫자 추출
		int bonusNum = rand.nextInt(45)+1;
		while(result.contains(bonusNum)) {
			bonusNum = rand.nextInt(45)+1;
		}
		
		// next
		// 이번주 로또의 결과화면
		System.out.print("┌────────────────────────────────────┐\n");
		System.out.print("│              로또 결과               │\n");
		System.out.print("└────────────────────────────────────┘\n");
		
		// 이번주 로또의 결과(보너스 포함)를 보여준다.
		System.out.print("이번주 로또 번호:");
		for(int n : result) {
			System.out.printf("%d ",n);
		}
		System.out.printf(" 보너스 번호: %d%n",bonusNum);
		
		// 총 당첨금 산정 (최대 21억)
		int jackpot = 0;
		while(jackpot<1000000000) {
			jackpot = rand.nextInt();
		}
		System.out.printf("이번주 당첨금은 %s 입니다. %n",formatter.format(jackpot));
		
		// 당첨 결과를 판단하기 위한 연산 
		boolean bonus = select.contains(bonusNum); // 보너스 번호를 맞았다면 true 아니면 false
		result.retainAll(select); // 결과랑 선택한 번호랑의 교집합 -> 남은 result 집합은 선택한 숫자 중에 맞은 값만 남는다.  
		select.removeAll(result); // 선택한 숫자중에서 맞은 값만 차집합 -> 따라서, 남은 select 집합은 선택한 숫자 중에 틀린 값만 나온다.
		
		// 결과 따른 당첨금 분배
		switch (result.size()) { // 맞은 값만 남은 집합의 크기는 곧 맞은 개수와 같다.
		case 0:
		case 1:
		case 2:System.out.printf("안타깝게도 당첨되시지 않으셨습니다. 다음주에 다시 도전 바랍니다.");break; // 2개이하로 맞춘 경우는 당첨금이 없다
		case 3:System.out.printf("5등을 축하드립니다!!!! 당첨금은: %s 원 입니다.%n",formatter.format(5000));break; // 3개를 맞춘 경우는 당첨시 5000원
		case 4:System.out.printf("4등을 축하드립니다!!!! 당첨금은: %s 원 입니다.%n",formatter.format(50000));break; // 4개를 맞춘 경우는 당첨시 5000원
		case 5: // 5개를 맞춘 경우는 보너스 번호가 필요하다. 보너스 번호까지 맞았다면 2등 아니라면 3등
			if(!bonus) {System.out.printf("3등을 축하드립니다!!!! 당첨금은: %s 원 입니다.%n",formatter.format(jackpot*0.001));break;} // 보너스를 맞추지 못한 경우 3등 총 당첨금에 0.001%가 제공된다.
						System.out.printf("2등을 축하드립니다!!!! 당첨금은: %s 원 입니다.%n",formatter.format(jackpot*0.03));break; // 보너스를 맞춘 경우 2등 총 당첨금에 0.03%가 제공된다.
		case 6: System.out.printf("1등을 축하드립니다!!!! 당첨금은: %s 원 입니다.%n",formatter.format(jackpot*0.75)); break; // 다 맞았다면 1등 총 당첨금에 75%가 제공된다. 
		}
		System.out.println();
		
		// 종료 화면
		System.out.print("┌────────────────────────────────────┐\n");
		System.out.print("│             구매 감사드립니다          │\n");
		System.out.print("└────────────────────────────────────┘\n");
		
		// 최종적으로 맞은 번호와 틀린 번호를 알려준다.
		System.out.print("맞은 번호는:");
		if(result.size()!=0) {
		for(int n : result) {
				System.out.printf(" %d",n);
			}
			if(bonus) {System.out.printf("  보너스 번호: %d",bonusNum);}
			System.out.println(" 입니다");
		}else {
			System.out.println(" 없습니다.");
		}
		
		
		System.out.print("틀린 번호는:");
		for(int n : select) {
			System.out.printf(" %d",n);
		}
		System.out.println(" 입니다");
		
	}

}
