package com.newlecture.kwonjoosung.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
	
	static Socket socket ;
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(8080);
		
//		while(true) -> 계속 응답?

//		===================== 서버 연결 =================================================================
		try {
			// 소켓 생성
			socket = server.accept();
			System.out.println(socket.getInetAddress()+":"+socket.getLocalPort()+"님이 입장하였습니다.");
			
			// 멀티 스레드를 활용하기 위함 입력 출력이 자유롭게 이뤄지기 위해 -> 나는 굳이? 1대 1 오목서버 구현이 1차 목표
//			Sender sender = new Sender(socket);
//			Receiver receiver = new Receiver(socket);

//			sender.start();
//			receiver.start();

//		===================== 게임 연결 =================================================================
		
			int size = 12 ;
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 안전한 입력을 받아서 사이즈 넘겨 주기
			
			while(true) {
				try{
					output.println("오목판의 사이즈를 입력하세요(12 ~ 100): ");
					size = Integer.parseInt(input.readLine());
					
					if(size < 12  || 100 < size) {
						output.println("입력 범위를 넘어갔습니다. 다시 입력해주세요.");
						continue;
					}
					
					break;
					
				} catch (Exception e) {
					output.println("오류입니다. 다시 입력해주세요.");
				}
			}
				
				// 앞단 화면 만들기
				output.println("게임을 실행합니다.");
				OmokServer omokGame = new OmokServer(size,socket) ;
				omokGame.start();
			

		
		} catch (Exception e) {
			System.out.println("클라이언트가 나갔습니다.");
			server.close();
		}
		
	}

}
