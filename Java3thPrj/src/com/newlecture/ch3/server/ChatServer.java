package com.newlecture.ch3.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String[] args) throws IOException {
			
		while(true) {
			try {
				
				ServerSocket server = new ServerSocket(8080);
				Socket socket = server.accept();
				System.out.println("서버가 켜졌습니다.");
				Sender sender = new Sender(socket);
				Receiver receiver = new Receiver(socket);

				sender.start();
				receiver.start();

			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}
}

class Sender extends Thread {
	Socket socket;

	Sender(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			
			PrintWriter output = new PrintWriter(socket.getOutputStream());
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String data;
			
			while (true) {
				
				data = input.readLine();
				
				output.print(data);
				output.flush();
				
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

class Receiver extends Thread {
	Socket socket;

	Receiver(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data;
			
			while (true) {
				
				data = input.readLine();
				
				if(data==null)
					break;
				 
				System.out.println("사용자: " + data);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
