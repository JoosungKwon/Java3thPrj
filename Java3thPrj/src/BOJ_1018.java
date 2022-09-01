/* 백준 1018번 체스판 다시 칠하기
* MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드가 주어진다.
* 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
* 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
* 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야한다.
* 당연히 8*8 크기는 아무데서나 골라도 된다 --> 브루트 포스
* 다시 칠해야 하는 정사각형의 최소 개수를 구하라
* 입력
* 첫째 줄에 N과 M이 주어진다. (8 <= N,M<= 50)
* 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다.
* B는 검은색이며, W는 흰색이다.
* 출력
* 지민이가 다시 칠해야 하는 정사각형 개수의 <최솟값>
* */

/* 아이디어(sudo code)
* 0. 두가지 경우 흰색 혹은 검은색으로 시작하는 경우를 둘다 고려해야하는가?
* 1. 주어지는 행렬을 입력받는다. -->  ArrayList
* 2. 흰색으로 시작하는 경우 일때 다시 칠해야 하는 개수와 검은 색으로 시작했을 때 경우를 찾는 함수를 만든다.
* 3. 둘 중 최솟값을 저장한다.
* 4. for문을 통해 8*8의 크기로 전체 행렬에서 모든 경우를 다 검색한다.
* */

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1018 {
    public static void main(String[] args) {
    	// 입력 장치
    	Scanner input = new Scanner(System.in);
    	// 행렬 범위 입력
    	int N = input.nextInt();
    	int M = input.nextInt();
    	
    	// 행렬을 저장하기 위한 자료구조
    	ArrayList<String>[] chessMatrix = new ArrayList[N];
    	for(int i = 0; i<N; i++) {
    		chessMatrix[i] = new ArrayList<String>(); 
    	}
    	input.nextLine(); // 개행제거
    	
    	for(int i=0; i<N; i++) {
    		String[] Line = input.nextLine().split("");
    		for(int j=0; j<M; j++) {
    			chessMatrix[i].add(Line[j]);
    		}
    	}
    	int min_value = 65;
    	for(int i=0; i<N-8; i++) {
    		for(int j=0; j<M-8; j++) {
    			int white = startWhite(chessMatrix,i,j);
    			int black = startBlack(chessMatrix,i,j);
    			min_value = Math.min(min_value, Math.min(white, black));
    		}
    	}
    	System.out.println(min_value);
    }
    static int startWhite(ArrayList<String>[] matrix, int i, int j) {
    	int cnt = 0 ;
    	for(int x = i; x < i+8; x++ ) {
    		for(int y = j; y < j+8; y++ ) {
        		if(i % 2 ==0) {
        			if(matrix[i].get(j) != "W") {
        				cnt ++;
        			}
        		}else {
        			if(matrix[i].get(j) != "B") {
        				cnt ++;
        			}
        		}
    		}
    	}
    	return cnt;
    }
    
    static int startBlack(ArrayList<String>[] matrix, int i, int j) {
    	int cnt = 0;
    	for(int x = i; x < i+8; x++ ) {
    		for(int y = j; y < j+8; y++ ) {
        		if(i % 2 ==0) {
        			if(matrix[i].get(j) != "B") {
        				cnt ++;
        			}
        		}else {
        			if(matrix[i].get(j) != "W") {
        				cnt ++;
        			}
        		}
    		}
    	}
    	return cnt;
    }
}
