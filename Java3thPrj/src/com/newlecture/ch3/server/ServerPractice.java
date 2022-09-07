//package com.newlecture.ch3.server;
//
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Scanner;
//
//public class ServerPractice {
//	HashMap clients;
//
//	ServerPractice() {
//		clients = new HashMap();
//		Collections.synchronizedMap(clients);
//	}
//
//	public static void main(String[] args) {
//		new ServerPractice().start();
//	}
//
//	public void start() {
//		ServerSocket serverSocket = null;
//		Socket socket = null;
//
//		try {
//			serverSocket = new ServerSocket(8080);
//			System.out.println("서버가 켜졌습니다.");
//
//			while (true) {
//				socket = serverSocket.accept();
//				System.out.println("접속 정보: " + socket.getInetAddress() + ":" + socket.getPort());
//				ServerReceiver thread = new ServerReceiver(socket);
//				thread.start();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	void sendToAll(String message) {
//		Iterator it = clients.keySet().iterator();
//
//		while (it.hasNext()) {
//			try {
//				PrintWriter output = (PrintWriter) clients.get(it.next());
//				output.print("단체 방송");
//			} catch (Exception e) {
//			}
//		}
//	}
//
//	class ServerReceiver extends Thread {
//		Socket socket;
//		Scanner input;
//		PrintWriter output;
//
//		ServerReceiver(Socket socket) {
//			this.socket = socket;
//			try {
//				input = new Scanner(socket.getInputStream());
//				output = new PrintWriter(socket.getOutputStream(),true);
//			} catch (Exception e) {
//			}
//		}
//
//		public void run() {
//			String name = " ";
//
//			try {
//				name = input.nextLine();
//				System.out.println("입력 ok4");
//				sendToAll(name + "님이 들어오셨습니다.");
//				System.out.println("입력 ok5");
//				clients.put(name, output);
//				System.out.println("현재 접속자 수는" + clients.size() + "입니다.");
//
//				while (input != null) {
//					String data = input.nextLine();
//					sendToAll(data);
//					System.out.println("입력 ok6");
//				}
//			} catch (Exception e) {
//
//			} finally {
//				sendToAll(name + "님이 나가셨습니다.");
//				clients.remove(name);
//			}
//
//		}
//	}
//}
