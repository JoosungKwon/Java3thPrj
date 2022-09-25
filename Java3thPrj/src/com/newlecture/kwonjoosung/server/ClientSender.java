package com.newlecture.kwonjoosung.server;
//package com.newlecture.ch3.server;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//class ClientSender extends Thread {
//	
//	Socket socket;
//
//	ClientSender(Socket socket) {
//		this.socket = socket;
//
//	}
//	
//	@Override
//	public void run() {
//		
//		try {
//			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
//			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//			String data;
//			
//			while (true) {
//				
//				data = input.readLine();
//				
//				if(data.equals("exit")) {
//					System.out.println("연결을 종료합니다.");
//					break;
//				} else {
//					output.println(data);
//				}
//
//			}
//			
//		}catch (IOException e) {
//			System.out.println("서버와 연결이 끊어졌습니다.");
//			}
//		}
//	}