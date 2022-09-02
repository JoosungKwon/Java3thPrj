package com.newlecture.ch3.fileio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOPractice2 {
	static String[][] omokTable = new String[12][12];

	public static void main(String[] args) {

		// 서버 소켓을 생성해서 대기 상태로 만듦
		// 클라이언트에서 연결 요청이 오면 소켓을 생성해서 열결시킴
		try (ServerSocket server = new ServerSocket(8080); Socket socket = server.accept()) {

			// 연결이 되었으므로 데이터를 전송해줄 스트림 통로를 생성함
			OutputStream out = socket.getOutputStream();

			// 속도 향상을 위해 버퍼 필터 스트림을 사용함 (선택사항)
			BufferedOutputStream bufOut = new BufferedOutputStream(out);
			
			setting();
			// 연결되면 보낼 데이터
			String[][] sendData = omokTable;

			// 버퍼에 먼저 내용을 넣음
			// (바로 출력하는 것이 아님에 주의, 버퍼에 출력하는 것)
			
			
			for (int y = 0; y < omokTable.length; y++) {
				for (int x = 0; x < omokTable[0].length; x++) {
					System.out.printf("%s", omokTable[y][x]);
					bufOut.write(sendData[y][x].getBytes());
					bufOut.flush();
				}
				System.out.println();
			}
			
			

			// 버퍼에 있는 내용을 실제로 출력함
			

		} catch (IOException e) {

			System.out.println("연결에 실패했습니다.");
		}

		// try-catch-finally를 사용했다면 socket.close()로 소켓연결을 닫아줘야함
	}

	private static void setting() {
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

}
