//package com.newlecture.ch3.server;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class ChatServer {
//	public static void main(String[] args) throws IOException {
//		ServerSocket server = new ServerSocket(8080);
//		
//		while(true) {
//			try {
//				
//				Socket socket = server.accept();
//				System.out.println("서버가 켜졌습니다.");
//				Sender sender = new Sender(socket);
//				Receiver receiver = new Receiver(socket);
//
//				sender.start();
//				receiver.start();
//				Main.main(sender,receiver);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				break;
//			}
//		}
//	}
//}




