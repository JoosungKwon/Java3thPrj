//package com.newlecture.ch3.server;
//
//import java.net.*;
//import java.io.*;
//import java.util.Scanner;
//
//public class ClientPractice {
//	static Scanner input;
//
//	public static void main(String[] args) {
//		input = new Scanner(System.in);
//
//		String serverIp = "127.0.0.1";
//		int serverPort = 8080;
//		String name = "tq";
//
//		try {
//			Socket socket = new Socket(serverIp, serverPort);
//			System.out.println("서버에 연결하였습니다.");
//			name = input.nextLine();
//			Thread sender = new Thread(new ClientSender(socket, name));
//			Thread receiver = new Thread(new ClientReceiver(socket));
//
//			sender.start();
//			receiver.start();
//		} catch (UnknownHostException ue) {
//			ue.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	static class ClientSender extends Thread {
//		Socket socket;
//		PrintStream output;
//		String name;
//
//		ClientSender(Socket socket, String name) {
//			this.socket = socket;
//			this.name = name;
//
//			try {
//				output = new PrintStream(socket.getOutputStream());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		public void run() {
//			try {
//				if (output != null) {
//					output.print(name);
//					System.out.println("입력 ok1");
//				}
//				while (output != null) {
//					String data = input.nextLine();
//					output.print(data);
//					System.out.println("입력 ok2");
//				}
//			} catch (Exception e) {
//			}
//		}
//	}
//
//	static class ClientReceiver extends Thread {
//		Scanner in;
//		Socket socket;
//
//		ClientReceiver(Socket socket) {
//			this.socket = socket;
//			try {
//				in = new Scanner(socket.getInputStream());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		public void run() {
//			while (in != null) {
//				String data = in.nextLine();
//				System.out.println(data);
//				System.out.println("입력 ok3");
//			}
//		}
//	}
//
//}

