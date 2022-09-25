package com.newlecture.kwonjoosung.server;
//package com.newlecture.ch3.server;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.Socket;
//
//class ClientReceiver extends Thread {
//	Socket socket;
//	ClientReceiver(Socket socket) {
//		this.socket = socket;
//	}
//	@Override
//	public void run() {
//		try {
//			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			String data;
//			while (true) {
//				data = input.readLine();
//				System.out.println(data);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
