package newlec.practice.javaProgramming;

public class SeatPrint {
	
		public static void print(String[][] T) {

			
			//조 편성
			System.out.println("*********조 편성 결과*********");
			System.out.println("(자리 표는 아래 \"4강의실 자리표\" 참고)");
			System.out.println();
			for(int i = 0; i<T.length-1;i++)
			System.out.printf("%d조: %s,%s,%s,%s,%s\n",i,T[i][1],T[i][2],T[i][3],T[i][4],T[i][5]);
			System.out.println();
			
			//선생님들 이름
//			System.out.printf("※선생님: %s\n",teac1);
//			System.out.printf("※멘토1: %s, 멘토2: %s",teac2,teac3);
			System.out.println();
			System.out.println();
			
			//자리배치표
			System.out.print    ("=====================================================================\n");
			System.out.print    ("                            4강의실 자리표                               \n");
			System.out.print    ("=====================================================================\n");
			System.out.println();
			System.out.print    ("┌───────┐ ┌──────────────────────────────────────────────────────────┐\n");
			System.out.print    ("│  Door │ │                       Whiteboard                         │\n");
			System.out.print    ("└───────┘ └──────────────────────────────────────────────────────────┘\n");
			//선생님 자리
			System.out.print    ("                                                            ┌────────┐\n");
			System.out.printf   ("                                                            │  %s  │ \n","뉴렉쌤");
			System.out.print    ("                                                            └────────┘\n");
			//자리
			System.out.println  ("┌─────────────Group1──────────────┬───────────Group4──────────────────┐ ");
			System.out.println  ("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n",T[0][0],T[0][1],T[0][2],T[0][3],T[0][4],T[0][5]);
			System.out.println  ("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
			System.out.println  ("├──────────┐                      │                        ┌──────────┘");
			System.out.println  ("│┌────────┐│┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
			System.out.printf   ("││  %s  │││  %s  │ │  %s  │ │   │  %s  │ │  %s  │││  %s  │\n",T[1][0],T[1][1],T[1][2],T[1][3],T[1][4],T[1][5]);
			System.out.println  ("│└────────┘│└────────┘ └────────┘ │   └────────┘ └────────┘│└────────┘");
			System.out.println  ("│          └───Group2─────────────┼───────────Group5───────┴──────────┐");
			System.out.println  ("│┌────────┐ ┌────────┐ ┌────────┐ │   ┌────────┐ ┌────────┐ ┌────────┐│");
			System.out.printf   ("││  %s  │ │  %s  │ │  %s  │ │   │  %s  │ │  %s  │ │  %s  ││\n",T[2][0],T[2][1],T[2][2],T[2][3],T[2][4],T[2][5]);
			System.out.println  ("│└────────┘ └────────┘ └────────┘ │   └────────┘ └────────┘ └────────┘│");
			System.out.println  ("│                     ┌──Group3───┤                        ┌──────────┘");
			System.out.println  ("│┌────────┐ ┌────────┐│┌────────┐ │   ┌────────┐ ┌────────┐│┌────────┐");
			System.out.printf   ("││  %s  │ │  %s  │││  %s  │ │   │  %s  │ │  %s  │││  %s  │\n",T[3][0],T[3][1],T[3][2],T[3][3],T[3][4],T[3][5]);
			System.out.println  ("│└────────┘ └────────┘│└────────┘ │   └────────┘ └────────┘│└────────┘");
			System.out.println  ("├─────────────────────┘           └─────────────┬──────────┴──────────┐");
			System.out.println  ("│┌────────┐ ┌────────┐ ┌────────┐     ┌────────┐│┌────────┐ ┌────────┐│");
			System.out.printf   ("││  %s  │ │  %s  │ │  %s  │     │  %s  │││  %s  │ │  %s  ││\n",T[4][0],T[4][1],T[4][2],T[4][3],T[4][4],T[4][5]);
			System.out.println  ("│└────────┘ └────────┘ └────────┘     └────────┘│└────────┘ └────────┘│");
			System.out.println  ("└───────────────────────────────────────────────┴───────Mentor────────┘ ");                    
			
			
		}


}
